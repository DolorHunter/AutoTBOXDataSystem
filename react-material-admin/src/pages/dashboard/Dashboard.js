import React, { useState, useEffect } from 'react';
import {
  Grid,
  LinearProgress,
  Container,
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
import Calender from "./components/Calender/Calender";

import axios from 'axios';

export default function Dashboard(props) {
  const classes = useStyles();
  const theme = useTheme();

  const FAULT_CATEGORY_MAPPING = ["TBOX", "EMS", "ESC", "EPS", "TCU", "SRS", "ICM", "MP5", "PEPS", "PDC", "ESCL", "HVAC", "AVM", "BCM", "BSD", "SLC", "MRR", "MPC", "LDFC", "APA", "IMMO", "CFP", "PLG", "FPCM"]

  var [errorCounter, setErrorCounter] = useState(0);
  var [errorCarCounter, setErrorCarCounter] = useState(0);
  var [errorCategoryCounter, setErrorCategoryCounter] = useState(0);
  var [errorToday, setErrorToday] = useState(0);
  var [errorAvgWeekly, setErrorAvgWeekly] = useState(0);
  var [errorData, setErrorData] = useState([]);
  var [errorCarData, setErrorCarData] = useState([]);
  var [errorCategoryData, setErrorCategoryData] = useState([]);
  var [errorCategoryPie, setErrorCategoryPie] = useState([]);

  var [lineChartData, setLineChartData] = useState([]);
  var [realtimeData, setrealtimeData] = useState([]);
  var [calenderData, setCalenderData] = useState([]);

  useEffect(() => {
    axios.post('/VisualChart/searchVisualChartByChartName',
      { "chartName": "dashboard-daily-" + dailyTimestamp })
      .then(res => {
        if (res.status === 200 && Object.keys(res.request.response).length > 0) {
          const data = JSON.parse(res.request.response);
          let content = data.chartData.replace(/'/g, "\"");
          content = JSON.parse(content);
          setErrorCounter(content.errorCounter);
          setErrorCarCounter(content.errorCarCounter);
          setErrorCategoryCounter(content.errorCategoryCounter);
          setErrorToday(content.errorToday);
          setErrorAvgWeekly(content.errorAvgWeekly);
          setErrorData(content.errorData);
          setErrorCarData(content.errorCarData);
          setErrorCategoryData(content.errorCategoryData);
          setErrorCategoryPie(content.errorCategoryPie);
          setLineChartData(content.errorLastWeek);
          setCalenderData(content.errorYearly);
        }
      })
  }, []);

  useEffect(() => {
    axios.post('/CarWarning/searchCarWarningDetailBySendingTimeBetween',
      { "sendingTime": realtimeErrorTimestamp, "remark": Date.now() })
      .then(res => {
        if (res.status === 200 && Object.keys(res.request.response).length > 0) {
          const data = JSON.parse(res.request.response);
          for (var i = 0; i < data.length; i++) {
            let timestamp = Number(data[i][0]);
            let date = new Date(timestamp);
            let year = date.getFullYear();
            let month = appendZero(date.getMonth() + 1);
            let day = appendZero(date.getDate());
            let hour = appendZero(date.getHours());
            let min = appendZero(date.getHours());
            let sec = appendZero(date.getSeconds());
            data[i][0] = "" + year + "/" + month + "/" + day + " " + 
                                    hour + ":" + min + ":" + sec;

            let faultCategory = data[i][2];
            let faultIndex = parseInt(faultCategory, 16);
            data[i][2] = FAULT_CATEGORY_MAPPING[faultIndex];
          }
          setrealtimeData(data.reverse());
        }
      })
  }, []);

  return (
    <>
      <Grid container spacing={2}>
        <Grid item lg={3} md={4} sm={6} xs={12}>
          <Widget
            title="昨日故障"
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
                <Typography size="md">{(errorCounter / errorCarCounter).toFixed(2)}</Typography>
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
                  昨日故障
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
                昨日故障
              </Typography>
              <LinearProgress
                variant="determinate"
                value={errorToday}
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
            title="昨日故障概览"
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
          <Widget title="昨日故障单元" upperTitle className={classes.card}>
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
        <Grid container spacing={2} direction="row">
          <Grid item xs={6}>
            <Grid container spacing={2}>
              <Grid item xs={12}>
                <Widget title="过去一周故障情况" noBodyPadding upperTitle>
                  <ResponsiveContainer width="99%" height={400}>
                    <LineChart
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
                      <XAxis dataKey="date" />
                      <YAxis />
                      <Tooltip />
                      <Legend />
                      <Line
                        type="monotone"
                        dataKey="故障车辆"
                        stroke={theme.palette.primary.main}
                        activeDot={{ r: 8 }}
                      />
                      <Line
                        type="monotone"
                        dataKey="故障单元"
                        stroke={theme.palette.secondary.main}
                        activeDot={{ r: 4 }}
                      />
                      <Line
                        type="monotone"
                        dataKey="故障"
                        stroke={theme.palette.warning.main}
                      />
                    </LineChart>
                  </ResponsiveContainer>
                </Widget>
              </Grid>
              <Grid item xs={12}>
                <Widget title="本年度故障情况" noBodyPadding upperTitle>
                  <Grid item xs={12}>
                    <ResponsiveContainer width="100%" height={175}>
                      <Calender
                        data={calenderData}
                        height={175}
                      />
                    </ResponsiveContainer>
                  </Grid>
                </Widget>
              </Grid>
            </Grid>
          </Grid>
          <Grid item xs={6}>
            <Grid item xs={12}>
              <TableContainer component={Paper} style={{ height: 720 }}>
                <Table className={classes.table} stickyHeader aria-label="实时故障信息">
                  <TableHead>
                    <TableRow>
                      <TableCell>
                        <Typography variant="h6" className={classes.text}>
                          过去24h实时故障
                        </Typography>
                      </TableCell>
                      <TableCell align="right">车辆型号</TableCell>
                      <TableCell align="right">故障单元</TableCell>
                      <TableCell align="right">错误内容</TableCell>
                    </TableRow>
                  </TableHead>
                  <TableBody>
                    {realtimeData.map((row) => (
                      <TableRow key={row.id}>
                        <TableCell component="th" scope="row">
                          {row[0]}
                        </TableCell>
                        <TableCell align="right">{row[1]}</TableCell>
                        <TableCell align="right">{row[2]}</TableCell>
                        <TableCell align="right">{row[3]}</TableCell>
                      </TableRow>
                    ))}
                  </TableBody>
                </Table>
              </TableContainer>
            </Grid>
          </Grid>
        </Grid>
      </Grid>
    </>
  );
}
// #####################################################################
function appendZero(obj) {
  if (obj < 10) return "0" + "" + obj;
  else return obj;
}
var date = new Date();
var year = date.getFullYear();
const hasTimestamp = new Date() - new Date(year.toString());
const hasDays = Math.ceil(hasTimestamp / 86400000);
var dailyTimestamp = "" + year + hasDays;
var realtimeErrorTimestamp = Date.now() - 86400000;