import HttpUtil
import Analysis
import datetime


# 获取故障信息
def get_warning_data():
    response = HttpUtil.get_warning_response()
    # 转存故障信息到我的数据库(数据格式调整)
    HttpUtil.save_warning_to_my_database(response)


# 存储仪表盘(dashboard)的每日更新数据到到VisualChart(昨日故障分析，过去七天故障分析)
def daily_update_visual_chart():
    dashboard_daily = Analysis.dashboard_daily_analysis()
    # 每天存放一次, 时间标记为本年第几天 e.g. 202183(2021/03/22)
    date = datetime.datetime.now().year
    timestamp = str(date) + str(datetime.date.today().timetuple().tm_yday)
    HttpUtil.save_visual_chart(chart_name="dashboard-daily-" + timestamp,
                               chart_type="1", json=dashboard_daily,
                               created_by="db", last_updated_by="db")


def main():
    daily_update_visual_chart()  # 每日运行


if __name__ == '__main__':
    main()
