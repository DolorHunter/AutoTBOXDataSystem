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
      { name: "roleName", label: "角色名" },
      { name: "roleType", label: "角色类型" },
    ],
    page: {
      "pageIndex": 0,
      "pageSize": 30,
    }
  }

  componentDidMount() {
    axios.post('/Role/searchAllRoleList', {})
      .then(res => {
        if (res.status === 200) {
          let datatableData = eval('(' + res.request.response + ')');
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
              }}
            />
          </Grid>
        </Grid>
      </>
    )
  }
}
