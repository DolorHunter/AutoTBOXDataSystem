import React, { Component } from 'react';import {
  Grid,
  FormControlLabel,
  TextField,
  Button,
} from "@material-ui/core";
import MUIDataTable from "mui-datatables";
import SaveIcon from '@material-ui/icons/Save';
import CustomToolbar from "./CustomToolbar";

import cookie from 'js-cookie';
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
      { 
        name: "blindSpotMonitoringSysFailure", 
        label: "盲点监控系统故障" 
      },
      { 
        name: "engineTheftPreventionSysFailure", 
        label: "引擎防盗系统故障" 
      },
      { 
        name: "batteryCharging", 
        label: "电池充电" 
      },
      { 
        name: "altitude", 
        label: "高度" 
      },
      { 
        name: "transmissionFailure", 
        label: "传输失败" 
      },
      { 
        name: "powerSteeringSystemFailure", 
        label: "动力转向系统故障" 
      },
      { 
        name: "autoParkingFailure", 
        label: "自动停车失败" 
      },
      { 
        name: "adaptiveCruiseFault", 
        label: "自适应巡航故障" 
      },
      { 
        name: "engineFailure", 
        label: "发动机故障" 
      },
      { 
        name: "stabilitySystemShutdown", 
        label: "稳定系统关闭" 
      },
      { 
        name: "oilPressure", 
        label: "油压" 
      },
      { 
        name: "slopeSlowDownFault", 
        label: "斜坡减速故障" 
      },
      { 
        name: "electronicParking", 
        label: "电子停车" 
      },
      { 
        name: "vin", 
        label: "车辆识别号码" 
      },
      { 
        name: "startStopSystemFailure", 
        label: "开始停止系统故障" 
      },
      { 
        name: "windshieldSensorShield", 
        label: "挡风玻璃传感器护罩" 
      },
      { 
        name: "longitude", 
        label: "经度" 
      },
      { 
        name: "laneDepartureSysFailure", 
        label: "车道偏离系统故障" 
      },
      { 
        name: "longitudeState", 
        label: "经度状态" 
      },
      { 
        name: "direct", 
        label: "方向" 
      },
      { 
        name: "tirePressureMonitoringSysFailure", 
        label: "胎压监测系统故障" 
      },
      { 
        name: "engineExhaustSystemFailure", 
        label: "发动机排气系统故障" 
      },
      { 
        name: "powerSteeringSystemInit", 
        label: "动力转向系统" 
      },
      { 
        name: "autoBrakSystemStatus", 
        label: "自动刹车系统状态" 
      },
      { 
        name: "latitudeState", 
        label: "纬度州" 
      },
      { 
        name: "loc", 
        label: "位置" 
      },
      { 
        name: "airbagFault", 
        label: "安全气囊故障" 
      },
      { 
        name: "errorContent", 
        label: "错误内容" 
      },
      { 
        name: "faultCategory", 
        label: "故障类别" 
      },
      { 
        name: "errorListCount", 
        label: "错误列表计数 " 
      },
      { 
        name: "electronicStabilitySysIndication", 
        label: "电子稳定系统指示" 
      },
      { 
        name: "tirePressureAnomaly", 
        label: "轮胎压力异常" 
      },
      { 
        name: "electronicParkingFailure", 
        label: "电子停车故障" 
      },
      { 
        name: "gpsSpeed", 
        label: "gps速度" 
      },
      { 
        name: "latitude", 
        label: "纬度" 
      },
      { 
        name: "sendingTime", 
        label: "发送时间" 
      },
      { 
        name: "startStopSystemNotWork", 
        label: "启动停止系统不起作用" 
      },
      { 
        name: "autoEmergencyBrakeSysFailure", 
        label: "自动紧急制动系统故障" 
      },
      {
        name: "status",
        label: "状态",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => (
            <FormControlLabel
              value={value}
              control={<TextField value={value} />}
              onChange={e => {
                updateValue(e.target.value);
                const rowId = tableMeta.rowIndex;
                this.state.datatableData[rowId].status = e.target.value;
              }}
            />
          )
        },
      },
      {
        name: "remark",
        label: "备注",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => (
            <FormControlLabel
              value={value}
              control={<TextField value={value} />}
              onChange={e => {
                updateValue(e.target.value);
                const rowId = tableMeta.rowIndex;
                this.state.datatableData[rowId].remark = e.target.value;
              }}
            />
          )
        },
      },
      {
        name: "edit",
        label: "编辑",
        options: {
          filter: false,
          sort: false,
          empty: true,
          customBodyRenderLite: (dataIndex) => {
            return (
              <Button
                variant="contained"
                color="primary"
                size="large"
                startIcon={<SaveIcon />}
                onClick={() => updateRow(this.state.datatableData[dataIndex])}
              >
                保存
              </Button>
            );
          }
        }
      },
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
                filterType: "checkbox",
                onRowsDelete: (data) => { 
                  for (var i=0; i<data.data.length; ++i){
                    var index = data.data[i].dataIndex;
                    var id = this.state.datatableData[index].id;
                    axios.post('/CarWarning/deleteCarWarrantyById', {id: id})
                      .then(res => {
                        if (res.request.response !== "Succeed.") {
                          console.log(res.request.response);
                        }
                      })
                  }
                }, 
              }}
            />
          </Grid>
        </Grid>
      </>
    )
  }
}
// #################################################################
function updateRow(row) {
  var data;
  // update status
  if (row.status !== null) {
    data = {
      id: row.id,
      status: row.status,
      lastUpdatedBy: cookie.get('username')
    }
    axios.post('/CarWarning/updateStatusById', data)
      .then(res => {
        if (res.request.response !== "Succeed.") {
          console.log(res.request.response);
        }
      })
  }
  // update remark
  if (row.remark !== null) {
    data = {
      id: row.id,
      remark: row.remark,
      lastUpdatedBy: cookie.get('username')
    }
    axios.post('/CarWarning/updateRemarkById', data)
      .then(res => {
        if (res.request.response !== "Succeed.") {
          console.log(res.request.response);
        }
      })
  }
}