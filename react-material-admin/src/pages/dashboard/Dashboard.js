import React, { useState } from "react";
import {
  Grid,
  LinearProgress,
} from "@material-ui/core";
import { useTheme } from "@material-ui/styles";
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import {
  ResponsiveContainer,
  AreaChart,
  LineChart,
  Line,
  Area,
  PieChart,
  Pie,
  Cell,
  YAxis,
  XAxis,
  CartesianGrid,
  Legend,
  Tooltip,
} from "recharts";

// styles
import useStyles from "./styles";

// components
import Widget from "../../components/Widget";
import { Typography } from "../../components/Wrappers";
import Dot from "../../components/Sidebar/components/Dot";
import BigStat from "./components/BigStat/BigStat";

import axios from 'axios';

var errorCounter = ""
var errorCarCounter = ""
var errorCategoryCounter = ""
var errorYesterday = ""
var errorAvgWeekly = ""
const errorData = []
const errorCarData = []
const errorCategoryData = []
const errorCategoryPie = [
  { name: "Group A", value: 400, color: "primary" },
  { name: "Group B", value: 300, color: "secondary" },
  { name: "Group C", value: 300, color: "warning" },
  { name: "Group D", value: 200, color: "success" },
];


function appendZero(obj){
  if(obj<10) return "0" +""+ obj;
  else return obj;
}
var date = new Date();

var year = date.getFullYear();
var month = appendZero(date.getMonth() + 1);
var day = appendZero(date.getDate());
var hour = appendZero(date.getHours());
var chartTimestramp = ""+year+month+day+hour;

function addErrorToday(content){
  errorCounter = content.errorCounter;
  errorCarCounter = content.errorCarCounter;
  errorCategoryCounter = content.errorCategoryCounter;
  errorYesterday = content.errorYesterday;
  errorAvgWeekly = content.errorAvgWeekly;
  errorData.push(content.errorData);
  errorCarData.push(content.errorCarData);
  errorCategoryData.push(content.errorCategoryData);
  errorCategoryPie.push(content.errorCategoryPie);
}

axios.post('/VisualChart/searchVisualChartByChartName', 
            {"chartName":"dashboard-errorToday-"+chartTimestramp})
.then(res => {
  if (res.status === 200){
    let data = eval('(' + res.request.response + ')');
    let content = data.chartData.replace(/'/g,"\"");
    content = JSON.parse(content);
    addErrorToday(content);
  }
})


const lineChartData = [
  {
    date: "2021/03/11",
    uv: 4000,
    pv: 2400,
    amt: 2400,
  },
  {
    date: "2021/03/06",
    uv: 3000,
    pv: 1398,
    amt: 2210,
  },
  {
    date: "2021/03/07",
    uv: 2000,
    pv: 9800,
    amt: 2290,
  },
  {
    date: "2021/03/08",
    uv: 2780,
    pv: 3908,
    amt: 2000,
  },
  {
    date: "2021/03/09",
    uv: 1890,
    pv: 4800,
    amt: 2181,
  },
  {
    date: "2021/03/10",
    uv: 2390,
    pv: 3800,
    amt: 2500,
  },
  {
    date: "2021/03/11",
    uv: 3490,
    pv: 4300,
    amt: 2100,
  },
];

const rows = [
  {id: 1, sendingTime: 159, vin:"LX", errorContent: 6, faultCategory: 24},
  {id: 2, sendingTime: 237, vin:"LX", errorContent: 9, faultCategory: 37},
  {id: 3, sendingTime: 262, vin:"LX", errorContent: 16, faultCategory: 24},
  {id: 4, sendingTime: 305, vin:"LX", errorContent: 3, faultCategory: 67},
  {id: 5, sendingTime: 356, vin:"LX", errorContent: 16, faultCategory: 3},
  {id: 6, sendingTime: 356, vin:"LX", errorContent: 16, faultCategory: 3},
  {id: 7, sendingTime: 356, vin:"LX", errorContent: 16, faultCategory: 3},
];

const bigStatData = [
  {
    product: "Light Blue",
    total: {
      monthly: 4232,
      weekly: 1465,
      daily: 199,
      percent: { value: 3.7, profit: false }
    },
    color: "primary",
    registrations: {
      monthly: { value: 830, profit: false },
      weekly: { value: 215, profit: true },
      daily: { value: 33, profit: true }
    },
    bounce: {
      monthly: { value: 4.5, profit: false },
      weekly: { value: 3, profit: true },
      daily: { value: 3.25, profit: true }
    }
  },
  {
    product: "Sing App",
    total: {
      monthly: 754,
      weekly: 180,
      daily: 27,
      percent: { value: 2.5, profit: true }
    },
    color: "warning",
    registrations: {
      monthly: { value: 32, profit: true },
      weekly: { value: 8, profit: true },
      daily: { value: 2, profit: false }
    },
    bounce: {
      monthly: { value: 2.5, profit: true },
      weekly: { value: 4, profit: false },
      daily: { value: 4.5, profit: false }
    }
  },
  {
    product: "RNS",
    total: {
      monthly: 1025,
      weekly: 301,
      daily: 44,
      percent: { value: 3.1, profit: true }
    },
    color: "secondary",
    registrations: {
      monthly: { value: 230, profit: true },
      weekly: { value: 58, profit: false },
      daily: { value: 15, profit: false }
    },
    bounce: {
      monthly: { value: 21.5, profit: false },
      weekly: { value: 19.35, profit: false },
      daily: { value: 10.1, profit: true }
    }
  }
];

export default function Dashboard(props){
  var classes = useStyles();
  var theme = useTheme();

  return (
    <>
      <Grid container spacing={4}>
        <Grid item lg={3} md={4} sm={6} xs={12}>
          <Widget
            title="过去24小时故障"
            upperTitle
            bodyClass={classes.fullHeightBody}
            className={classes.card}
          >
            <div className={classes.visitsNumberContainer}>
              <Grid container item alignItems={"center"}>
                <Grid item xs={6}>
              <Typography size="xl" weight="medium" noWrap>
                {errorCounter}
              </Typography>
                </Grid>
                <Grid item xs={6}>
              <LineChart
                width={100}
                height={30}
                data={errorData}
              >
                <Line
                  type="natural"
                  dataKey="value"
                  stroke={theme.palette.success.main}
                  strokeWidth={2}
                  dot={false}
                />
              </LineChart>
                </Grid>
              </Grid>
            </div>
            <Grid
              container
              direction="row"
              justify="space-between"
              alignItems="center"
            >
              <Grid item xs={4}>
                <Typography color="text" colorBrightness="secondary" noWrap>
                  故障车辆
                </Typography>
                <Typography size="md">{errorCarCounter}</Typography>
              </Grid>
              <Grid item xs={4}>
                <Typography color="text" colorBrightness="secondary" noWrap>
                  故障单元
                </Typography>
                <Typography size="md">{errorCategoryCounter}</Typography>
              </Grid>
              <Grid item xs={4}>
                <Typography color="text" colorBrightness="secondary" noWrap>
                  车辆平均故障
                </Typography>
                <Typography size="md">{(errorCategoryCounter/errorCarCounter).toFixed(2)}</Typography>
              </Grid>
            </Grid>
          </Widget>
        </Grid>
        <Grid item lg={3} md={8} sm={6} xs={12}>
          <Widget
            title="平均故障"
            upperTitle
            className={classes.card}
            bodyClass={classes.fullHeightBody}
          >
            <div className={classes.performanceLegendWrapper}>
              <div className={classes.legendElement}>
                <Dot color="warning" />
                <Typography
                  color="text"
                  colorBrightness="secondary"
                  className={classes.legendElementText}
                >
                  过去24小时故障
                </Typography>
              </div>
              <div className={classes.legendElement}>
                <Dot color="primary" />
                <Typography
                  color="text"
                  colorBrightness="secondary"
                  className={classes.legendElementText}
                >
                  本周平均故障
                </Typography>
              </div>
            </div>
            <div className={classes.progressSection}>
              <Typography
                size="md"
                color="text"
                colorBrightness="secondary"
                className={classes.progressSectionTitle}
              >
                过去24小时故障
              </Typography>
              <LinearProgress
                variant="determinate"
                value={errorYesterday}
                classes={{ barColorPrimary: classes.progressBarWarning }}
                className={classes.progress}
              />
            </div>
            <div>
              <Typography
                size="md"
                color="text"
                colorBrightness="secondary"
                className={classes.progressSectionTitle}
              >
                本周平均故障
              </Typography>
              <LinearProgress
                variant="determinate"
                value={errorAvgWeekly}
                classes={{ barColorPrimary: classes.progressBarPrimary }}
                className={classes.progress}
              />
            </div>
          </Widget>
        </Grid>
        <Grid item lg={3} md={8} sm={6} xs={12}>
          <Widget
            title="过去24小时故障概览"
            upperTitle
            className={classes.card}
            bodyClass={classes.fullHeightBody}
          >
            <div className={classes.serverOverviewElement}>
              <Typography
                color="text"
                colorBrightness="secondary"
                className={classes.serverOverviewElementText}
                noWrap
              >
              故障
              </Typography> 
              <div className={classes.serverOverviewElementChartWrapper}>
                <ResponsiveContainer height={50} width="99%">
                  <AreaChart data={errorData}>
                    <Area
                      type="natural"
                      dataKey="value"
                      stroke={theme.palette.secondary.main}
                      fill={theme.palette.secondary.light}
                      strokeWidth={2}
                      fillOpacity="0.25"
                    />
                  </AreaChart>
                </ResponsiveContainer>
              </div>
            </div>
            <div className={classes.serverOverviewElement}>
              <Typography
                color="text"
                colorBrightness="secondary"
                className={classes.serverOverviewElementText}
                noWrap
              >
              故障车辆
              </Typography>
              <div className={classes.serverOverviewElementChartWrapper}>
                <ResponsiveContainer height={50} width="99%">
                  <AreaChart data={errorCarData}>
                    <Area
                      type="natural"
                      dataKey="value"
                      stroke={theme.palette.primary.main}
                      fill={theme.palette.primary.light}
                      strokeWidth={2}
                      fillOpacity="0.25"
                    />
                  </AreaChart>
                </ResponsiveContainer>
              </div>
            </div>
            <div className={classes.serverOverviewElement}>
              <Typography
                color="text"
                colorBrightness="secondary"
                className={classes.serverOverviewElementText}
                noWrap
              >
              故障单元
              </Typography>
              <div className={classes.serverOverviewElementChartWrapper}>
                <ResponsiveContainer height={50} width="99%">
                  <AreaChart data={errorCategoryData}>
                    <Area
                      type="natural"
                      dataKey="value"
                      stroke={theme.palette.warning.main}
                      fill={theme.palette.warning.light}
                      strokeWidth={2}
                      fillOpacity="0.25"
                    />
                  </AreaChart>
                </ResponsiveContainer>
              </div>
            </div>
          </Widget>
        </Grid>
        <Grid item lg={3} md={4} sm={6} xs={12}>
          <Widget title="过去24小时故障单元" upperTitle className={classes.card}>
            <Grid container spacing={2}>
              <Grid item xs={6}>
                <ResponsiveContainer width="100%" height={144}>
                  <PieChart>
                    <Pie
                      data={errorCategoryPie}
                      innerRadius={30}
                      outerRadius={40}
                      dataKey="value"
                    >
                      {errorCategoryPie.map((entry, index) => (
                        <Cell
                          key={`cell-${index}`}
                          fill={theme.palette[entry.color].main}
                        />
                      ))}
                    </Pie>
                  </PieChart>
                </ResponsiveContainer>
              </Grid>
              <Grid item xs={6}>
                <div className={classes.pieChartLegendWrapper}>
                  {errorCategoryPie.map(({ name, value, color }, index) => (
                    <div key={color} className={classes.legendItemContainer}>
                      <Dot color={color} />
                      <Typography style={{ whiteSpace: "nowrap", fontSize: 12 }} >
                        &nbsp;{name}&nbsp;
                      </Typography>
                      <Typography color="text" colorBrightness="secondary">
                        &nbsp;{value}
                      </Typography>
                    </div>
                  ))}
                </div>
              </Grid>
            </Grid>
          </Widget>
        </Grid>
        <Grid item lg={9} md={24} sm={18} xs={36}>
          <Widget title="过去一周故障情况" noBodyPadding upperTitle>
            <ResponsiveContainer width="99%" height={400}>
              <LineChart
                width={500}
                height={400}
                data={lineChartData}
                margin={{
                  top: 5,
                  right: 30,
                  left: 20,
                  bottom: 5,
                }}
              >
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis
                  tickFormatter={i => i + 1}
                  tick={{ fill: theme.palette.text.hint + "80", fontSize: 14 }}
                  stroke={theme.palette.text.hint + "80"}
                  tickLine={false}
                  dataKey="date"
                />
                <YAxis
                  ticks={[]}
                  tick={{ fill: theme.palette.text.hint + "80", fontSize: 14 }}
                  stroke={theme.palette.text.hint + "80"}
                  tickLine={false}
                />
                <Tooltip />
                <Legend />
                <Line
                  type="monotone"
                  dataKey="pv"
                  stroke={theme.palette.primary.main}
                  activeDot={{ r: 8 }}
                />
                <Line
                  type="monotone"
                  dataKey="uv"
                  stroke={theme.palette.secondary.main}
                />
              </LineChart>
            </ResponsiveContainer>
          </Widget>
        </Grid>
        <Grid item lg={3} md={8} sm={6} xs={12}>
          <TableContainer component={Paper}>
            <Table className={classes.table} aria-label="实时故障信息">
              <TableHead>
                <TableRow>
                  <TableCell>时间</TableCell>
                  <TableCell align="right">VIN</TableCell>
                  <TableCell align="right">错误内容</TableCell>
                  <TableCell align="right">故障类别</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {rows.map((row) => (
                  <TableRow key={row.id}>
                    <TableCell component="th" scope="row">
                      {row.sendingTime}
                    </TableCell>
                    <TableCell align="right">{row.vin}</TableCell>
                    <TableCell align="right">{row.errorContent}</TableCell>
                    <TableCell align="right">{row.faultCategory}</TableCell>
                  </TableRow>
                ))}
              </TableBody>
            </Table>
          </TableContainer>
        </Grid>
        {bigStatData.map(stat => (
          <Grid item md={4} sm={6} xs={12} key={stat.product}>
            <BigStat {...stat} />
          </Grid>
        ))}
      </Grid>
    </>
  );
}
