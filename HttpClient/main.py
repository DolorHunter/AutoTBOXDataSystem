import HttpUtil
import Analysis
import datetime


# 获取故障信息
def get_warning_data():
    response = HttpUtil.get_warning_response()
    # 转存故障信息到我的数据库(数据格式调整)
    HttpUtil.save_warning_to_my_database(response)


# 存储每日更新数据到到VisualChart
def daily_save_visual_chart(name, json):
    # 每天存放一次, 时间标记为本年第几天 e.g. 202183(2021/03/22)
    date = datetime.datetime.now().year
    timestamp = str(date) + str(datetime.date.today().timetuple().tm_yday)
    HttpUtil.save_visual_chart(chart_name=name + timestamp,
                               chart_type="1", json=json,
                               created_by="db", last_updated_by="db")


def main():
    # 存储仪表盘(dashboard)的每日更新数据到到VisualChart(昨日故障分析，过去七天故障分析, 本年度故障统计)
    dashboard_daily = Analysis.dashboard_daily_analysis()
    daily_save_visual_chart(name="dashboard-daily-", json=dashboard_daily)
    # 存储概览(general)的每日更新数据到VisualChart(散点图, 树形图, 条形图)
    general_daily = Analysis.general_daily_analysis()
    daily_save_visual_chart(name="general-daily-", json=general_daily)
    # 存储地图(Maps)的每日更新数据到VisualChart(必应地图)
    maps_daily = Analysis.maps_daily_analysis()
    daily_save_visual_chart(name="maps-daily-", json=maps_daily)


if __name__ == '__main__':
    main()
