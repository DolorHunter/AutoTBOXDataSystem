import React, { useState, useEffect } from 'react';
import { ReactBingmaps } from 'react-bingmaps';

// styles
import useStyles from "./styles";

import axios from 'axios';

export default function General(props) {
  var classes = useStyles();

	var [geoData, setGeoData] = useState([]);

	useEffect(() => {
		axios.post('/VisualChart/searchVisualChartByChartName',
    { "chartName": "maps-daily-" + dailyTimestamp })
    .then(res => {
			if (res.status === 200 && Object.keys(res.request.response).length > 0) {
				const data = JSON.parse(res.request.response);
				let content = data.chartData.replace(/'/g, "\"");
				content = JSON.parse(content);
				setGeoData(content);
      }
    })
  }, [])

	return (
		<div className={classes.mapContainer}>
      <ReactBingmaps 
        bingmapKey = "Asx36TsUff_hgZ9LdBbngk6EjwrxF95rLsV_j9ZhxeXQW90Oack_plqyIJfemQKO"
        center = {[31.8557, 117.1461]} 
        zoom = {5}
        pushPins = {geoData}
      > 
      </ReactBingmaps>
    </div>
	);
}
// #####################################################################
var date = new Date();
var year = date.getFullYear();
const hasTimestamp = new Date() - new Date(year.toString());
const hasDays = Math.ceil(hasTimestamp / 86400000);
var dailyTimestamp = "" + year + hasDays;