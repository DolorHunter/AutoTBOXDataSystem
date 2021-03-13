import React from "react";
import { Grid } from "@material-ui/core";
import MUIDataTable from "mui-datatables";

import axios from 'axios';

const columns = [
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
]

const datatableData = [];

var page = {
  "pageIndex": 0,
  "pageSize" : 30,
}

axios.post('/Car/searchAllCarPager', page)
.then(res => {
  if (res.status === 200){
    let data = eval('(' + res.request.response + ')');
    let content = data.content;
    for (var i=0;i<content.length;i++) {
      let id = content[i].id;
      let carName = content[i].carName;
      let price = content[i].price;
      let periodicalTechnicalInspection = content[i].periodicalTechnicalInspection;
      let roadTax3Months = content[i].roadTax3Months;
      let carBody = content[i].carBody;
      let transmission = content[i].transmission;
      let seatsNumber = content[i].seatsNumber;
      let firstYearOfProduction = content[i].firstYearOfProduction;
      let lastYearOfProduction = content[i].lastYearOfProduction;
      let info = {id, carName, price, periodicalTechnicalInspection, roadTax3Months, 
        carBody, transmission, seatsNumber, firstYearOfProduction, lastYearOfProduction};
      datatableData.push(info);
    }
  }
})

export default function Tables() {
  return (
    <>
      <Grid container spacing={4}>
        <Grid item xs={12}>
          <MUIDataTable
            title="车辆列表"
            data={datatableData}
            columns={columns}
            options={{
              filterType: "checkbox",
            }}
          />
        </Grid>
      </Grid>
    </>
  );
}