import React, { useState } from "react";
import { Grid } from "@material-ui/core";
import { useTheme } from "@material-ui/styles";
import {
  Pie,
  PieChart,
  ResponsiveContainer,
  Sector,
} from "recharts";

// components
import Widget from "../../components/Widget/Widget";
import ApexLineChart from "./components/ApexLineChart";
import ApexHeatmap from "./components/ApexHeatmap";

const pieChartData = [
  { name: "Group A", value: 400 },
  { name: "Group B", value: 300 },
  { name: "Group C", value: 300 },
  { name: "Group D", value: 200 },
];

export default function Charts(props) {
  var theme = useTheme();

  // local
  var [activeIndex, setActiveIndexId] = useState(0);

  return (
    <>
      <Grid container spacing={4}>
        <Grid item xs={12} md={6}>
          <Widget title="Apex Line Chart" upperTitle noBodyPadding>
            <ResponsiveContainer width="99%" height={375}>
              <ApexLineChart />
            </ResponsiveContainer>
          </Widget>
        </Grid>
        <Grid item xs={12} md={6}>
          <Widget title="Apex Heatmap" upperTitle noBodyPadding>
            <ResponsiveContainer width="99%" height={375}>
             <ApexHeatmap />
            </ResponsiveContainer>
          </Widget>
        </Grid>
        
        <Grid item xs={12} md={6}>
          <Widget title="Pie Chart with Tooltips" noBodyPadding upperTitle>
            <ResponsiveContainer width="99%" height={300}>
              <PieChart width={200} height={300}>
                <Pie
                  activeIndex={activeIndex}
                  activeShape={renderActiveShape}
                  data={pieChartData}
                  innerRadius={60}
                  outerRadius={80}
                  fill={theme.palette.primary.main}
                  dataKey="value"
                  onMouseEnter={(e, id) => setActiveIndexId(id)}
                />
              </PieChart>
            </ResponsiveContainer>
          </Widget>
        </Grid>
      </Grid>
    </>
  );
}

// ################################################################
function renderActiveShape(props) {
  var RADIAN = Math.PI / 180;
  var {
    cx,
    cy,
    midAngle,
    innerRadius,
    outerRadius,
    startAngle,
    endAngle,
    fill,
    payload,
    percent,
    value,
  } = props;
  var sin = Math.sin(-RADIAN * midAngle);
  var cos = Math.cos(-RADIAN * midAngle);
  var sx = cx + (outerRadius + 10) * cos;
  var sy = cy + (outerRadius + 10) * sin;
  var mx = cx + (outerRadius + 30) * cos;
  var my = cy + (outerRadius + 30) * sin;
  var ex = mx + (cos >= 0 ? 1 : -1) * 22;
  var ey = my;
  var textAnchor = cos >= 0 ? "start" : "end";

  return (
    <g>
      <text x={cx} y={cy} dy={8} textAnchor="middle" fill={fill}>
        {payload.name}
      </text>
      <Sector
        cx={cx}
        cy={cy}
        innerRadius={innerRadius}
        outerRadius={outerRadius}
        startAngle={startAngle}
        endAngle={endAngle}
        fill={fill}
      />
      <Sector
        cx={cx}
        cy={cy}
        startAngle={startAngle}
        endAngle={endAngle}
        innerRadius={outerRadius + 6}
        outerRadius={outerRadius + 10}
        fill={fill}
      />
      <path
        d={`M${sx},${sy}L${mx},${my}L${ex},${ey}`}
        stroke={fill}
        fill="none"
      />
      <circle cx={ex} cy={ey} r={2} fill={fill} stroke="none" />
      <text
        x={ex + (cos >= 0 ? 1 : -1) * 12}
        y={ey}
        textAnchor={textAnchor}
        fill="#333"
      >{`PV ${value}`}</text>
      <text
        x={ex + (cos >= 0 ? 1 : -1) * 12}
        y={ey}
        dy={18}
        textAnchor={textAnchor}
        fill="#999"
      >
        {`(Rate ${(percent * 100).toFixed(2)}%)`}
      </text>
    </g>
  );
}
