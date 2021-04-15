import HttpUtil
import time
import datetime

FAULT_CATEGORY_MAPPING = ["TBOX", "EMS", "ESC", "EPS", "TCU", "SRS", "ICM", "MP5", "PEPS", "PDC", "ESCL", "HVAC", "AVM", "BCM", "BSD", "SLC", "MRR", "MPC", "LDFC", "APA", "IMMO", "CFP", "PLG", "FPCM"]


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
    data = HttpUtil.get_my_warning_response(start_time=start_time, end_time=end_time, url="1")
    return error_digits_counter(data)


# 过去一周故障统计
def weekly_error_counter():
    localtime = time.localtime()
    end_time = int(time.time() - localtime.tm_hour * 3600 - localtime.tm_min * 60 - localtime.tm_sec) * 1000
    start_time = end_time - 7 * 24 * 60 * 60 * 1000
    data = HttpUtil.get_my_warning_response(start_time=start_time, end_time=end_time, url="1")
    return error_digits_counter(data)


# 今年故障统计
def yearly_error_counter():
    localtime = time.localtime()
    tm_today = datetime.date.today().timetuple().tm_yday
    end_time = int(time.time() - localtime.tm_hour * 3600 - localtime.tm_min * 60 - localtime.tm_sec) * 1000
    start_time = end_time - tm_today * 24 * 60 * 60 * 1000
    data = HttpUtil.get_my_warning_response(start_time=start_time, end_time=end_time, url="1")
    error = {}
    calender = []
    if data:
        for d in data:
            date = str(datetime.datetime.fromtimestamp(int(d['sendingTime']) / 1000).date())
            if date not in error:
                error[date] = 0
            error[date] += 1
    if error:
        for e in error.keys():
            calender.append({"day": e, "value": error[e]})
    return calender


# 昨日故障统计(小时图)
def yesterday_error_counter_hourly():
    error_list = {'vin': [], 'faultCategory': [], 'errorContent': []}
    localtime = time.localtime()
    yesterday = int(time.time() - localtime.tm_hour * 3600 - localtime.tm_min * 60 - localtime.tm_sec - 24 * 60 * 60)*1000
    for i in range(0, 24):
        start_time = yesterday + i * 60 * 60 * 1000
        end_time = start_time + 60 * 60 * 1000
        data = HttpUtil.get_my_warning_response(start_time=start_time, end_time=end_time, url="1")
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
        data = HttpUtil.get_my_warning_response(start_time=start_time, end_time=end_time, url="1")
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
    data = HttpUtil.get_my_warning_response(start_time=start_time, end_time=end_time, url="1")
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


# 仪表盘(dashboard)的每日更新故障(昨日故障分析，过去七天故障分析)
def dashboard_daily_analysis():
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
    # 过去七天故障统计
    error_last_week = last_week_error_counter_daily()
    # 今年故障统计
    error_yearly = yearly_error_counter()
    error = {'errorCounter': yesterday['errorContent'],
             'errorCarCounter': yesterday['vin'],
             'errorCategoryCounter': yesterday['faultCategory'],
             'errorYesterday': error_yesterday,
             'errorAvgWeekly': error_weekly,
             'errorData': error_chart_data['errorContent'],
             'errorCarData': error_chart_data['vin'],
             'errorCategoryData': error_chart_data['faultCategory'],
             'errorCategoryPie': pie,
             'errorLastWeek': error_last_week,
             'errorYearly': error_yearly}
    return error


# 获取30天数据故障
def get_30days_data(url):
    localtime = time.localtime()
    end_time = int(time.time() - localtime.tm_hour * 3600 - localtime.tm_min * 60 - localtime.tm_sec) * 1000
    start_time = end_time - 30 * 24 * 60 * 60 * 1000
    data = HttpUtil.get_my_warning_response(start_time=start_time, end_time=end_time, url=url)
    return data


# 散点图生成
def gen_scatter_plot(data):
    scatter_plot = []
    error = {}
    if data:
        for d in data:
            fault_category = d[3]
            error_list_count = d[6]
            if fault_category not in error:
                error[fault_category] = {}
            if error_list_count not in error[fault_category]:
                error[fault_category][error_list_count] = 0
            error[fault_category][error_list_count] += 1
    for e in error:
        category_data = []
        for ek in error[e].keys():
            category_data.append({'x': ek, 'y': error[e][ek]})
        key_mapping = FAULT_CATEGORY_MAPPING[int(e, 16)]
        scatter_plot.append({'id': key_mapping, 'data': category_data})
    return scatter_plot


# 树形图生成
def gen_treemap(data):
    error = {}
    if data:
        for d in data:
            car_name = d[2]
            fault_category = d[3]
            error_detail = d[5]
            if car_name not in error:
                error[car_name] = {}
            if fault_category not in error[car_name]:
                error[car_name][fault_category] = {}
            if error_detail not in error[car_name][fault_category]:
                error[car_name][fault_category][error_detail] = 0
            error[car_name][fault_category][error_detail] += 1
    treemap_data = []
    for e in error:
        treemap_father_data = []
        for ek in error[e].keys():
            treemap_children_data = []
            for ekk in error[e][ek]:
                grand_children = {'name': ekk, 'value': error[e][ek][ekk]}
                treemap_children_data.append(grand_children)
            key_mapping = FAULT_CATEGORY_MAPPING[int(ek, 16)]
            children = {'name': key_mapping, 'children': treemap_children_data}
            treemap_father_data.append(children)
        father = {'name': e, 'children': treemap_father_data}
        treemap_data.append(father)
    treemap = {'name': '故障', 'children': treemap_data}
    return treemap


# 条形图生成
def gen_bar(data):
    bar = []
    error = {}
    if data:
        for d in data:
            car_name = d[2]
            fault_category = d[3]
            if car_name not in error:
                error[car_name] = {}
            if fault_category not in error[car_name]:
                error[car_name][fault_category] = 0
            error[car_name][fault_category] += 1
    for e in error:
        bar_data = {'carName': e}
        for ek in error[e].keys():
            key_mapping = FAULT_CATEGORY_MAPPING[int(ek, 16)]
            bar_data[key_mapping] = error[e][ek]
        bar.append(bar_data)
    return bar


# 条形图生成2
def gen_bar2(data):
    bar = []
    error = {}
    if data:
        for d in data:
            _4SShop = d[9]
            fault_category = d[3]
            if _4SShop not in error:
                error[_4SShop] = {}
            if fault_category not in error[_4SShop]:
                error[_4SShop][fault_category] = 0
            error[_4SShop][fault_category] += 1
    for e in error:
        bar_data = {'4SShop': e}
        for ek in error[e].keys():
            key_mapping = FAULT_CATEGORY_MAPPING[int(ek, 16)]
            bar_data[key_mapping] = error[e][ek]
        bar.append(bar_data)
    return bar


# 概览(general)的每日更新故障(散点图, 树形图)
def general_daily_analysis():
    data = get_30days_data(url="2")
    scatter_plot = gen_scatter_plot(data)
    treemap = gen_treemap(data)
    bar = gen_bar(data)
    bar2 = gen_bar2(data)
    error = {'scatterPlot': scatter_plot,
             'treemap': treemap,
             'bar': bar,
             'bar2': bar2}
    return error


# 地图位置标记生成
def gen_maps_pin(data):
    error = {}
    maps = []
    if data:
        for d in data:
            latitude = d['latitude'][:-2]
            longitude = d['longitude'][:-2]
            if latitude and longitude:
                if latitude + " " + longitude not in error.keys():
                    error[latitude + " " + longitude] = 0
                error[latitude + " " + longitude] += 1
    for e in error.keys():
        geo = str(e).split(" ")
        latitude = geo[0]
        longitude = geo[1]
        counter = str(error[e])
        maps.append({'location': [latitude, longitude], 'option': {'color': 'red', 'text': counter}})
    return maps


# 地图(maps)的每日更新故障(必应地图)
def maps_daily_analysis():
    data = get_30days_data(url="1")
    return gen_maps_pin(data)
