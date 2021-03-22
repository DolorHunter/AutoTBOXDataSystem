import HttpUtil
import Analysis
import datetime


# 获取故障信息
def get_warning_data():
    response = HttpUtil.get_warning_response()
    # 转存故障信息到我的数据库(数据格式调整)
    HttpUtil.save_warning_to_my_database(response)


# 分析errorToday数据并存储到VisualChart(每小时更新)
def hourly_update_visual_chart():
    daily = Analysis.daily_analysis()
    # 每小时存放一次, 时间标记为年月日时 e.g.2021032216
    date = datetime.datetime.now().date()
    hour = datetime.datetime.now().hour
    timestamp = str(date).replace("-", "") + str(hour)
    HttpUtil.save_visual_chart(chart_name="dashboard-errorToday-" + timestamp,
                               chart_type="0", json=daily,
                               created_by="db", last_updated_by="db")


# 分析errorLastWeek数据并存储到VisualChart(每天更新)
def daily_update_visual_chart():
    weekly = Analysis.weekly_analysis()
    # 每天存放一次, 时间标记为本年第几天 e.g. 202183(2021/03/22)
    date = datetime.datetime.now().year
    timestamp = str(date) + str(datetime.date.today().timetuple().tm_yday)
    HttpUtil.save_visual_chart(chart_name="dashboard-weeklyError-" + timestamp,
                               chart_type="1", json=weekly,
                               created_by="db", last_updated_by="db")


def main():
    hourly_update_visual_chart()  # 每小时运行
    daily_update_visual_chart()  # 每日运行


if __name__ == '__main__':
    main()
