import HttpUtil

FAULT_CATEGORY_MAPPING = ["TBOX", "EMS", "ESC", "EPS", "TCU", "SRS", "ICM", "MP5", "PEPS", "PDC", "ESCL", "HVAC", "AVM", "BCM", "BSD", "SLC", "MRR", "MPC", "LDFC", "APA", "IMMO", "CFP", "PLG", "FPCM" ]

# 统计data中故障车辆, 故障单元和故障的数量
def error_digits_counter(data):
    error = {}
    vin_counter = 0
    fault_category_counter = 0
    error_content_counter = 0
    for d in data:
        vin = d['vin']
        fault_category = d['faultCategory']
        error_content = d['errorContent']
        if vin not in error.keys():
            error[vin] = {}
            error[vin]["faultCategory"] = set()
            error[vin]["errorContent"] = set()
        error[vin]["faultCategory"].add(fault_category)
        error[vin]["errorContent"].add(error_content)
    for e in error:
        vin_counter += 1
        fault_category_counter += len(error[e]["faultCategory"])
        error_content_counter += len(error[e]["errorContent"])
    return {"vin": vin_counter, "faultCategory": fault_category_counter,
            "errorContent": error_content_counter}


def today_error_counter():
    data = HttpUtil.get_my_warning_response(24)
    return error_digits_counter(data)


def yesteday_error_counter():
    data = HttpUtil.get_my_warning_response(24 * 2)
    return error_digits_counter(data)


def weekly_error_counter():
    data = HttpUtil.get_my_warning_response(24 * 7)
    return error_digits_counter(data)


def hourly_error_counter():
    counter_list = []
    error_list = {'vin': [], 'faultCategory': [], 'errorContent': []}
    for hour in range(24, -1, -1):
        data = HttpUtil.get_my_warning_response(hour)
        counter_list.append(error_digits_counter(data))
    for i in range(0, 24):
        error_car = counter_list[i]['vin'] - counter_list[i + 1]['vin']
        error_category = counter_list[i]['faultCategory'] - counter_list[i + 1]['vin']
        error_content = counter_list[i]['errorContent'] - counter_list[i + 1]['errorContent']
        error_list['vin'].append({'value': error_car})
        error_list['faultCategory'].append({'value': error_category})
        error_list['errorContent'].append({'value': error_content})
    return error_list


def fault_category_counter():
    data = HttpUtil.get_my_warning_response(24)
    fault_category_dict = {}
    for d in data:
        fault_category = d['faultCategory']
        if fault_category not in fault_category_dict:
            fault_category_dict[fault_category] = 0
        fault_category_dict[fault_category] += 1
    fault_category_dict = dict(sorted(fault_category_dict.items(), key=lambda item: item[1], reverse=True))
    counter = 0
    pie = []
    for key in fault_category_dict.keys():
        counter += 1
        if counter == 1:
            key_mapping = FAULT_CATEGORY_MAPPING[int(key, 16)]
            pie.append({'name': key_mapping, 'value': fault_category_dict[key], 'color': 'primary'})
        elif counter == 2:
            key_mapping = FAULT_CATEGORY_MAPPING[int(key, 16)]
            pie.append({'name': key_mapping, 'value': fault_category_dict[key], 'color': 'secondary'})
        elif counter == 3:
            key_mapping = FAULT_CATEGORY_MAPPING[int(key, 16)]
            pie.append({'name': key_mapping, 'value': fault_category_dict[key], 'color': 'warning'})
        else:
            counter += fault_category_dict[key]
    counter -= len(fault_category_dict)
    pie.append({'name': '其他', 'value': counter, 'color': 'success'})
    return pie


def daily_analysis():
    today = today_error_counter()
    yesterday = yesteday_error_counter()
    weekly = weekly_error_counter()
    error_yesterday = (yesterday['errorContent'] - today['errorContent']) % 100
    error_weekly = (weekly['errorContent'] / 7) % 100
    error_chart_data = hourly_error_counter()
    pie = fault_category_counter()
    error = {'errorCounter': today['errorContent'],
             'errorCarCounter': today['vin'],
             'errorCategoryCounter': today['faultCategory'],
             'errorYesterday': error_yesterday,
             'errorAvgWeekly': error_weekly,
             'errorData': error_chart_data['errorContent'],
             'errorCarData': error_chart_data['vin'],
             'errorCategoryData': error_chart_data['faultCategory'],
             'errorCategoryPie': pie}
    return error



