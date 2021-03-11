import React from "react";
import ApexCharts from "react-apexcharts";
import { useTheme } from "@material-ui/styles";

const series = [
  {
    name: "series1",
    data: [31, 40, 28, 51, 42, 109, 100],
  },
  {
    name: "series2",
    data: [11, 32, 45, 32, 34, 52, 41],
  },
];

const catogory = [
  "2018-09-19T00:00:00",
  "2018-09-19T01:30:00",
  "2018-09-19T02:30:00",
  "2018-09-19T03:30:00",
  "2018-09-19T04:30:00",
  "2018-09-19T05:30:00",
  "2018-09-19T06:30:00",
]

export default function ApexLineChart() {
  var theme = useTheme();

  return (
    <ApexCharts
      options={themeOptions(catogory, theme)}
      series={series}
      type="area"
      height={350}
    />
  );
}

// ############################################################
function themeOptions(catogory, theme) {
  return {
    dataLabels: {
      enabled: false,
    },
    stroke: {
      curve: "smooth",
    },
    xaxis: {
      type: "datetime",
      categories: catogory,
    },
    tooltip: {
      x: {
        format: "yy/MM/dd HH:mm",
      },
    },
    fill: {
      colors: [theme.palette.primary.light, theme.palette.success.light],
    },
    colors: [theme.palette.primary.main, theme.palette.success.main],
    chart: {
      toolbar: {
        show: false,
      },
    },
    legend: {
      show: false,
    },
  };
}
