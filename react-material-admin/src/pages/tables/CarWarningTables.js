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
  { name: "vin", label: "车辆识别号码" },
  { name: "carName", label: "车辆名" },
  { name: "warCode", label: "故障代号" },
  { name: "warTags", label: "故障标签" },
  { name: "warLevel", label: "故障等级" },
  { name: "warMessage", label: "故障信息" },
  { name: "warUnit", label: "故障单位" },
]

const datatableData = [];

var page = {
  "pageIndex": 0,
  "pageSize" : 30,
}

axios.post('/CarWarning/searchAllCarWarningPager', page)
.then(res => {
  if (res.status === 200){
    let data = eval('(' + res.request.response + ')');
    let content = data.content;
    for (var i=0;i<content.length;i++) { 
      let id = content[i].id;
      let vin = content[i].vin;
      let carName = content[i].carName;
      let warCode = content[i].warCode;
      let warTags = content[i].warTags;
      let warLevel = content[i].warLevel;
      let warMessage = content[i].warMessage;
      let warUnit = content[i].warUnit;
      let info = {id, vin, carName, warCode, warTags, warLevel, warMessage, warUnit};
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
