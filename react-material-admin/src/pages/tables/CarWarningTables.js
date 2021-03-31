import React, { Component } from 'react';
import { Grid } from "@material-ui/core";
import MUIDataTable from "mui-datatables";

import axios from 'axios';

export default class Tables extends Component {
  state = {
    datatableData: [],
    columns: [
      {
        name: "id",
        label: "ID",
        options: {
          display: "excluded",
        },
      },
      { name: "blindSpotMonitoringSysFailure", label: "盲点监控系统故障" },
      { name: "engineTheftPreventionSysFailure", label: "引擎防盗系统故障" },
      { name: "batteryCharging", label: "电池充电" },
      { name: "altitude", label: "高度" },
      { name: "transmissionFailure", label: "传输失败" },
      { name: "powerSteeringSystemFailure", label: "动力转向系统故障" },
      { name: "autoParkingFailure", label: "自动停车失败" },
      { name: "adaptiveCruiseFault", label: "自适应巡航故障" },
      { name: "engineFailure", label: "发动机故障" },
      { name: "stabilitySystemShutdown", label: "稳定系统关闭" },
      { name: "oilPressure", label: "油压" },
      { name: "slopeSlowDownFault", label: "斜坡减速故障" },
      { name: "electronicParking", label: "电子停车" },
      { name: "vin", label: "车辆识别号码" },
      { name: "startStopSystemFailure", label: "开始停止系统故障" },
      { name: "windshieldSensorShield", label: "挡风玻璃传感器护罩" },
      { name: "longitude", label: "经度" },
      { name: "laneDepartureSysFailure", label: "车道偏离系统故障" },
      { name: "longitudeState", label: "经度状态" },
      { name: "direct", label: "方向" },
      { name: "tirePressureMonitoringSysFailure", label: "胎压监测系统故障" },
      { name: "engineExhaustSystemFailure", label: "发动机排气系统故障" },
      { name: "powerSteeringSystemInit", label: "动力转向系统" },
      { name: "autoBrakSystemStatus", label: "自动刹车系统状态" },
      { name: "latitudeState", label: "纬度州" },
      { name: "loc", label: "位置" },
      { name: "airbagFault", label: "安全气囊故障" },
      { name: "errorContent", label: "错误内容" },
      { name: "faultCategory", label: "故障类别" },
      { name: "errorListCount", label: "错误列表计数 " },
      { name: "electronicStabilitySysIndication", label: "电子稳定系统指示" },
      { name: "tirePressureAnomaly", label: "轮胎压力异常" },
      { name: "electronicParkingFailure", label: "电子停车故障" },
      { name: "gpsSpeed", label: "gps速度" },
      { name: "latitude", label: "纬度" },
      { name: "sendingTime", label: "发送时间" },
      { name: "startStopSystemNotWork", label: "启动停止系统不起作用" },
      { name: "autoEmergencyBrakeSysFailure", label: "自动紧急制动系统故障" },
    ],
  }

  componentDidMount() {
    axios.post('/CarWarning/searchAllCarWarningList', {})
      .then(res => {
        if (res.status === 200 && Object.keys(res.request.response).length > 0) {
          const datatableData = JSON.parse(res.request.response);
          this.setState({ datatableData });
        }
      })
  }

  render() {
    return (
      <>
        <Grid container spacing={4}>
          <Grid item xs={12}>
            <MUIDataTable
              title="车辆故障列表"
              data={this.state.datatableData}
              columns={this.state.columns}
              options={{
                filterType: "checkbox"
              }}
            />
          </Grid>
        </Grid>
      </>
    )
  }
}