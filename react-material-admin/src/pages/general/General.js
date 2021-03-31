import React, { useState, useEffect } from 'react';
import { Grid } from "@material-ui/core";

import { ResponsiveContainer } from "recharts";

import Widget from "../../components/Widget/Widget";
import Treemap from "./components/Treemap/Treemap";
import ScatterPlot from "./components/ScatterPlot/ScatterPlot";
import Bar from "./components/Bar/Bar";
import Bar2 from "./components/Bar/Bar2";

import axios from 'axios';

export default function General(props) {

	var [scatterPlotData, setScatterPlotData] = useState([]);
  var [treemapData, setTreemapData] = useState([]);
	var [barData, setBarData] = useState([]);
	var [barData2, setBarData2] = useState([]);

	useEffect(() => {
		axios.post('/VisualChart/searchVisualChartByChartName',
    { "chartName": "general-daily-" + dailyTimestamp })
    .then(res => {
			if (res.status === 200 && Object.keys(res.request.response).length > 0) {
				const data = JSON.parse(res.request.response);
				let content = data.chartData.replace(/'/g, "\"");
				content = JSON.parse(content);
				setScatterPlotData(content.scatterPlot);
				setTreemapData(content.treemap);
				setBarData(content.bar);
				setBarData2(content.bar2);
      }
    })
  }, [])

	return (
		<>
			<Grid container spacing={4}>
				<Grid item lg={6} md={8} sm={12} xs={24}>
					<Widget title="单元并发故障次数分布" noBodyPadding upperTitle>
            <Grid item xs={24}>
							<ResponsiveContainer width="100%" height={350}>
								<ScatterPlot
									data={scatterPlotData}
									height={300}
								/>
							</ResponsiveContainer>
						</Grid>
					</Widget>
				</Grid>
				<Grid item lg={6} md={8} sm={12} xs={24}>
					<Widget title="车型/单元/故障占比" noBodyPadding upperTitle>
            <Grid item xs={24}>
							<ResponsiveContainer width="100%" height={350}>
								<Treemap
                  data={treemapData}
									height={300}
								/>
							</ResponsiveContainer>
						</Grid>
					</Widget>
				</Grid>
				<Grid item lg={6} md={8} sm={12} xs={24}>
					<Widget title="车型故障单元" noBodyPadding upperTitle>
            <Grid item xs={24}>
							<ResponsiveContainer width="100%" height={350}>
								<Bar
									data={barData}
									height={300}
								/>
							</ResponsiveContainer>
						</Grid>
					</Widget>
				</Grid>
        <Grid item lg={6} md={8} sm={12} xs={24}>
					<Widget title="4S店售出车辆故障单元" noBodyPadding upperTitle>
            <Grid item xs={24}>
							<ResponsiveContainer width="100%" height={350}>
								<Bar2
									data={barData2}
									height={300}
								/>
							</ResponsiveContainer>
						</Grid>
					</Widget>
				</Grid>
      </Grid>
		</>
	);
}
// #####################################################################
var date = new Date();
var year = date.getFullYear();
const hasTimestamp = new Date() - new Date(year.toString());
const hasDays = Math.ceil(hasTimestamp / 86400000);
var dailyTimestamp = "" + year + hasDays;