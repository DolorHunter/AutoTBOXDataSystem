import React from "react";
// install (please make sure versions match peerDependencies)
// yarn add @nivo/core @nivo/bar
import { ResponsiveBar } from '@nivo/bar'
// make sure parent container have a defined height when using
// responsive component, otherwise height will be 0 and
// no chart will be rendered.
// website examples showcase many properties,
// you'll often use just a few of them.
export default () => (
    <ResponsiveBar
        data={data}
        keys={[ 'hot dog', 'burger', 'sandwich', 'kebab', 'fries', 'donut' ]}
        indexBy="country"
        margin={{ top: 50, right: 130, bottom: 50, left: 60 }}
        padding={0.3}
        valueScale={{ type: 'linear' }}
        indexScale={{ type: 'band', round: true }}
        colors={{ scheme: 'nivo' }}
        defs={[
            {
                id: 'dots',
                type: 'patternDots',
                background: 'inherit',
                color: '#38bcb2',
                size: 4,
                padding: 1,
                stagger: true
            },
            {
                id: 'lines',
                type: 'patternLines',
                background: 'inherit',
                color: '#eed312',
                rotation: -45,
                lineWidth: 6,
                spacing: 10
            }
        ]}
        fill={[
            {
                match: {
                    id: 'fries'
                },
                id: 'dots'
            },
            {
                match: {
                    id: 'sandwich'
                },
                id: 'lines'
            }
        ]}
        borderColor={{ from: 'color', modifiers: [ [ 'darker', 1.6 ] ] }}
        axisTop={null}
        axisRight={null}
        axisBottom={{
            tickSize: 5,
            tickPadding: 5,
            tickRotation: 0,
            legend: 'country',
            legendPosition: 'middle',
            legendOffset: 32
        }}
        axisLeft={{
            tickSize: 5,
            tickPadding: 5,
            tickRotation: 0,
            legend: 'food',
            legendPosition: 'middle',
            legendOffset: -40
        }}
        labelSkipWidth={12}
        labelSkipHeight={12}
        labelTextColor={{ from: 'color', modifiers: [ [ 'darker', 1.6 ] ] }}
        legends={[
            {
                dataFrom: 'keys',
                anchor: 'bottom-right',
                direction: 'column',
                justify: false,
                translateX: 120,
                translateY: 0,
                itemsSpacing: 2,
                itemWidth: 100,
                itemHeight: 20,
                itemDirection: 'left-to-right',
                itemOpacity: 0.85,
                symbolSize: 20,
                effects: [
                    {
                        on: 'hover',
                        style: {
                            itemOpacity: 1
                        }
                    }
                ]
            }
        ]}
        animate={true}
        motionStiffness={90}
        motionDamping={15}
    />
)

const data = [
  {
    "country": "AD",
    "hot dog": 82,
    "hot dogColor": "hsl(297, 70%, 50%)",
    "burger": 100,
    "burgerColor": "hsl(305, 70%, 50%)",
    "sandwich": 80,
    "sandwichColor": "hsl(303, 70%, 50%)",
    "kebab": 52,
    "kebabColor": "hsl(307, 70%, 50%)",
    "fries": 159,
    "friesColor": "hsl(166, 70%, 50%)",
    "donut": 113,
    "donutColor": "hsl(107, 70%, 50%)"
  },
  {
    "country": "AE",
    "hot dog": 109,
    "hot dogColor": "hsl(203, 70%, 50%)",
    "burger": 96,
    "burgerColor": "hsl(189, 70%, 50%)",
    "sandwich": 27,
    "sandwichColor": "hsl(93, 70%, 50%)",
    "kebab": 60,
    "kebabColor": "hsl(139, 70%, 50%)",
    "fries": 49,
    "friesColor": "hsl(1, 70%, 50%)",
    "donut": 160,
    "donutColor": "hsl(1, 70%, 50%)"
  },
  {
    "country": "AF",
    "hot dog": 13,
    "hot dogColor": "hsl(103, 70%, 50%)",
    "burger": 43,
    "burgerColor": "hsl(235, 70%, 50%)",
    "sandwich": 124,
    "sandwichColor": "hsl(193, 70%, 50%)",
    "kebab": 110,
    "kebabColor": "hsl(92, 70%, 50%)",
    "fries": 15,
    "friesColor": "hsl(264, 70%, 50%)",
    "donut": 75,
    "donutColor": "hsl(274, 70%, 50%)"
  },
  {
    "country": "AG",
    "hot dog": 99,
    "hot dogColor": "hsl(119, 70%, 50%)",
    "burger": 124,
    "burgerColor": "hsl(62, 70%, 50%)",
    "sandwich": 17,
    "sandwichColor": "hsl(234, 70%, 50%)",
    "kebab": 95,
    "kebabColor": "hsl(232, 70%, 50%)",
    "fries": 63,
    "friesColor": "hsl(243, 70%, 50%)",
    "donut": 176,
    "donutColor": "hsl(2, 70%, 50%)"
  },
  {
    "country": "AI",
    "hot dog": 86,
    "hot dogColor": "hsl(156, 70%, 50%)",
    "burger": 10,
    "burgerColor": "hsl(134, 70%, 50%)",
    "sandwich": 31,
    "sandwichColor": "hsl(107, 70%, 50%)",
    "kebab": 197,
    "kebabColor": "hsl(123, 70%, 50%)",
    "fries": 94,
    "friesColor": "hsl(3, 70%, 50%)",
    "donut": 36,
    "donutColor": "hsl(69, 70%, 50%)"
  },
  {
    "country": "AL",
    "hot dog": 75,
    "hot dogColor": "hsl(275, 70%, 50%)",
    "burger": 50,
    "burgerColor": "hsl(118, 70%, 50%)",
    "sandwich": 20,
    "sandwichColor": "hsl(339, 70%, 50%)",
    "kebab": 153,
    "kebabColor": "hsl(167, 70%, 50%)",
    "fries": 121,
    "friesColor": "hsl(313, 70%, 50%)",
    "donut": 138,
    "donutColor": "hsl(140, 70%, 50%)"
  },
  {
    "country": "AM",
    "hot dog": 162,
    "hot dogColor": "hsl(83, 70%, 50%)",
    "burger": 20,
    "burgerColor": "hsl(179, 70%, 50%)",
    "sandwich": 84,
    "sandwichColor": "hsl(184, 70%, 50%)",
    "kebab": 145,
    "kebabColor": "hsl(309, 70%, 50%)",
    "fries": 156,
    "friesColor": "hsl(204, 70%, 50%)",
    "donut": 110,
    "donutColor": "hsl(57, 70%, 50%)"
  }
]