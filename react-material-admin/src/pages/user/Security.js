import React, { useState, useEffect } from 'react';
import { 
  Grid,
  Button,
  TextField,
} from "@material-ui/core";
import {
  Save as SaveIcon,
  HelpOutline as HelpOutlineIcon,
} from '@material-ui/icons';

import md5 from 'js-md5';
import cookie from 'js-cookie';
import axios from 'axios';

import { Typography } from "../../components/Wrappers";
import Widget from "../../components/Widget/Widget";

// styles
import useStyles from "./styles";

export default function Security(props){
  const classes = useStyles();

  var [oldPassword, setOldPassword] = useState("");
  var [newPassword, setNewPassword] = useState("");
  var [confirmNewPassword, setConfirmNewPassword] = useState("");

  return (
    <>
      <Grid container spacing={4}>
        <Widget title="账户安全" noBodyPadding upperTitle width="125px">
          <div className={classes.root}>
            <div class={classes.left}>
              <Typography variant="h6" weight="medium" className={classes.text} >
                修改密码
              </Typography>
              <TextField
                id="oldPassword"
                label="旧密码"
                type="password"
                value={oldPassword}
                onChange={e => {
                  setOldPassword(e.target.value);
                }}
                margin="normal"
                variant="outlined"
                fullWidth
              />
              <TextField
                id="newPassword"
                label="新密码"
                type="password"
                value={newPassword}
                onChange={e => {
                  setNewPassword(e.target.value);
                }}
                margin="normal"
                variant="outlined"
                fullWidth
              />
              <TextField
                id="confirmNewPassword"
                label="确认密码"
                type="password"
                value={confirmNewPassword}
                onChange={e => {
                  setConfirmNewPassword(e.target.value);
                }}
                margin="normal"
                variant="outlined"
                fullWidth
              />
              <Typography variant="h6" weight="medium" className={classes.text} >
                *新密码必须至少为六位，并且包含大小写字母与数字。
              </Typography>
              <Button
                variant="contained"
                color="primary"
                size="large"
                className={classes.button}
                startIcon={<SaveIcon />}
                disabled={oldPassword.length === 0 ||
                  newPassword.length === 0 ||
                  confirmNewPassword.length === 0 ||
                  newPassword !== confirmNewPassword ||
                  !validatePassword(newPassword)}
                onClick={() =>
                  updatePassword(oldPassword, newPassword)
                }
              >
                更新密码
              </Button>
              <Button
                variant="contained"
                color="secondary"
                size="large"
                className={classes.button}
                startIcon={<HelpOutlineIcon />}
                onClick={() => alert("请联系管理员重置密码.")}
              >
                忘记密码
              </Button>
            </div>
          </div>
        </Widget>
      </Grid>
    </>
  )
}
// ##############################################################
function validatePassword(password) {
  const re = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{6,})$/;
  return re.test(password);
}
function updatePassword(oldPassword, newPassword) {
  axios.post('/User/updatePasswordById', {
    "id": cookie.get('uuid'),
    "remark": md5(oldPassword),
    "password": md5(newPassword),
    "lastUpdatedBy": cookie.get('username')
  })
    .then(res => {
      if (res.request.response !== "Succeed."){
        alert(res.request.response);
      }
    })
}