import React, { useState } from "react";
import { Grid } from "@material-ui/core";
import { useTheme } from "@material-ui/styles";
import {
  ResponsiveContainer,
} from "recharts";

// components
import Widget from "../../components/Widget/Widget";
import ApexHeatmap from "./components/ApexHeatmap";

export default function Charts(props) {

  return (
    <>
      <Grid container spacing={4}>
        <Grid item xs={12} md={6}>
          <Widget title="Apex Heatmap" upperTitle noBodyPadding>
            <ResponsiveContainer width="99%" height={375}>
             <ApexHeatmap />
            </ResponsiveContainer>
          </Widget>
        </Grid>
      </Grid>
    </>
  );
}
