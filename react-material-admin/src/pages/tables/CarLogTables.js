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
      { name: "vin", label: "车辆识别号码" },
      { name: "bootTime", label: "开机时间" },
      { name: "runTime", label: "运行时长" },
      { name: "gear", label: "挡位" },
      { name: "odometer", label: "行驶里程" },
      { name: "odometerRem", label: "剩余里程" },
      { name: "odometerAcc", label: "累计里程" },
      { name: "fuelRem", label: "剩余油量" },
      { name: "electroFuelRem", label: "剩余电量" },
      { name: "speed", label: "车速" },
      { name: "location", label: "位置" },
      { name: "heading", label: "方向" },
      { name: "altitude", label: "高度" }
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
              }}
            />
          </Grid>
        </Grid>
      </>
    )
  }
}