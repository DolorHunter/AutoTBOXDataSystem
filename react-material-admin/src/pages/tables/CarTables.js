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
      { name: "carName", label: "车辆名" },
      { name: "price", label: "价格" },
      { name: "periodicalTechnicalInspection", label: "定期技术检查" },
      { name: "roadTax3Months", label: "道路税每三月" },
      { name: "carBody", label: "车身" },
      { name: "transmission", label: "变速箱" },
      { name: "seatsNumber", label: "座位数" },
      { name: "firstYearOfProduction", label: "首次生产年份" },
      { name: "lastYearOfProduction", label: "最后生产年份" },
    ],
    page: {
      "pageIndex": 0,
      "pageSize": 30,
    }
  }

  componentDidMount() {
    axios.post('/Car/searchAllCarPager', this.state.page)
      .then(res => {
        if (res.status === 200) {
          let data = eval('(' + res.request.response + ')');
          let datatableData = data.content;
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
              title="车辆列表"
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