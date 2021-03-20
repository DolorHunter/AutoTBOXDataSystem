import HttpUtil
import Analysis


def main():
    # 测试时注释此内容
    """
    # 获取故障信息
    response = HttpUtil.get_warning_response()
    # 转存故障信息到我的数据库(数据格式调整)
    HttpUtil.save_warning_to_my_database(response)
    """
    # 分析errorToday数据并存储到VisualChart(每小时更新)
    daily = Analysis.daily_analysis()
    HttpUtil.save_visual_chart_dashboard_error_today(daily)


if __name__ == '__main__':
    main()
