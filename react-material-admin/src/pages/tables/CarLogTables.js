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
]

const datatableData = [];

var page = {
  "pageIndex": 0,
  "pageSize" : 30,
}

axios.post('/CarLog/searchAllCarLogPager', page)
.then(res => {
  if (res.status === 200){
    let data = eval('(' + res.request.response + ')');
    let content = data.content;
    for (var i=0;i<content.length;i++) { 
      let id = content[i].id;
      let vin = content[i].vin;
      let bootTime = content[i].bootTime;
      let runTime = content[i].runTime;
      let gear = content[i].gear;
      let odometer = content[i].odometer;
      let odometerRem = content[i].odometerRem;
      let odometerAcc = content[i].odometerAcc;
      let fuelRem = content[i].fuelRem;
      let electroFuelRem = content[i].electroFuelRem;
      let speed = content[i].speed;
      let location = content[i].location;
      let heading = content[i].heading;
      let altitude = content[i].altitude;
      let info = {id, vin, bootTime, runTime, gear, odometer, odometerRem, odometerAcc, 
        fuelRem, electroFuelRem, speed, location, heading, altitude};
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
