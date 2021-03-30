import React from "react";
// install (please make sure versions match peerDependencies)
// yarn add @nivo/core @nivo/treemap
import { ResponsiveTreeMap } from '@nivo/treemap'
// make sure parent container have a defined height when using
// responsive component, otherwise height will be 0 and
// no chart will be rendered.
// website examples showcase many properties,
// you'll often use just a few of them.
export default ({ data }) => (
  <ResponsiveTreeMap
    data={data}
    identity="name"
    value="value"
    valueFormat=".02s"
    margin={{ top: 10, right: 10, bottom: 10, left: 10 }}
    labelSkipSize={12}
    labelTextColor={{ from: 'color', modifiers: [['darker', 1.2]] }}
    parentLabelTextColor={{ from: 'color', modifiers: [['darker', 2]] }}
    borderColor={{ from: 'color', modifiers: [['darker', 0.1]] }}
  />
)