import React, { Component } from 'react';import {
  Grid,
  FormControlLabel,
  TextField,
  Button,  
  IconButton,
  Tooltip,
  FormLabel,
} from "@material-ui/core";
import {
  Save as SaveIcon,
  Add as AddIcon,
  Publish as PublishIcon,
} from '@material-ui/icons';
import MUIDataTable from "mui-datatables";

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
        name: "vin", 
        label: "车辆识别号码",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => {
            const rowId = tableMeta.rowIndex;
            if ('id' in this.state.datatableData[rowId]) {
              return (
                <FormLabel>
                  {value}
                </FormLabel>
              )
            } else {
              return (
                <FormControlLabel
                  value={value}
                  control={<TextField value={value} />}
                  onChange={e => {
                    updateValue(e.target.value);
                    this.state.datatableData[rowId].vin = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      { 
        name: "bootTime", 
        label: "开机时间",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => {
            const rowId = tableMeta.rowIndex;
            if ('id' in this.state.datatableData[rowId]) {
              return (
                <FormLabel>
                  {value}
                </FormLabel>
              )
            } else {
              return (
                <FormControlLabel
                  value={value}
                  control={<TextField value={value} />}
                  onChange={e => {
                    updateValue(e.target.value);
                    this.state.datatableData[rowId].bootTime = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      { 
        name: "runTime", 
        label: "运行时长",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => {
            const rowId = tableMeta.rowIndex;
            if ('id' in this.state.datatableData[rowId]) {
              return (
                <FormLabel>
                  {value}
                </FormLabel>
              )
            } else {
              return (
                <FormControlLabel
                  value={value}
                  control={<TextField value={value} />}
                  onChange={e => {
                    updateValue(e.target.value);
                    this.state.datatableData[rowId].runTime = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      { 
        name: "gear", 
        label: "挡位",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => {
            const rowId = tableMeta.rowIndex;
            if ('id' in this.state.datatableData[rowId]) {
              return (
                <FormLabel>
                  {value}
                </FormLabel>
              )
            } else {
              return (
                <FormControlLabel
                  value={value}
                  control={<TextField value={value} />}
                  onChange={e => {
                    updateValue(e.target.value);
                    this.state.datatableData[rowId].gear = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      { 
        name: "odometer", 
        label: "行驶里程",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => {
            const rowId = tableMeta.rowIndex;
            if ('id' in this.state.datatableData[rowId]) {
              return (
                <FormLabel>
                  {value}
                </FormLabel>
              )
            } else {
              return (
                <FormControlLabel
                  value={value}
                  control={<TextField value={value} />}
                  onChange={e => {
                    updateValue(e.target.value);
                    this.state.datatableData[rowId].odometer = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      { 
        name: "odometerRem", 
        label: "剩余里程",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => {
            const rowId = tableMeta.rowIndex;
            if ('id' in this.state.datatableData[rowId]) {
              return (
                <FormLabel>
                  {value}
                </FormLabel>
              )
            } else {
              return (
                <FormControlLabel
                  value={value}
                  control={<TextField value={value} />}
                  onChange={e => {
                    updateValue(e.target.value);
                    this.state.datatableData[rowId].odometerRem = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      { 
        name: "odometerAcc", 
        label: "累计里程",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => {
            const rowId = tableMeta.rowIndex;
            if ('id' in this.state.datatableData[rowId]) {
              return (
                <FormLabel>
                  {value}
                </FormLabel>
              )
            } else {
              return (
                <FormControlLabel
                  value={value}
                  control={<TextField value={value} />}
                  onChange={e => {
                    updateValue(e.target.value);
                    this.state.datatableData[rowId].odometerAcc = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      { 
        name: "fuelRem", 
        label: "剩余油量",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => {
            const rowId = tableMeta.rowIndex;
            if ('id' in this.state.datatableData[rowId]) {
              return (
                <FormLabel>
                  {value}
                </FormLabel>
              )
            } else {
              return (
                <FormControlLabel
                  value={value}
                  control={<TextField value={value} />}
                  onChange={e => {
                    updateValue(e.target.value);
                    this.state.datatableData[rowId].fuelRem = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      { 
        name: "electroFuelRem", 
        label: "剩余电量",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => {
            const rowId = tableMeta.rowIndex;
            if ('id' in this.state.datatableData[rowId]) {
              return (
                <FormLabel>
                  {value}
                </FormLabel>
              )
            } else {
              return (
                <FormControlLabel
                  value={value}
                  control={<TextField value={value} />}
                  onChange={e => {
                    updateValue(e.target.value);
                    this.state.datatableData[rowId].electroFuelRem = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      { 
        name: "speed", 
        label: "车速",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => {
            const rowId = tableMeta.rowIndex;
            if ('id' in this.state.datatableData[rowId]) {
              return (
                <FormLabel>
                  {value}
                </FormLabel>
              )
            } else {
              return (
                <FormControlLabel
                  value={value}
                  control={<TextField value={value} />}
                  onChange={e => {
                    updateValue(e.target.value);
                    this.state.datatableData[rowId].speed = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      { 
        name: "rpm", 
        label: "转速",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => {
            const rowId = tableMeta.rowIndex;
            if ('id' in this.state.datatableData[rowId]) {
              return (
                <FormLabel>
                  {value}
                </FormLabel>
              )
            } else {
              return (
                <FormControlLabel
                  value={value}
                  control={<TextField value={value} />}
                  onChange={e => {
                    updateValue(e.target.value);
                    this.state.datatableData[rowId].rpm = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      { 
        name: "location", 
        label: "位置",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => {
            const rowId = tableMeta.rowIndex;
            if ('id' in this.state.datatableData[rowId]) {
              return (
                <FormLabel>
                  {value}
                </FormLabel>
              )
            } else {
              return (
                <FormControlLabel
                  value={value}
                  control={<TextField value={value} />}
                  onChange={e => {
                    updateValue(e.target.value);
                    this.state.datatableData[rowId].location = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      { 
        name: "heading", 
        label: "方向",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => {
            const rowId = tableMeta.rowIndex;
            if ('id' in this.state.datatableData[rowId]) {
              return (
                <FormLabel>
                  {value}
                </FormLabel>
              )
            } else {
              return (
                <FormControlLabel
                  value={value}
                  control={<TextField value={value} />}
                  onChange={e => {
                    updateValue(e.target.value);
                    this.state.datatableData[rowId].heading = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      { 
        name: "altitude", 
        label: "高度",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => {
            const rowId = tableMeta.rowIndex;
            if ('id' in this.state.datatableData[rowId]) {
              return (
                <FormLabel>
                  {value}
                </FormLabel>
              )
            } else {
              return (
                <FormControlLabel
                  value={value}
                  control={<TextField value={value} />}
                  onChange={e => {
                    updateValue(e.target.value);
                    this.state.datatableData[rowId].altitude = e.target.value;
                  }}
                />
              )
            }
          }
        }
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
            if ('id' in this.state.datatableData[dataIndex]) {
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
            } else {
              return (
                <Button
                  variant="contained"
                  color="secondary"
                  size="large"
                  startIcon={<PublishIcon />}
                  onClick={() => {
                    appendRow(this.state.datatableData[dataIndex]);
                    window.location.reload();
                  }}
                >
                  添加
                </Button>
              );
            }
          }
        }
      },
    ],
  }

  componentDidMount() {
    axios.post('/CarLog/searchAllCarLogList', {})
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
              title="车辆日志列表"
              data={this.state.datatableData}
              columns={this.state.columns}
              options={{
                filterType: "checkbox",
                onRowsDelete: (data) => { 
                  for (var i=0; i<data.data.length; ++i){
                    var index = data.data[i].dataIndex;
                    var id = this.state.datatableData[index].id;
                    axios.post('/CarLog/deleteCarLogById', {id: id})
                      .then(res => {
                        if (res.request.response !== "Succeed.") {
                          console.log(res.request.response);
                        }
                      })
                  }
                },
                customToolbar: () => {
                  return (
                    <React.Fragment>
                      <Tooltip title={"Add Row"}>
                        <IconButton onClick={() => {
                          const column = this.state.columns;
                          var row = new Object();
                          for (var i = 1; i < column.length - 1; ++i) {
                            var key = column[i].name;
                            row[key] = "";
                          }
                          this.state.datatableData.unshift(row);
                          this.setState(this.state.datatableData); // 利用setState重新渲染
                        }}>
                          <AddIcon />
                        </IconButton>
                      </Tooltip>
                    </React.Fragment>
                  );
                }
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
    axios.post('/CarLog/updateStatusById', data)
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
    axios.post('/CarLog/updateRemarkById', data)
      .then(res => {
        if (res.request.response !== "Succeed.") {
          console.log(res.request.response);
        }
      })
  }
}
function appendRow(row) {
  var data = {
    vin: row.vin,
    bootTime: row.bootTime,
    runTime: row.runTime,
    gear: row.gear,
    odometer: row.odometer,
    odometerAcc: row.odometerAcc,
    odometerRem: row.odometerRem,
    fuelRem: row.fuelRem,
    electroFuelRem: row.electroFuelRem,
    speed: row.speed,
    rpm: row.rpm,
    location: row.location,
    heading: row.heading,
    altitude: row.altitude,
    temperature: row.temperature,
    status: row.status,
    remark: row.remark,
    createdBy: cookie.get('username'),
    lastUpdatedBy: cookie.get('username')
  }
  axios.post('/CarLog/addCarLog', data)
    .then(res => {
      if (res.request.response !== "Succeed.") {
        alert(res.request.response);
      }
    })
}