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
        name: "vin", 
        label: "车辆识别号码" 
      },
      { 
        name: "generalComment", 
        label: "整体评价" 
      },
      { 
        name: "generalScore", 
        label: "整体分数" 
      },
      { 
        name: "driveComment", 
        label: "驱动评价" 
      },
      { 
        name: "driveScore", 
        label: "驱动分数" 
      },
      { 
        name: "fuelEngineComment", 
        label: "燃油引擎评价" 
      },
      { 
        name: "fuelEngineScore", 
        label: "燃油引擎分数" 
      },
      { 
        name: "performanceComment", 
        label: "性能评价" 
      },
      { 
        
        name: "performanceScore", 
        label: "性能分数" 
      },
      { 
        name: "consumptionComment", 
        label: "效能评价" 
      },
      { 
        name: "consumptionScore", 
        label: "效能分数" 
      },
      { 
        name: "chassisComment", 
        label: "车身评价" 
      },
      { 
        name: "chassisScore", 
        label: "车身分数" 
      },
      { 
        name: "transmissionComment", 
        label: "传动评价" 
      },
      { 
        name: "transmissionScore", 
        label: "传动分数" 
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
                  for (var i=0; i<data.data.length; ++i){
                    var index = data.data[i].dataIndex;
                    var id = this.state.datatableData[index].id;
                    axios.post('/CarWarranty/deleteCarWarrantyById', {id: id})
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