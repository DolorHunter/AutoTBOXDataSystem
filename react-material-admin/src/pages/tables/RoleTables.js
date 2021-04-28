import React, { Component } from 'react';
import {
  Grid,
  FormControlLabel,
  TextField,
  MenuItem,
  Button,
} from "@material-ui/core";
import MUIDataTable from "mui-datatables";
import SaveIcon from '@material-ui/icons/Save';
import CustomToolbar from "./CustomToolbar";

import cookie from 'js-cookie';
import axios from 'axios';

const isActivated = [
  { value: '1', label: '启用' },
  { value: '0', label: '禁用' },
]

const isDeleted = [
  { value: '1', label: '软删除' },
  { value: '0', label: '保留' },
]

export default class Tables extends Component {
  state = {
    datatableData: [],
    columns: [
      {
        name: "id",
        label: "ID",
        options: {
          display: "excluded"
        }
      },
      {
        name: "roleName",
        label: "角色名",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => (
            <FormControlLabel
              value={value}
              control={<TextField value={value} />}
              onChange={e => {
                updateValue(e.target.value);
                const rowId = tableMeta.rowIndex;
                this.state.datatableData[rowId].roleName = e.target.value;
              }}
            />
          )
        }
      },
      {
        name: "roleType",
        label: "角色类型",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => (
            <FormControlLabel
              value={value}
              control={<TextField value={value} />}
              onChange={e => {
                updateValue(e.target.value);
                const rowId = tableMeta.rowIndex;
                this.state.datatableData[rowId].roleType = e.target.value;
              }}
            />
          )
        }
      },
      {
        name: "fatherRoleId",
        label: "父角色ID",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => (
            <FormControlLabel
              value={value}
              control={<TextField value={value} />}
              onChange={e => {
                updateValue(e.target.value);
                const rowId = tableMeta.rowIndex;
                this.state.datatableData[rowId].fatherRoleId = e.target.value;
              }}
            />
          )
        }
      },
      {
        name: "isActivated",
        label: "启用状态",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => (
            <TextField
              select
              id="isActivated"
              type="isActivated"
              value={value}
              onChange={e => {
                updateValue(e.target.value);
                const rowId = tableMeta.rowIndex;
                this.state.datatableData[rowId].isActivated = e.target.value;
              }}
              margin="normal"
              variant="outlined"
            >
              {isActivated.map((option) => (
                <MenuItem key={option.value} value={option.value}>
                  {option.label}
                </MenuItem>
              ))}
            </TextField>
          )
        }
      },
      {
        name: "isDeleted",
        label: "删除状态",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => (
            <TextField
              select
              id="isDeleted"
              type="isDeleted"
              value={value}
              onChange={e => {
                updateValue(e.target.value);
                const rowId = tableMeta.rowIndex;
                this.state.datatableData[rowId].isDeleted = e.target.value;
              }}
              margin="normal"
              variant="outlined"
            >
              {isDeleted.map((option) => (
                <MenuItem key={option.value} value={option.value}>
                  {option.label}
                </MenuItem>
              ))}
            </TextField>
          )
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
        }
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
        }
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
      }
    ]
  }

  componentDidMount() {
    axios.post('/Role/searchAllRoleList', {})
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
              title="角色列表"
              data={this.state.datatableData}
              columns={this.state.columns}
              options={{
                filterType: "checkbox",
                onRowsDelete: (data) => {
                  for (var i = 0; i < data.data.length; ++i) {
                    var index = data.data[i].dataIndex;
                    var id = this.state.datatableData[index].id;
                    axios.post('/Role/hardDeleteRoleById', { id: id })
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
  // update role
  data = {
    id: row.id,
    roleName: row.roleName,
    fatherRoleId: row.fatherRoleId,
    lastUpdatedBy: cookie.get('username')
  };
  axios.post('/Role/updateRoleById', data)
    .then(res => {
      if (res.request.response !== "Succeed.") {
        console.log(res.request.response);
      }
    })
  // update isActivated
  data = {
    id: row.id,
    lastUpdatedBy: cookie.get('username')
  }
  if (row.isActivated === '0') {
    axios.post('/Role/deactivateRoleById', data)
      .then(res => {
        if (res.request.response !== "Succeed.") {
          console.log(res.request.response);
        }
      })
  }
  else if (row.isActivated === '1') {
    axios.post('/Role/activateRoleById', data)
      .then(res => {
        if (res.request.response !== "Succeed.") {
          console.log(res.request.response);
        }
      })
  }
  // update isDeleted
  data = {
    id: row.id,
    lastUpdatedBy: cookie.get('username')
  }
  if (row.isDeleted === '0') {
    axios.post('/Role/restoreRoleById', data)
      .then(res => {
        if (res.request.response !== "Succeed.") {
          console.log(res.request.response);
        }
      })
  }
  else if (row.isDeleted === '1') {
    axios.post('/Role/softDeleteRoleById', data)
      .then(res => {
        if (res.request.response !== "Succeed.") {
          console.log(res.request.response);
        }
      })
  }
  // update status
  if (row.status !== null) {
    data = {
      id: row.id,
      status: row.status,
      lastUpdatedBy: cookie.get('username')
    }
    axios.post('/Role/updateStatusById', data)
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
    axios.post('/Role/updateRemarkById', data)
      .then(res => {
        if (res.request.response !== "Succeed.") {
          console.log(res.request.response);
        }
      })
  }
}