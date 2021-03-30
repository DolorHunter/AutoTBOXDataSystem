import React from "react";
// install (please make sure versions match peerDependencies)
// yarn add @nivo/core @nivo/calendar
import { ResponsiveCalendarCanvas } from '@nivo/calendar'
// make sure parent container have a defined height when using
// responsive component, otherwise height will be 0 and
// no chart will be rendered.
// website examples showcase many properties,
// you'll often use just a few of them.
const date = new Date();
const start_date = date.getFullYear().toString() + "-01-01";
const end_date = date.getFullYear().toString() + "-12-31";

export default ({ data }) => (
	<ResponsiveCalendarCanvas
		data={data}
		from={start_date}
		to={end_date}
		emptyColor="#eeeeee"
		colors={['#61cdbb', '#97e3d5', '#e8c1a0', '#f47560']}
		margin={{ top: 40, right: 40, bottom: 40, left: 40 }}
		yearSpacing={40}
		monthBorderColor="#ffffff"
		dayBorderWidth={2}
		dayBorderColor="#ffffff"
		legends={[
			{
				anchor: 'bottom-right',
				direction: 'row',
				translateY: 36,
				itemCount: 4,
				itemWidth: 42,
				itemHeight: 36,
				itemsSpacing: 14,
				itemDirection: 'right-to-left'
			}
		]}
	/>
)