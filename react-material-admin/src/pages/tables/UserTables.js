import React, { Component } from 'react'; import {
  Grid,
  FormControlLabel,
  TextField,
  MenuItem,
  Button,
  Avatar,
} from "@material-ui/core";
import MUIDataTable from "mui-datatables";
import {
  Save as SaveIcon,
  Undo as ResetPasswordIcon,
} from "@material-ui/icons";
import CustomToolbar from "./CustomToolbar";

import cookie from 'js-cookie';
import axios from 'axios';

// avatar
import avatar1 from "./../../images/avatar/avatar_01.jpg";
import avatar2 from "./../../images/avatar/avatar_02.jpg";
import avatar3 from "./../../images/avatar/avatar_03.jpg";
import avatar4 from "./../../images/avatar/avatar_04.jpg";
import avatar5 from "./../../images/avatar/avatar_05.jpg";
import avatar6 from "./../../images/avatar/avatar_06.jpg";

const avatars = [
  {
    value: '1',
    label: avatar1,
  },
  {
    value: '2',
    label: avatar2,
  },
  {
    value: '3',
    label: avatar3,
  },
  {
    value: '4',
    label: avatar4,
  },
  {
    value: '5',
    label: avatar5,
  },
  {
    value: '6',
    label: avatar6,
  },
]

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
          display: "excluded",
        },
      },
      {
        name: "username",
        label: "用户名"
      },
      {
        name: "email",
        label: "邮箱",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => (
            <FormControlLabel
              value={value}
              control={<TextField value={value} />}
              onChange={e => {
                updateValue(e.target.value);
                const rowId = tableMeta.rowIndex;
                this.state.datatableData[rowId].email = e.target.value;
              }}
            />
          )
        }
      },
      {
        name: "phone",
        label: "电话",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => (
            <FormControlLabel
              value={value}
              control={<TextField value={value} />}
              onChange={e => {
                updateValue(e.target.value);
                const rowId = tableMeta.rowIndex;
                this.state.datatableData[rowId].phone = e.target.value;
              }}
            />
          )
        }
      },
      {
        name: "avatar",
        label: "头像",
        options: {
          customBodyRender: (value, tableMeta, updateValue) => (
            <TextField
              select
              id="avatar"
              type="avatar"
              value={value}
              onChange={e => {
                updateValue(e.target.value);
                const rowId = tableMeta.rowIndex;
                this.state.datatableData[rowId].avatar = e.target.value;
              }}
              margin="normal"
              variant="outlined"
            >
              {avatars.map((option) => (
                <MenuItem key={option.value} value={option.value}>
                  <Avatar
                    alt={option.value}
                    src={option.label}
                  />
                </MenuItem>
              ))}
            </TextField>
          )
        }
      },
      {
        name: "createdDate",
        label: "注册日期"
      },
      {
        name: "password",
        label: "密码",
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
                startIcon={<ResetPasswordIcon />}
                onClick={() => {
                  var row = this.state.datatableData[dataIndex];
                  axios.post('/User/resetPasswordById', {
                    id: row.id,
                    lastUpdatedBy: cookie.get('username')
                  })
                    .then(res => {
                      if (res.request.response !== "Succeed.") {
                        console.log(res.request.response);
                      }
                    })
                }}
              >
                重置
              </Button>
            );
          }
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
      },
    ],
  }

  componentDidMount() {
    axios.post('/User/searchAllUserList', {})
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
              title="用户列表"
              data={this.state.datatableData}
              columns={this.state.columns}
              options={{
                filterType: "checkbox",
                onRowsDelete: (data) => {
                  for (var i = 0; i < data.data.length; ++i) {
                    var index = data.data[i].dataIndex;
                    var id = this.state.datatableData[index].id;
                    axios.post('/User/hardDeleteUserById', { id: id })
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
  // update email
  if (row.email !== null) {
    data = {
      id: row.id,
      email: row.email,
      lastUpdatedBy: cookie.get('username')
    }
    axios.post('/User/updateEmailById', data)
      .then(res => {
        if (res.request.response !== "Succeed.") {
          console.log(res.request.response);
        }
      })
  }
  // update phone
  if (row.phone !== null) {
    data = {
      id: row.id,
      phone: row.phone,
      lastUpdatedBy: cookie.get('username')
    }
    axios.post('/User/updatePhoneById', data)
      .then(res => {
        if (res.request.response !== "Succeed.") {
          console.log(res.request.response);
        }
      })
  }
  // update avatar
  if (row.avatar !== null) {
    data = {
      id: row.id,
      avatar: row.avatar,
      lastUpdatedBy: cookie.get('username')
    }
    axios.post('/User/updateAvatarById', data)
      .then(res => {
        if (res.request.response !== "Succeed.") {
          console.log(res.request.response);
        }
      })
  }
  // update isActivated
  data = {
    id: row.id,
    lastUpdatedBy: cookie.get('username')
  }
  if (row.isActivated === '0') {
    axios.post('/User/deactivateUserById', data)
      .then(res => {
        if (res.request.response !== "Succeed.") {
          console.log(res.request.response);
        }
      })
  }
  else if (row.isActivated === '1') {
    axios.post('/User/activateUserById', data)
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
    axios.post('/User/restoreUserById', data)
      .then(res => {
        if (res.request.response !== "Succeed.") {
          console.log(res.request.response);
        }
      })
  }
  else if (row.isDeleted === '1') {
    axios.post('/User/softDeleteUserById', data)
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
    axios.post('/User/updateStatusById', data)
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
    axios.post('/User/updateRemarkById', data)
      .then(res => {
        if (res.request.response !== "Succeed.") {
          console.log(res.request.response);
        }
      })
  }
}