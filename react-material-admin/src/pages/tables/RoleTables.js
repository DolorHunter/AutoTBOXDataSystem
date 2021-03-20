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
  { name: "roleName", label: "角色名" },
  { name: "roleType", label: "角色类型" },
]

const datatableData = [];

var page = {
  "pageIndex": 0,
  "pageSize" : 30,
}

axios.post('/Role/searchAllRolePager', page)
.then(res => {
  if (res.status === 200){
    let data = eval('(' + res.request.response + ')');
    let content = data.content;
    for (var i=0;i<content.length;i++) { 
      datatableData.push(content[i]);
    }
  }
})

export default function Tables() {
  return (
    <>
      <Grid container spacing={4}>
        <Grid item xs={12}>
          <MUIDataTable
            title="角色列表"
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
