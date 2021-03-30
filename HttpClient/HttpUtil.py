import time
import datetime
import requests
import copy

# 故障请求地址
WARNING_URL = ""
# 故障转存地址
WARNING_SAVE_URL = "http://127.0.0.1:8080/CarWarning/addCarWarning"
# 获取故障地址
MY_WARNING_URL = "http://127.0.0.1:8080/CarWarning/searchCarWarningBySendingTimeBetweenList"
# 获取故障车辆信息地址
MY_WARNING_CAR_URL = "http://127.0.0.1:8080/CarWarning/searchUserCarWarningDetailBySendingTimeBetween"
# 存放数据报表地址
MY_SAVE_VISUAL_CHART_URL = "http://127.0.0.1:8080/VisualChart/addVisualChart"


# 从服务器获取故障信息
def get_warning_response():
    # 故障请求内容(request) 开始结束时间 String startTime, String endTime
    cur_time = int(time.time()) * 1000
    # 24h 前
    start_time = cur_time - 24 * 60 * 60 * 1000
    end_time = cur_time
    # 运行一次抓取一天的故障信息
    warning_input = {'startTime': start_time, 'endTime': end_time}
    # POST方式请求故障信息
    response = requests.post(WARNING_URL, json=warning_input, timeout=5)
    if response.status_code != 200:
        print(time.time(), response, response.text[0:50])
    else:
        return response.json()


# 转存故障信息到我的数据库(数据格式调整)
# response 江淮服务器获取故障信息
def save_warning_to_my_database(response):
    car_list = response['data']['carList']
    for car in car_list:
        car1 = copy.deepcopy(car)
        # 首字母大写JPA无法识别，导致数据库写入失败
        car1['engineTheftPreventionSysFailure'] = car1['EngineTheftPreventionSysFailure']
        car1['autoParkingFailure'] = car1['AutoParkingFailure']
        car1['oilPressure'] = car1['OilPressure']
        car1['electronicParking'] = car1['ElectronicParking']
        car1['windshieldSensorShield'] = car1['WindshieldSensorShield']
        car1['tirePressureMonitoringSysFailure'] = car1['TirePressureMonitoringSysFailure']
        car1['autoBrakSystemStatus'] = car1['AutoBrakSystemStatus']
        car1['electronicStabilitySysIndication'] = car1['ElectronicStabilitySysIndication']
        car1['tirePressureAnomaly'] = car1['TirePressureAnomaly']
        car1['startStopSystemNotWork'] = car1['StartStopSystemNotWork']
        car1['autoEmergencyBrakeSysFailure'] = car1['AutoEmergencyBrakeSysFailure']
        car1.pop('project')
        car1.pop('EngineTheftPreventionSysFailure')
        car1.pop('AutoParkingFailure')
        car1.pop('OilPressure')
        car1.pop('ElectronicParking')
        car1.pop('WindshieldSensorShield')
        car1.pop('TirePressureMonitoringSysFailure')
        car1.pop('AutoBrakSystemStatus')
        car1.pop('ElectronicStabilitySysIndication')
        car1.pop('TirePressureAnomaly')
        car1.pop('StartStopSystemNotWork')
        car1.pop('AutoEmergencyBrakeSysFailure')
        car1['createdBy'] = 'db'
        car1['lastUpdatedBy'] = 'db'
        for fault in car['project']:
            for error in fault['error_list']:
                car1['errorContent'] = error['error_content']
                car1['faultCategory'] = fault['fault_category']
                car1['errorListCount'] = fault['error_list_count']
                # 故障信息转存
                save_response = requests.post(WARNING_SAVE_URL, json=car1)
                if save_response.status_code != 200 or save_response.text != "Succeed.":
                    print(datetime.datetime.now(), save_response, "Save warning to my DB failed!!")


# 从我的数据库取出故障数据
def get_my_warning_response(start_time, end_time):
    warning_input = {'sendingTime': start_time, 'remark': end_time}
    # POST方式请求故障信息
    response = requests.post(MY_WARNING_URL, json=warning_input, timeout=5)
    if response.status_code != 200:
        print(datetime.datetime.now(), response, "Get my warning response failed!!")
        exit(response.status_code)
    else:
        return response.json()


# 从我的数据库取出故障车辆数据(车辆名称, 4S店等信息)
def get_my_warning_car_response(start_time, end_time):
    warning_input = {'sendingTime': start_time, 'remark': end_time}
    # POST方式请求故障信息
    response = requests.post(MY_WARNING_CAR_URL, json=warning_input, timeout=5)
    if response.status_code != 200:
        print(datetime.datetime.now(), response, "Get my warning response failed!!")
        exit(response.status_code)
    else:
        return response.json()


# 存放数据到数据库VisualChart
def save_visual_chart(chart_name, chart_type, json, created_by, last_updated_by):
    save_input = {
        "chartName": chart_name,
        "chartType": chart_type,
        "chartData": str(json),
        "createdBy": created_by,
        "lastUpdatedBy": last_updated_by
    }
    save_response = requests.post(MY_SAVE_VISUAL_CHART_URL, json=save_input, timeout=5)
    if save_response.status_code != 200 or save_response.text != "Succeed.":
        print(datetime.datetime.now(), save_response, "Save visual chart failed!! Chart name:", chart_name)
