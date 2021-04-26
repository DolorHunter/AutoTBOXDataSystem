import React, { useState, useEffect } from 'react';
import { 
  Grid,
  Button,
  TextField,
  MenuItem,
  Avatar,
} from "@material-ui/core";
import SaveIcon from '@material-ui/icons/Save';
import { ArrowLeftRounded } from '@material-ui/icons';

import cookie from 'js-cookie';
import axios from 'axios';

import Widget from "../../components/Widget/Widget";

// styles
import useStyles from "./styles";

// logo
import avatar1 from "./../../images/avatar/avatar_01.jpg";
import avatar2 from "./../../images/avatar/avatar_02.jpg";
import avatar3 from "./../../images/avatar/avatar_03.jpg";
import avatar4 from "./../../images/avatar/avatar_04.jpg";
import avatar5 from "./../../images/avatar/avatar_05.jpg";
import avatar6 from "./../../images/avatar/avatar_06.jpg";

const avatars = [
  {
    value: '1',
    label: avatar1,
  },
  {
    value: '2',
    label: avatar2,
  },
  {
    value: '3',
    label: avatar3,
  },
  {
    value: '4',
    label: avatar4,
  },
  {
    value: '5',
    label: avatar5,
  },
  {
    value: '6',
    label: avatar6,
  },
]

export default function Profile(props){
  const classes = useStyles();

  var [profile, setProfile] = useState({
    id: cookie.get('uuid'),
    createdDate: '',
    lastUpdatedDate: '',
    username: cookie.get('username'),
    email: '',
    phone: '',
    avatar: '1',
  });

  useEffect(() => {
    axios.post('/User/searchUserById', {id: cookie.get('uuid')})
      .then(res => {
        if (res.status === 200 && Object.keys(res.request.response).length > 0){
          setTimeout(() => {
            const data = JSON.parse(res.request.response);
            setProfile({ ...profile, 
              createdDate: data.createdDate,
              lastUpdatedDate: data.lastUpdatedDate,
              email: data.email, 
              phone: data.phone,
              avatar: data.avatar})
          }, 300);
        }
      })  
  }, [])

  return (
    <>
      <Grid container spacing={4}>
        <Widget title="个人资料" noBodyPadding upperTitle>
          <div className={classes.root}>
            <div class={classes.left}>
              <TextField
                disabled
                id="id"
                label="ID"
                type="id"
                value={profile.id}
                margin="normal"
                variant="outlined"
                fullWidth
              />
              <TextField
                disabled
                id="username"
                label="用户名"
                type="username"
                value={profile.username}
                margin="normal"
                variant="outlined"
                fullWidth
              />
              <TextField
                id="email"
                label="电子邮件"
                type="email"
                value={profile.email}
                onChange={e => {
                  setProfile({ ...profile, email: e.target.value });
                }}
                margin="normal"
                variant="outlined"
              />
              <Button
                variant="contained"
                color="primary"
                size="large"
                className={classes.button}
                startIcon={<SaveIcon />}
                disabled={profile.email.length === 0 ||
                  !validateEmail(profile.email)}
                onClick={() =>
                  updateEmail(profile)
                }
              >
                保存
              </Button>
              <TextField
                id="phone"
                label="电话"
                type="phone"
                value={profile.phone}
                onChange={e => {
                  setProfile({ ...profile, phone: e.target.value });
                }}
                margin="normal"
                variant="outlined"
              />
              <Button
                variant="contained"
                color="primary"
                size="large"
                className={classes.button}
                startIcon={<SaveIcon />}
                disabled={profile.phone.length === 0 ||
                  !validatePhone(profile.phone)}
                onClick={() =>
                  updatePhone(profile)
                }
              >
                保存
              </Button>
              <TextField
                disabled
                id="createdDate"
                label="创建日期"
                value={profile.createdDate}
                margin="normal"
                variant="outlined"
                fullWidth
              />
              <TextField
                disabled
                id="lastUpdatedDate"
                label="最后修改日期"
                value={profile.lastUpdatedDate}
                margin="normal"
                variant="outlined"
                fullWidth
              />
            </div>
            <div className={classes.right}>
              <Avatar 
                alt={profile.username} 
                src={avatars[parseInt(profile.avatar)-1].label} 
                className={classes.large}
              />
              <TextField
                select
                id="avatar"
                label="头像"
                type="avatar"
                value={profile.avatar}
                onChange={e => {
                  setProfile({ ...profile, avatar: e.target.value });
                }}
                margin="normal"
                variant="outlined"
              >
                {avatars.map((option) => (
                  <MenuItem key={option.value} value={option.value}>
                    <Avatar 
                      alt={option.value} 
                      src={option.label} 
                    />
                  </MenuItem>
                ))}
              </TextField>
              <Button
                variant="contained"
                color="primary"
                size="large"
                className={classes.button}
                startIcon={<SaveIcon />}
                disabled={profile.avatar.length === 0}
                onClick={() =>
                  updateAvatar(profile)
                }
              >
                保存
              </Button>
            </div>
          </div>
        </Widget>
      </Grid>
    </>
  )
}
// ##############################################################
function validateEmail(email) {
  const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(String(email).toLowerCase());
}
function validatePhone(phone) {
  return phone.match(/\d/g).length===11;
}
function updatePhone(profile) {
  axios.post('/User/updatePhoneById', 
  {
    "id": profile.id,
    "phone": profile.phone,
    "lastUpdatedBy": profile.username,
  })
  .then(res => {
    if (res.request.response !== "Succeed."){
      ArrowLeftRounded(res.request.response);
    }
  })
}
function updateEmail(profile) {
  axios.post('/User/updateEmailById', 
  {
    "id": profile.id,
    "email": profile.email,
    "lastUpdatedBy": profile.username,
  })
  .then(res => {
    if (res.request.response !== "Succeed."){
      ArrowLeftRounded(res.request.response);
    }
  })
}
function updateAvatar(profile) {
  axios.post('/User/updateAvatarById', 
  {
    "id": profile.id,
    "avatar": profile.avatar,
    "lastUpdatedBy": profile.username,
  })
  .then(res => {
    if (res.request.response !== "Succeed."){
      ArrowLeftRounded(res.request.response);
    }
  })
}