import React from "react";
// install (please make sure versions match peerDependencies)
// yarn add @nivo/core @nivo/marimekko
import { ResponsiveMarimekko } from '@nivo/marimekko'
// make sure parent container have a defined height when using
// responsive component, otherwise height will be 0 and
// no chart will be rendered.
// website examples showcase many properties,
// you'll often use just a few of them.
export default () => (
    <ResponsiveMarimekko
        data={data}
        id="statement"
        value="participation"
        dimensions={[
            {
                id: 'disagree strongly',
                value: 'stronglyDisagree'
            },
            {
                id: 'disagree',
                value: 'disagree'
            },
            {
                id: 'agree',
                value: 'agree'
            },
            {
                id: 'agree strongly',
                value: 'stronglyAgree'
            }
        ]}
        innerPadding={9}
        axisTop={null}
        axisRight={{ orient: 'right', tickSize: 5, tickPadding: 5, tickRotation: 0, legend: '', legendOffset: 0 }}
        axisBottom={{
            orient: 'bottom',
            tickSize: 5,
            tickPadding: 5,
            tickRotation: 0,
            legend: 'participation',
            legendOffset: 36,
            legendPosition: 'middle'
        }}
        axisLeft={{
            orient: 'left',
            tickSize: 5,
            tickPadding: 5,
            tickRotation: 0,
            legend: 'opinions',
            legendOffset: -40,
            legendPosition: 'middle'
        }}
        margin={{ top: 40, right: 80, bottom: 100, left: 80 }}
        colors={{ scheme: 'spectral' }}
        borderWidth={1}
        borderColor={{ from: 'color', modifiers: [ [ 'darker', 0.2 ] ] }}
        defs={[
            {
                id: 'lines',
                type: 'patternLines',
                background: 'rgba(0, 0, 0, 0)',
                color: 'inherit',
                rotation: -45,
                lineWidth: 4,
                spacing: 8
            }
        ]}
        fill={[
            {
                match: {
                    id: 'agree strongly'
                },
                id: 'lines'
            },
            {
                match: {
                    id: 'disagree strongly'
                },
                id: 'lines'
            }
        ]}
        legends={[
            {
                anchor: 'bottom',
                direction: 'row',
                justify: false,
                translateX: 0,
                translateY: 80,
                itemsSpacing: 0,
                itemWidth: 140,
                itemHeight: 18,
                itemTextColor: '#999',
                itemDirection: 'right-to-left',
                itemOpacity: 1,
                symbolSize: 18,
                symbolShape: 'square',
                effects: [
                    {
                        on: 'hover',
                        style: {
                            itemTextColor: '#000'
                        }
                    }
                ]
            }
        ]}
    />
)

const data = [
  {
    "statement": "it's good",
    "participation": 14,
    "stronglyAgree": 21,
    "agree": 11,
    "disagree": 23,
    "stronglyDisagree": 3
  },
  {
    "statement": "it's sweet",
    "participation": 16,
    "stronglyAgree": 3,
    "agree": 13,
    "disagree": 15,
    "stronglyDisagree": 30
  },
  {
    "statement": "it's spicy",
    "participation": 16,
    "stronglyAgree": 18,
    "agree": 25,
    "disagree": 10,
    "stronglyDisagree": 21
  },
  {
    "statement": "worth eating",
    "participation": 27,
    "stronglyAgree": 19,
    "agree": 6,
    "disagree": 30,
    "stronglyDisagree": 19
  },
  {
    "statement": "worth buying",
    "participation": 22,
    "stronglyAgree": 1,
    "agree": 27,
    "disagree": 11,
    "stronglyDisagree": 14
  }
]