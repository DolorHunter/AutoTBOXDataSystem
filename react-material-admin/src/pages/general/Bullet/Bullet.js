import React from "react";
// install (please make sure versions match peerDependencies)
// yarn add @nivo/core @nivo/bullet
import { ResponsiveBullet } from '@nivo/bullet'
// make sure parent container have a defined height when using
// responsive component, otherwise height will be 0 and
// no chart will be rendered.
// website examples showcase many properties,
// you'll often use just a few of them.
export default ({ data }) => (
	<ResponsiveBullet
		data={data}
		margin={{ top: 50, right: 90, bottom: 50, left: 90 }}
		spacing={46}
		titleAlign="start"
		titleOffsetX={-70}
		measureSize={0.2}
	/>
)