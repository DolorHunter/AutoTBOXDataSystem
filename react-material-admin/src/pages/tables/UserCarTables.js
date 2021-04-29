import React, { Component } from 'react'; import {
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
        name: "userId",
        label: "用户ID",
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
                    this.state.datatableData[rowId].userId = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "username",
        label: "用户名",
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
                    this.state.datatableData[rowId].username = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "carId",
        label: "车辆ID",
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
                    this.state.datatableData[rowId].carId = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "carName",
        label: "车辆名",
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
                    this.state.datatableData[rowId].carName = e.target.value;
                  }}
                />
              )
            }
          }
        }
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
        name: "_4SShop",
        label: "4S店名",
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
                    this.state.datatableData[rowId]._4SShop = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "saleLoc",
        label: "销售位置",
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
                    this.state.datatableData[rowId].saleLoc = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "saleTime",
        label: "销售时间",
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
                    this.state.datatableData[rowId].saleTime = e.target.value;
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
    axios.post('/UserCar/searchAllUserCarList', {})
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
              title="用户车辆列表"
              data={this.state.datatableData}
              columns={this.state.columns}
              options={{
                filterType: "checkbox",
                onRowsDelete: (data) => {
                  for (var i = 0; i < data.data.length; ++i) {
                    var index = data.data[i].dataIndex;
                    var id = this.state.datatableData[index].id;
                    axios.post('/UserCar/deleteUserCarById', { id: id })
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
    axios.post('/UserCar/updateStatusById', data)
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
    axios.post('/UserCar/updateRemarkById', data)
      .then(res => {
        if (res.request.response !== "Succeed.") {
          console.log(res.request.response);
        }
      })
  }
}
function appendRow(row) {
  var data = {
    userId: row.userId,
    username: row.username,
    carId: row.carId,
    carName: row.carName,
    vin: row.vin,
    _4SShop: row._4SShop,
    saleLoc: row.saleLoc,
    saleTime: row.saleTime,
    status: row.status,
    remark: row.remark,
    createdBy: cookie.get('username'),
    lastUpdatedBy: cookie.get('username')
  }
  axios.post('/UserCar/addCar2User', data)
    .then(res => {
      if (res.request.response !== "Succeed.") {
        alert(res.request.response);
      }
    })
}