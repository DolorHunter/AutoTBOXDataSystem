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
        name: "generalComment",
        label: "整体评价",
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
                    this.state.datatableData[rowId].generalComment = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "generalScore",
        label: "整体分数",
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
                    this.state.datatableData[rowId].generalScore = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "driveComment",
        label: "驱动评价",
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
                    this.state.datatableData[rowId].driveComment = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "driveScore",
        label: "驱动分数",
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
                    this.state.datatableData[rowId].driveScore = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "fuelEngineComment",
        label: "燃油引擎评价",
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
                    this.state.datatableData[rowId].fuelEngineComment = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "fuelEngineScore",
        label: "燃油引擎分数",
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
                    this.state.datatableData[rowId].fuelEngineScore = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "performanceComment",
        label: "性能评价",
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
                    this.state.datatableData[rowId].performanceComment = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {

        name: "performanceScore",
        label: "性能分数",
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
                    this.state.datatableData[rowId].performanceScore = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "consumptionComment",
        label: "效能评价",
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
                    this.state.datatableData[rowId].consumptionComment = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "consumptionScore",
        label: "效能分数",
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
                    this.state.datatableData[rowId].consumptionScore = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "chassisComment",
        label: "车身评价",
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
                    this.state.datatableData[rowId].chassisComment = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "chassisScore",
        label: "车身分数",
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
                    this.state.datatableData[rowId].chassisScore = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "transmissionComment",
        label: "传动评价",
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
                    this.state.datatableData[rowId].transmissionComment = e.target.value;
                  }}
                />
              )
            }
          }
        }
      },
      {
        name: "transmissionScore",
        label: "传动分数",
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
                    this.state.datatableData[rowId].transmissionScore = e.target.value;
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
    axios.post('/CarWarranty/searchAllCarWarrantyList', {})
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
              title="车辆保固列表"
              data={this.state.datatableData}
              columns={this.state.columns}
              options={{
                filterType: "checkbox",
                onRowsDelete: (data) => {
                  for (var i = 0; i < data.data.length; ++i) {
                    var index = data.data[i].dataIndex;
                    var id = this.state.datatableData[index].id;
                    axios.post('/CarWarranty/deleteCarWarrantyById', { id: id })
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
    axios.post('/CarWarranty/updateStatusById', data)
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
    axios.post('/CarWarranty/updateRemarkById', data)
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
    generalComment: row.generalComment,
    generalScore: row.generalScore,
    driveComment: row.driveComment,
    driveScore: row.driveScore,
    fuelEngineComment: row.fuelEngineComment,
    fuelEngineScore: row.fuelEngineScore,
    performanceComment: row.performanceComment,
    performanceScore: row.performanceScore,
    consumptionComment: row.consumptionComment,
    consumptionScore: row.consumptionScore,
    chassisComment: row.chassisComment,
    chassisScore: row.chassisScore,
    transmissionComment: row.transmissionComment,
    transmissionScore: row.transmissionScore,
    status: row.status,
    remark: row.remark,
    createdBy: cookie.get('username'),
    lastUpdatedBy: cookie.get('username')
  }
  axios.post('/CarWarranty/addCarWarranty', data)
    .then(res => {
      if (res.request.response !== "Succeed.") {
        alert(res.request.response);
      }
    })
}