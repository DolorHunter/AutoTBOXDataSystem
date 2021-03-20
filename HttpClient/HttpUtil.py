import time
from datetime import datetime
import requests
import copy

# 故障请求地址
WARNING_URL = ""
# 故障转存地址
WARNING_SAVE_URL = "http://127.0.0.1:8080/CarWarning/addCarWarning"
# 获取故障地址
MY_WARNING_URL = "http://127.0.0.1:8080/CarWarning/searchCarWarningBySendingTimeList"
# 存放数据报表地址
MY_SAVE_VISUAL_CHART_URL = "http://127.0.0.1:8080/VisualChart/addVisualChart"

"""
# 示例response（JSON）测试用
response = {
    "data": {
        "carList": [
            {
                "blindSpotMonitoringSysFailure": "0",
                "EngineTheftPreventionSysFailure": "0",
                "batteryCharging": "0",
                "altitude": "0",
                "transmissionFailure": "0",
                "powerSteeringSystemFailure": "0",
                "AutoParkingFailure": "0",
                "adaptiveCruiseFault": "0",
                "engineFailure": "0",
                "stabilitySystemShutdown": "0",
                "OilPressure": "0",
                "slopeSlowDownFault": "0",
                "ElectronicParking": "0",
                "vin": "LJ12EKR24G4913255",
                "startStopSystemFailure": "0",
                "WindshieldSensorShield": "0",
                "longitude": "118.014693",
                "laneDepartureSysFailure": "0",
                "longitudeState": "1",
                "direct": "0",
                "TirePressureMonitoringSysFailure": "0",
                "engineExhaustSystemFailure": "0",
                "powerSteeringSystemInit": "0",
                "AutoBrakSystemStatus": "0",
                "latitudeState": "1",
                "loc": "1",
                "airbagFault": "0",
                "project": [
                    {
                        "error_list": [
                            {
                                "error_content": "96009c"
                            },
                            {
                                "error_content": "c18787"
                            }
                        ],
                        "fault_category": "0c",
                        "error_list_count": "2"
                    }
                ],
                "ElectronicStabilitySysIndication": "0",
                "TirePressureAnomaly": "0",
                "electronicParkingFailure": "0",
                "gpsSpeed": "0.0",
                "latitude": "24.484581",
                "sendingTime": "1560816831000",
                "StartStopSystemNotWork": "0",
                "AutoEmergencyBrakeSysFailure": "0"
            },
            {
                "blindSpotMonitoringSysFailure": "0",
                "EngineTheftPreventionSysFailure": "0",
                "batteryCharging": "0",
                "altitude": "0",
                "transmissionFailure": "0",
                "powerSteeringSystemFailure": "0",
                "AutoParkingFailure": "0",
                "adaptiveCruiseFault": "0",
                "engineFailure": "0",
                "stabilitySystemShutdown": "0",
                "OilPressure": "0",
                "slopeSlowDownFault": "0",
                "ElectronicParking": "0",
                "vin": "LJ12EKR26K4725409",
                "startStopSystemFailure": "0",
                "WindshieldSensorShield": "0",
                "longitude": "117.258572",
                "laneDepartureSysFailure": "0",
                "longitudeState": "1",
                "direct": "0",
                "TirePressureMonitoringSysFailure": "0",
                "engineExhaustSystemFailure": "0",
                "powerSteeringSystemInit": "0",
                "AutoBrakSystemStatus": "0",
                "latitudeState": "1",
                "loc": "1",
                "airbagFault": "0",
                "project": [
                    {
                        "error_list": [
                            {
                                "error_content": "d00100"
                            },
                            {
                                "error_content": "d00200"
                            }
                        ],
                        "fault_category": "04",
                        "error_list_count": "2"
                    },
                    {
                        "error_list": [
                            {
                                "error_content": "d00100"
                            },
                            {
                                "error_content": "d00200"
                            }
                        ],
                        "fault_category": "04",
                        "error_list_count": "2"
                    }
                ],
                "ElectronicStabilitySysIndication": "0",
                "TirePressureAnomaly": "0",
                "electronicParkingFailure": "0",
                "gpsSpeed": "0.0",
                "latitude": "31.739366",
                "sendingTime": "1560821249000",
                "StartStopSystemNotWork": "0",
                "AutoEmergencyBrakeSysFailure": "0"
            },
            {
                "blindSpotMonitoringSysFailure": "0",
                "EngineTheftPreventionSysFailure": "0",
                "batteryCharging": "0",
                "altitude": "0",
                "transmissionFailure": "0",
                "powerSteeringSystemFailure": "0",
                "AutoParkingFailure": "0",
                "adaptiveCruiseFault": "0",
                "engineFailure": "0",
                "stabilitySystemShutdown": "0",
                "OilPressure": "0",
                "slopeSlowDownFault": "0",
                "ElectronicParking": "0",
                "vin": "LJ166A234K4013752",
                "startStopSystemFailure": "0",
                "WindshieldSensorShield": "0",
                "longitude": "117.304713",
                "laneDepartureSysFailure": "0",
                "longitudeState": "1",
                "direct": "90",
                "TirePressureMonitoringSysFailure": "0",
                "engineExhaustSystemFailure": "0",
                "powerSteeringSystemInit": "0",
                "AutoBrakSystemStatus": "1",
                "latitudeState": "1",
                "loc": "1",
                "airbagFault": "0",
                "project": [
                    {
                        "error_list": [
                            {
                                "error_content": "930100"
                            }
                        ],
                        "fault_category": "09",
                        "error_list_count": "1"
                    },
                    {
                        "error_list": [
                            {
                                "error_content": "c23187"
                            }
                        ],
                        "fault_category": "0e",
                        "error_list_count": "1"
                    }
                ],
                "ElectronicStabilitySysIndication": "0",
                "TirePressureAnomaly": "0",
                "electronicParkingFailure": "0",
                "gpsSpeed": "18.0",
                "latitude": "31.749108",
                "sendingTime": "1560823103000",
                "StartStopSystemNotWork": "0",
                "AutoEmergencyBrakeSysFailure": "0"
            },
            {
                "blindSpotMonitoringSysFailure": "0",
                "EngineTheftPreventionSysFailure": "0",
                "batteryCharging": "0",
                "altitude": "0",
                "transmissionFailure": "0",
                "powerSteeringSystemFailure": "0",
                "AutoParkingFailure": "0",
                "adaptiveCruiseFault": "1",
                "engineFailure": "0",
                "stabilitySystemShutdown": "0",
                "OilPressure": "0",
                "slopeSlowDownFault": "0",
                "ElectronicParking": "0",
                "vin": "LJ166A236K4013753",
                "startStopSystemFailure": "0",
                "WindshieldSensorShield": "0",
                "longitude": "117.265793",
                "laneDepartureSysFailure": "0",
                "longitudeState": "1",
                "direct": "0",
                "TirePressureMonitoringSysFailure": "0",
                "engineExhaustSystemFailure": "0",
                "powerSteeringSystemInit": "0",
                "AutoBrakSystemStatus": "1",
                "latitudeState": "1",
                "loc": "1",
                "airbagFault": "0",
                "project": [
                    {
                        "error_list": [
                            {
                                "error_content": "930100"
                            }
                        ],
                        "fault_category": "09",
                        "error_list_count": "1"
                    },
                    {
                        "error_list": [
                            {
                                "error_content": "c23187"
                            }
                        ],
                        "fault_category": "0e",
                        "error_list_count": "1"
                    }
                ],
                "ElectronicStabilitySysIndication": "0",
                "TirePressureAnomaly": "0",
                "electronicParkingFailure": "0",
                "gpsSpeed": "0.0",
                "latitude": "31.717377",
                "sendingTime": "1560814672000",
                "StartStopSystemNotWork": "0",
                "AutoEmergencyBrakeSysFailure": "0"
            },
            {
                "blindSpotMonitoringSysFailure": "0",
                "EngineTheftPreventionSysFailure": "0",
                "batteryCharging": "0",
                "altitude": "0",
                "transmissionFailure": "0",
                "powerSteeringSystemFailure": "0",
                "AutoParkingFailure": "0",
                "adaptiveCruiseFault": "0",
                "engineFailure": "0",
                "stabilitySystemShutdown": "0",
                "OilPressure": "0",
                "slopeSlowDownFault": "0",
                "ElectronicParking": "0",
                "vin": "LJ166A237K4012465",
                "startStopSystemFailure": "0",
                "WindshieldSensorShield": "0",
                "longitude": "117.235351",
                "laneDepartureSysFailure": "0",
                "longitudeState": "1",
                "direct": "0",
                "TirePressureMonitoringSysFailure": "0",
                "engineExhaustSystemFailure": "0",
                "powerSteeringSystemInit": "0",
                "AutoBrakSystemStatus": "1",
                "latitudeState": "1",
                "loc": "1",
                "airbagFault": "0",
                "project": [],
                "ElectronicStabilitySysIndication": "0",
                "TirePressureAnomaly": "0",
                "electronicParkingFailure": "0",
                "gpsSpeed": "0.0",
                "latitude": "31.782977",
                "sendingTime": "1560818078000",
                "StartStopSystemNotWork": "0",
                "AutoEmergencyBrakeSysFailure": "0"
            },
            {
                "blindSpotMonitoringSysFailure": "0",
                "EngineTheftPreventionSysFailure": "0",
                "batteryCharging": "1",
                "altitude": "0",
                "transmissionFailure": "0",
                "powerSteeringSystemFailure": "0",
                "AutoParkingFailure": "0",
                "adaptiveCruiseFault": "0",
                "engineFailure": "0",
                "stabilitySystemShutdown": "0",
                "OilPressure": "0",
                "slopeSlowDownFault": "0",
                "ElectronicParking": "0",
                "vin": "LJ166A241K4018481",
                "startStopSystemFailure": "0",
                "WindshieldSensorShield": "0",
                "longitude": "117.251247",
                "laneDepartureSysFailure": "0",
                "longitudeState": "1",
                "direct": "0",
                "TirePressureMonitoringSysFailure": "0",
                "engineExhaustSystemFailure": "0",
                "powerSteeringSystemInit": "0",
                "AutoBrakSystemStatus": "1",
                "latitudeState": "1",
                "loc": "1",
                "airbagFault": "0",
                "project": [
                    {
                        "error_list": [
                            {
                                "error_content": "031500"
                            }
                        ],
                        "fault_category": "00",
                        "error_list_count": "1"
                    },
                    {
                        "error_list": [
                            {
                                "error_content": "c16500"
                            }
                        ],
                        "fault_category": "0a",
                        "error_list_count": "1"
                    },
                    {
                        "error_list": [
                            {
                                "error_content": "c18700"
                            }
                        ],
                        "fault_category": "0b",
                        "error_list_count": "1"
                    },
                    {
                        "error_list": [
                            {
                                "error_content": "d00287"
                            },
                            {
                                "error_content": "c16587"
                            },
                            {
                                "error_content": "c23187"
                            }
                        ],
                        "fault_category": "0c",
                        "error_list_count": "3"
                    }
                ],
                "ElectronicStabilitySysIndication": "0",
                "TirePressureAnomaly": "0",
                "electronicParkingFailure": "0",
                "gpsSpeed": "0.0",
                "latitude": "31.737417",
                "sendingTime": "1560821456000",
                "StartStopSystemNotWork": "1",
                "AutoEmergencyBrakeSysFailure": "0"
            },
            {
                "blindSpotMonitoringSysFailure": "0",
                "EngineTheftPreventionSysFailure": "0",
                "batteryCharging": "0",
                "altitude": "0",
                "transmissionFailure": "0",
                "powerSteeringSystemFailure": "0",
                "AutoParkingFailure": "0",
                "adaptiveCruiseFault": "1",
                "engineFailure": "0",
                "stabilitySystemShutdown": "0",
                "OilPressure": "0",
                "slopeSlowDownFault": "1",
                "ElectronicParking": "0",
                "vin": "LJ166A247K4012474",
                "startStopSystemFailure": "0",
                "WindshieldSensorShield": "0",
                "longitude": "117.261915",
                "laneDepartureSysFailure": "1",
                "longitudeState": "1",
                "direct": "0",
                "TirePressureMonitoringSysFailure": "0",
                "engineExhaustSystemFailure": "0",
                "powerSteeringSystemInit": "0",
                "AutoBrakSystemStatus": "1",
                "latitudeState": "1",
                "loc": "1",
                "airbagFault": "0",
                "project": [
                    {
                        "error_list": [
                            {
                                "error_content": "063000"
                            },
                            {
                                "error_content": "000000"
                            },
                            {
                                "error_content": "00006d"
                            }
                        ],
                        "fault_category": "02",
                        "error_list_count": "3"
                    },
                    {
                        "error_list": [
                            {
                                "error_content": "403813"
                            },
                            {
                                "error_content": "403b13"
                            }
                        ],
                        "fault_category": "03",
                        "error_list_count": "2"
                    },
                    {
                        "error_list": [
                            {
                                "error_content": "950a00"
                            }
                        ],
                        "fault_category": "09",
                        "error_list_count": "1"
                    }
                ],
                "ElectronicStabilitySysIndication": "0",
                "TirePressureAnomaly": "1",
                "electronicParkingFailure": "0",
                "gpsSpeed": "0.0",
                "latitude": "31.739488",
                "sendingTime": "1560823807000",
                "StartStopSystemNotWork": "0",
                "AutoEmergencyBrakeSysFailure": "1"
            }
        ]
    },
    "resultCode": "200"
}
"""


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
    # 故障转存列表
    warning_list = []
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
                    print(time.time(), save_response, save_response.text[0:50])


# 从我的数据库取出数据
# timespan_hours 从现在往回推的以小时计算的时间跨度
def get_my_warning_response(timespan_hours):
    # 获取当前分钟, 秒数
    struct_time = time.localtime(time.time())
    tm_min = struct_time.tm_min
    tm_sec = struct_time.tm_sec
    # 获得上小时的时间戳 e.g. 14:52 为14:00
    cur_time = int(time.time()) * 1000
    cur_hour = cur_time - (60 * tm_min + tm_sec) * 1000
    start_time = cur_hour - timespan_hours * 60 * 60 * 1000
    warning_input = {'sendingTime': start_time}
    # POST方式请求故障信息
    response = requests.post(MY_WARNING_URL, json=warning_input, timeout=5)
    if response.status_code != 200:
        print(time.time(), response, response.text[0:50])
    else:
        return response.json()


# 存放dashboard_errorToday数据到数据库VisualChart(每小时更新)
def save_visual_chart_dashboard_error_today(json):
    # 每小时存放一次
    date = datetime.now().date()
    hour = datetime.now().hour
    timestamp = str(date).replace("-", "") + str(hour)
    save_input = {
        "chartName": "dashboard-errorToday-" + timestamp,
        "chartType": "0",
        "chartData": str(json),
        "createdBy": "db",
        "lastUpdatedBy": "db"
    }
    save_response = requests.post(MY_SAVE_VISUAL_CHART_URL, json=save_input, timeout=5)
    if save_response.status_code != 200 or save_response.text != "Succeed.":
        print(time.time(), save_response, save_response.text[0:50])
        print(save_response.text)
