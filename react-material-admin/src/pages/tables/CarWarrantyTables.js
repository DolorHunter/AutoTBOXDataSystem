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
]

const datatableData = [];

var page = {
  "pageIndex": 0,
  "pageSize" : 30,
}

axios.post('/CarWarranty/searchAllCarWarrantyPager', page)
.then(res => {
  if (res.status === 200){
    let data = eval('(' + res.request.response + ')');
    let content = data.content;
    for (var i=0;i<content.length;i++) { 
      let id = content[i].vin;
      let vin = content[i].vin;
      let generalComment = content[i].generalComment;
      let generalScore = content[i].generalScore;
      let driveComment = content[i].driveComment;
      let driveScore = content[i].driveScore;
      let fuelEngineComment = content[i].fuelEngineComment;
      let fuelEngineScore = content[i].fuelEngineScore;
      let performanceComment = content[i].performanceComment;
      let performanceScore = content[i].performanceScore;
      let consumptionComment = content[i].consumptionComment;
      let consumptionScore = content[i].consumptionScore;
      let chassisComment = content[i].chassisComment;
      let chassisScore = content[i].chassisScore;
      let transmissionComment = content[i].transmissionComment;
      let transmissionScore = content[i].transmissionScore;
      let info = {id, vin, generalComment, generalScore, driveComment, driveScore, 
        fuelEngineComment, fuelEngineScore, performanceComment, performanceScore, 
        consumptionComment, consumptionScore, chassisComment, chassisScore, 
        transmissionComment, transmissionScore};
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
