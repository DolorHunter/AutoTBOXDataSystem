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
      { name: "username", label: "用户名" },
      { name: "email", label: "邮箱" },
      { name: "phone", label: "电话" },
      { name: "createdDate", label: "注册日期" },
      { name: "isActivated", label: "状态" },
    ],
  }

  componentDidMount() {
    axios.post('/User/searchAllUserList', {})
      .then(res => {
        if (res.status === 200) {
          const datatableData = eval('(' + res.request.response + ')');
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
              }}
            />
          </Grid>
        </Grid>
      </>
    )
  }
}
