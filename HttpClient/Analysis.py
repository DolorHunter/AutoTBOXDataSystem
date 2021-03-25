import HttpUtil
import time
import datetime

FAULT_CATEGORY_MAPPING = ["TBOX", "EMS", "ESC", "EPS", "TCU", "SRS", "ICM", "MP5", "PEPS", "PDC", "ESCL", "HVAC", "AVM", "BCM", "BSD", "SLC", "MRR", "MPC", "LDFC", "APA", "IMMO", "CFP", "PLG", "FPCM" ]


# 统计data中故障车辆, 故障单元和故障的数量
def error_digits_counter(data):
    error_vin_category_pair = set()
    error_vin = set()
    error_content_counter = 0
    if data:
        for d in data:
            error_content_counter += 1
            error_vin.add(d['vin'])
            error_vin_category_pair.add((d["vin"], d["faultCategory"]))
    return {"vin": len(error_vin), "faultCategory": len(error_vin_category_pair),
            "errorContent": error_content_counter}


# 昨日故障统计
def yesterday_error_counter():
    localtime = time.localtime()
    end_time = int(time.time() - localtime.tm_hour * 3600 - localtime.tm_min * 60 - localtime.tm_sec) * 1000
    start_time = end_time - 24 * 60 * 60 * 1000
    data = HttpUtil.get_my_warning_response(start_time=start_time, end_time=end_time)
    return error_digits_counter(data)


# 过去一周故障统计
def weekly_error_counter():
    localtime = time.localtime()
    end_time = int(time.time() - localtime.tm_hour * 3600 - localtime.tm_min * 60 - localtime.tm_sec) * 1000
    start_time = end_time - 7 * 24 * 60 * 60 * 1000
    data = HttpUtil.get_my_warning_response(start_time=start_time, end_time=end_time)
    return error_digits_counter(data)


# 昨日故障统计(小时图)
def yesterday_error_counter_hourly():
    error_list = {'vin': [], 'faultCategory': [], 'errorContent': []}
    localtime = time.localtime()
    yesterday = int(time.time() - localtime.tm_hour * 3600 - localtime.tm_min * 60 - localtime.tm_sec - 24 * 60 * 60)*1000
    for i in range(0, 24):
        start_time = yesterday + i * 60 * 60 * 1000
        end_time = start_time + 60 * 60 * 1000
        data = HttpUtil.get_my_warning_response(start_time=start_time, end_time=end_time)
        counter = error_digits_counter(data)
        error_list['vin'].append({'value': counter['vin']})
        error_list['faultCategory'].append({'value': counter['faultCategory']})
        error_list['errorContent'].append({'value': counter['errorContent']})
    return error_list


# 过去一周故障统计(天图)
def last_week_error_counter_daily():
    error_list = []
    localtime = time.localtime()
    last_week = int(time.time() - localtime.tm_hour * 3600 - localtime.tm_min * 60 - localtime.tm_sec - 7 * 24 * 60 * 60)*1000
    for i in range(0, 7):
        start_time = last_week + i * 24 * 60 * 60 * 1000
        end_time = start_time + 24 * 60 * 60 * 1000
        data = HttpUtil.get_my_warning_response(start_time=start_time, end_time=end_time)
        counter = error_digits_counter(data)
        error_list.append({"date": str(datetime.datetime.fromtimestamp(start_time / 1000).date()),
                           "故障车辆": str(counter['vin']), "故障单元": str(counter['faultCategory']),
                           "故障": str(counter['errorContent'])})
    return error_list


# 故障单元统计
def fault_category_counter():
    localtime = time.localtime()
    end_time = int(time.time() - localtime.tm_hour * 3600 - localtime.tm_min * 60 - localtime.tm_sec) * 1000
    start_time = end_time - 24 * 60 * 60 * 1000
    data = HttpUtil.get_my_warning_response(start_time=start_time, end_time=end_time)
    fault_category_dict = {}
    if data:
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


# 每日更新故障(昨日故障分析，过去七天故障分析)
def daily_analysis():
    yesterday = yesterday_error_counter()
    weekly = weekly_error_counter()
    error_yesterday = yesterday['errorContent']
    error_weekly = weekly['errorContent'] / 7
    if error_yesterday > 0 and error_weekly > 0:
        zoom = 80 / max(int(error_yesterday), int(error_weekly))
        error_yesterday *= zoom
        error_weekly *= zoom
    error_chart_data = yesterday_error_counter_hourly()
    pie = fault_category_counter()
    # 过去七天故障分析
    error_last_week = last_week_error_counter_daily()
    error = {'errorCounter': yesterday['errorContent'],
             'errorCarCounter': yesterday['vin'],
             'errorCategoryCounter': yesterday['faultCategory'],
             'errorYesterday': error_yesterday,
             'errorAvgWeekly': error_weekly,
             'errorData': error_chart_data['errorContent'],
             'errorCarData': error_chart_data['vin'],
             'errorCategoryData': error_chart_data['faultCategory'],
             'errorCategoryPie': pie,
             'errorLastWeek': error_last_week}
    return error
