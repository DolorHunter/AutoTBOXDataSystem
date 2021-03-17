import React from "react";
// install (please make sure versions match peerDependencies)
// yarn add @nivo/core @nivo/bullet
import { ResponsiveBullet } from '@nivo/bullet'
// make sure parent container have a defined height when using
// responsive component, otherwise height will be 0 and
// no chart will be rendered.
// website examples showcase many properties,
// you'll often use just a few of them.
export default () => (
    <ResponsiveBullet
        data={data}
        margin={{ top: 50, right: 90, bottom: 50, left: 90 }}
        spacing={46}
        titleAlign="start"
        titleOffsetX={-70}
        measureSize={0.2}
    />
)

const data = [
  {
    "id": "temp.",
    "ranges": [
      48,
      43,
      76,
      0,
      120
    ],
    "measures": [
      63
    ],
    "markers": [
      84
    ]
  },
  {
    "id": "power",
    "ranges": [
      0.05670382436910954,
      1.477610262128719,
      0.442246287143339,
      0,
      2
    ],
    "measures": [
      0.12933295861212235,
      0.6362903536570532
    ],
    "markers": [
      1.254529599429537
    ]
  },
  {
    "id": "volume",
    "ranges": [
      57,
      22,
      58,
      0,
      15,
      16,
      0,
      80
    ],
    "measures": [
      16
    ],
    "markers": [
      63
    ]
  },
  {
    "id": "cost",
    "ranges": [
      303058,
      67518,
      7585,
      0,
      500000
    ],
    "measures": [
      109883,
      183365
    ],
    "markers": [
      458534
    ]
  },
  {
    "id": "revenue",
    "ranges": [
      0,
      7,
      2,
      0,
      11
    ],
    "measures": [
      4
    ],
    "markers": [
      6.864398931452749,
      7.432040261558099
    ]
  }
]