import React from "react";
import { useTheme } from "@material-ui/styles";
import ApexCharts from "react-apexcharts";

const series = [
  {
    name: "Metric1",
    data: [{ x: "w1", y: 31 }, { x: "w2", y: 10 }, { x: "w3", y: 72 }, { x: "w4", y: 48 }, 
    { x: "w5", y: 35 }, { x: "w6", y: 34 }, { x: "w7", y: 49 }, { x: "w8", y: 12 }, 
    { x: "w9", y: 38 }, { x: "w10", y: 11 }, { x: "w11", y: 7 }, { x: "w12", y: 15 }, 
    { x: "w13", y: 70 }, { x: "w14", y: 79 }, { x: "w15", y: 44 }, { x: "w16", y: 81 }, 
    { x: "w17", y: 71 }, { x: "w18", y: 17 }],
  },
  {
    name: "Metric2",
    data: [{ x: "w1", y: 31 }, { x: "w2", y: 10 }, { x: "w3", y: 72 }, { x: "w4", y: 48 }, 
    { x: "w5", y: 35 }, { x: "w6", y: 34 }, { x: "w7", y: 49 }, { x: "w8", y: 12 }, 
    { x: "w9", y: 38 }, { x: "w10", y: 11 }, { x: "w11", y: 7 }, { x: "w12", y: 15 }, 
    { x: "w13", y: 70 }, { x: "w14", y: 79 }, { x: "w15", y: 44 }, { x: "w16", y: 81 }, 
    { x: "w17", y: 71 }, { x: "w18", y: 17 }],
  },
  {
    name: "Metric3",
    data: [{ x: "w1", y: 31 }, { x: "w2", y: 10 }, { x: "w3", y: 72 }, { x: "w4", y: 48 }, 
    { x: "w5", y: 35 }, { x: "w6", y: 34 }, { x: "w7", y: 49 }, { x: "w8", y: 12 }, 
    { x: "w9", y: 38 }, { x: "w10", y: 11 }, { x: "w11", y: 7 }, { x: "w12", y: 15 }, 
    { x: "w13", y: 70 }, { x: "w14", y: 79 }, { x: "w15", y: 44 }, { x: "w16", y: 81 }, 
    { x: "w17", y: 71 }, { x: "w18", y: 17 }],
  },
  {
    name: "Metric4",
    data: [{ x: "w1", y: 31 }, { x: "w2", y: 10 }, { x: "w3", y: 72 }, { x: "w4", y: 48 }, 
    { x: "w5", y: 35 }, { x: "w6", y: 34 }, { x: "w7", y: 49 }, { x: "w8", y: 12 }, 
    { x: "w9", y: 38 }, { x: "w10", y: 11 }, { x: "w11", y: 7 }, { x: "w12", y: 15 }, 
    { x: "w13", y: 70 }, { x: "w14", y: 79 }, { x: "w15", y: 44 }, { x: "w16", y: 81 }, 
    { x: "w17", y: 71 }, { x: "w18", y: 17 }],
  },
  {
    name: "Metric5",
    data: [{ x: "w1", y: 31 }, { x: "w2", y: 10 }, { x: "w3", y: 72 }, { x: "w4", y: 48 }, 
    { x: "w5", y: 35 }, { x: "w6", y: 34 }, { x: "w7", y: 49 }, { x: "w8", y: 12 }, 
    { x: "w9", y: 38 }, { x: "w10", y: 11 }, { x: "w11", y: 7 }, { x: "w12", y: 15 }, 
    { x: "w13", y: 70 }, { x: "w14", y: 79 }, { x: "w15", y: 44 }, { x: "w16", y: 81 }, 
    { x: "w17", y: 71 }, { x: "w18", y: 17 }],
  },
  {
    name: "Metric6",
    data: [{ x: "w1", y: 31 }, { x: "w2", y: 10 }, { x: "w3", y: 72 }, { x: "w4", y: 48 }, 
    { x: "w5", y: 35 }, { x: "w6", y: 34 }, { x: "w7", y: 49 }, { x: "w8", y: 12 }, 
    { x: "w9", y: 38 }, { x: "w10", y: 11 }, { x: "w11", y: 7 }, { x: "w12", y: 15 }, 
    { x: "w13", y: 70 }, { x: "w14", y: 79 }, { x: "w15", y: 44 }, { x: "w16", y: 81 }, 
    { x: "w17", y: 71 }, { x: "w18", y: 17 }],
  },
  {
    name: "Metric7",
    data: [{ x: "w1", y: 31 }, { x: "w2", y: 10 }, { x: "w3", y: 72 }, { x: "w4", y: 48 }, 
    { x: "w5", y: 35 }, { x: "w6", y: 34 }, { x: "w7", y: 49 }, { x: "w8", y: 12 }, 
    { x: "w9", y: 38 }, { x: "w10", y: 11 }, { x: "w11", y: 7 }, { x: "w12", y: 15 }, 
    { x: "w13", y: 70 }, { x: "w14", y: 79 }, { x: "w15", y: 44 }, { x: "w16", y: 81 }, 
    { x: "w17", y: 71 }, { x: "w18", y: 17 }],
  },
  {
    name: "Metric8",
    data:[{ x: "w1", y: 31 }, { x: "w2", y: 10 }, { x: "w3", y: 72 }, { x: "w4", y: 48 }, 
    { x: "w5", y: 35 }, { x: "w6", y: 34 }, { x: "w7", y: 49 }, { x: "w8", y: 12 }, 
    { x: "w9", y: 38 }, { x: "w10", y: 11 }, { x: "w11", y: 7 }, { x: "w12", y: 15 }, 
    { x: "w13", y: 70 }, { x: "w14", y: 79 }, { x: "w15", y: 44 }, { x: "w16", y: 81 }, 
    { x: "w17", y: 71 }, { x: "w18", y: 17 }],
  },
  {
    name: "Metric9",
    data: [{ x: "w1", y: 31 }, { x: "w2", y: 10 }, { x: "w3", y: 72 }, { x: "w4", y: 48 }, 
    { x: "w5", y: 35 }, { x: "w6", y: 34 }, { x: "w7", y: 49 }, { x: "w8", y: 12 }, 
    { x: "w9", y: 38 }, { x: "w10", y: 11 }, { x: "w11", y: 7 }, { x: "w12", y: 15 }, 
    { x: "w13", y: 70 }, { x: "w14", y: 79 }, { x: "w15", y: 44 }, { x: "w16", y: 81 }, 
    { x: "w17", y: 71 }, { x: "w18", y: 17 }],
  },
];

export default function ApexLineChart() {
  var theme = useTheme();

  return (
    <ApexCharts
      options={themeOptions(theme)}
      series={series}
      type="heatmap"
      height={350}
    />
  );
}

// ##################################################################
function themeOptions(theme) {
  return {
    chart: {
      toolbar: {
        show: false,
      },
    },
    dataLabels: {
      enabled: false,
    },
    colors: [theme.palette.primary.main],
  };
}
