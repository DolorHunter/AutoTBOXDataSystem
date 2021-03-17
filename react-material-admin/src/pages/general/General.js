import React from "react";
import { Grid } from "@material-ui/core";
import { useTheme } from "@material-ui/styles";

import { 
	PieChart,
  Pie,
  Cell,
	ResponsiveContainer 
} from "recharts";

// styles
import useStyles from "../dashboard/styles";

import Widget from "../../components/Widget/Widget";
import { Typography } from "../../components/Wrappers";
import Dot from "../../components/Sidebar/components/Dot";

import Calender from "./Calender/Calender";
import Treemap from "./Treemap/Treemap";
import ScatterPlot from "./ScatterPlot/ScatterPlot";
import Bullet from "./Bullet/Bullet";
import Bar from "./Bar/Bar";
import Marimekko from "./Marimekko/Marimekko";

const PieChartData = [
  { name: "Group A", value: 400, color: "primary" },
  { name: "Group B", value: 300, color: "secondary" },
  { name: "Group C", value: 300, color: "warning" },
  { name: "Group D", value: 200, color: "success" },
];

export default function General(props) {
  var classes = useStyles();
  var theme = useTheme();

	return (
		<>
			<Grid container spacing={4}>
				<Grid item lg={9} md={12} sm={18} xs={36}>
					<Widget title="Calender" noBodyPadding upperTitle>
            <Grid item xs={36}>
							<ResponsiveContainer width="99%" height={175}>
								<Calender
									height={175}
								/>
							</ResponsiveContainer>
						</Grid>
					</Widget>
				</Grid>
				<Grid item lg={3} md={4} sm={6} xs={12}>
          <Widget title="Calender Pie" upperTitle className={classes.card}>
            <Grid container spacing={2}>
              <Grid item xs={6}>
                <ResponsiveContainer width="100%" height={175}>
                  <PieChart>
                    <Pie
                      data={PieChartData}
                      innerRadius={30}
                      outerRadius={40}
                      dataKey="value"
                    >
                      {PieChartData.map((entry, index) => (
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
                  {PieChartData.map(({ name, value, color }, index) => (
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
				<Grid item lg={6} md={8} sm={12} xs={24}>
					<Widget title="ScatterPlot" noBodyPadding upperTitle>
            <Grid item xs={24}>
							<ResponsiveContainer width="100%" height={350}>
								<ScatterPlot
									height={300}
								/>
							</ResponsiveContainer>
						</Grid>
					</Widget>
				</Grid>
				<Grid item lg={6} md={8} sm={12} xs={24}>
					<Widget title="Treemap" noBodyPadding upperTitle>
            <Grid item xs={24}>
							<ResponsiveContainer width="100%" height={350}>
								<Treemap
									height={300}
								/>
							</ResponsiveContainer>
						</Grid>
					</Widget>
				</Grid>
				<Grid item lg={6} md={8} sm={12} xs={24}>
					<Widget title="Bullet" noBodyPadding upperTitle>
            <Grid item xs={24}>
							<ResponsiveContainer width="100%" height={350}>
								<Bullet
									height={300}
								/>
							</ResponsiveContainer>
						</Grid>
					</Widget>
				</Grid>
				<Grid item lg={6} md={8} sm={12} xs={24}>
					<Widget title="Bar" noBodyPadding upperTitle>
            <Grid item xs={24}>
							<ResponsiveContainer width="100%" height={350}>
								<Bar
									height={300}
								/>
							</ResponsiveContainer>
						</Grid>
					</Widget>
				</Grid>
				<Grid item lg={6} md={8} sm={12} xs={24}>
					<Widget title="Marimekko" noBodyPadding upperTitle>
            <Grid item xs={24}>
							<ResponsiveContainer width="100%" height={350}>
								<Marimekko
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