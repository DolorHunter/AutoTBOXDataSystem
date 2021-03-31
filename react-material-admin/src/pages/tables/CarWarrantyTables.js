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
      { name: "generalComment", label: "整体评价" },
      { name: "generalScore", label: "整体分数" },
      { name: "driveComment", label: "驱动评价" },
      { name: "driveScore", label: "驱动分数" },
      { name: "fuelEngineComment", label: "燃油引擎评价" },
      { name: "fuelEngineScore", label: "燃油引擎分数" },
      { name: "performanceComment", label: "性能评价" },
      { name: "performanceScore", label: "性能分数" },
      { name: "consumptionComment", label: "效能评价" },
      { name: "consumptionScore", label: "效能分数" },
      { name: "chassisComment", label: "车身评价" },
      { name: "chassisScore", label: "车身分数" },
      { name: "transmissionComment", label: "传动评价" },
      { name: "transmissionScore", label: "传动分数" },
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
              }}
            />
          </Grid>
        </Grid>
      </>
    )
  }
}