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
  { name: "name", label: "用户名" },
  { name: "email", label: "邮箱" },
  { name: "phone", label: "电话" },
  { name: "createdDate", label: "注册日期" },
  { name: "status", label: "状态" },
]

const datatableData = [];

var page = {
  "pageIndex": 0,
  "pageSize" : 30,
}

axios.post('/User/searchAllUserPager', page)
.then(res => {
  if (res.status === 200){
    let data = eval('(' + res.request.response + ')');
    let content = data.content;
    for (var i=0;i<content.length;i++) { 
      let id = content[i].id;
      let name = content[i].username;
      let email = content[i].email;
      let phone = content[i].phone;
      let createdDate = content[i].createdDate;
      let status = content[i].isActivated;
      if (status === "1"){
        status = "启用";
      }else{
        status = "禁用";
      }
      let info = {id, name, email, phone, createdDate, status};
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
            title="用户列表"
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
