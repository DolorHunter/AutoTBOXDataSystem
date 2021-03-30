import React, { useState, useEffect } from 'react';
import { Grid } from "@material-ui/core";
import { useTheme } from "@material-ui/styles";

import { 
	PieChart,
  Pie,
  Cell,
	ResponsiveContainer 
} from "recharts";

// styles
import useStyles from "../dashboard/styles";

import Widget from "../../components/Widget/Widget";
import Treemap from "./Treemap/Treemap";
import ScatterPlot from "./ScatterPlot/ScatterPlot";
import Bullet from "./Bullet/Bullet";
import Bar from "./Bar/Bar";
import Marimekko from "./Marimekko/Marimekko";

import axios from 'axios';

const ScatterPlotData = [
  {
    "id": "group A",
    "data": [
      {
        "x": 28,
        "y": 115
      },
      {
        "x": 74,
        "y": 36
      },
      {
        "x": 92,
        "y": 72
      },
      {
        "x": 6,
        "y": 2
      },
      {
        "x": 57,
        "y": 91
      },
      {
        "x": 62,
        "y": 9
      },
      {
        "x": 73,
        "y": 48
      },
      {
        "x": 41,
        "y": 91
      },
      {
        "x": 26,
        "y": 66
      },
      {
        "x": 1,
        "y": 5
      },
      {
        "x": 33,
        "y": 44
      },
      {
        "x": 60,
        "y": 7
      },
      {
        "x": 75,
        "y": 52
      },
      {
        "x": 64,
        "y": 26
      },
      {
        "x": 35,
        "y": 80
      },
      {
        "x": 21,
        "y": 22
      },
      {
        "x": 19,
        "y": 99
      },
      {
        "x": 54,
        "y": 93
      },
      {
        "x": 5,
        "y": 33
      },
      {
        "x": 6,
        "y": 8
      },
      {
        "x": 4,
        "y": 10
      },
      {
        "x": 23,
        "y": 73
      },
      {
        "x": 96,
        "y": 28
      },
      {
        "x": 22,
        "y": 78
      },
      {
        "x": 98,
        "y": 25
      },
      {
        "x": 26,
        "y": 58
      },
      {
        "x": 59,
        "y": 91
      },
      {
        "x": 12,
        "y": 47
      },
      {
        "x": 9,
        "y": 54
      },
      {
        "x": 54,
        "y": 0
      },
      {
        "x": 61,
        "y": 35
      },
      {
        "x": 92,
        "y": 21
      },
      {
        "x": 50,
        "y": 91
      },
      {
        "x": 16,
        "y": 89
      },
      {
        "x": 26,
        "y": 94
      },
      {
        "x": 98,
        "y": 3
      },
      {
        "x": 36,
        "y": 79
      },
      {
        "x": 39,
        "y": 9
      },
      {
        "x": 35,
        "y": 68
      },
      {
        "x": 7,
        "y": 54
      },
      {
        "x": 64,
        "y": 20
      },
      {
        "x": 60,
        "y": 4
      },
      {
        "x": 61,
        "y": 33
      },
      {
        "x": 85,
        "y": 64
      },
      {
        "x": 43,
        "y": 91
      },
      {
        "x": 45,
        "y": 14
      },
      {
        "x": 77,
        "y": 118
      },
      {
        "x": 21,
        "y": 111
      },
      {
        "x": 23,
        "y": 11
      },
      {
        "x": 35,
        "y": 53
      }
    ]
  },
  {
    "id": "group B",
    "data": [
      {
        "x": 99,
        "y": 6
      },
      {
        "x": 47,
        "y": 41
      },
      {
        "x": 42,
        "y": 73
      },
      {
        "x": 36,
        "y": 41
      },
      {
        "x": 42,
        "y": 86
      },
      {
        "x": 48,
        "y": 94
      },
      {
        "x": 3,
        "y": 119
      },
      {
        "x": 10,
        "y": 14
      },
      {
        "x": 23,
        "y": 68
      },
      {
        "x": 3,
        "y": 5
      },
      {
        "x": 12,
        "y": 17
      },
      {
        "x": 49,
        "y": 37
      },
      {
        "x": 74,
        "y": 45
      },
      {
        "x": 59,
        "y": 119
      },
      {
        "x": 65,
        "y": 15
      },
      {
        "x": 94,
        "y": 15
      },
      {
        "x": 23,
        "y": 111
      },
      {
        "x": 83,
        "y": 79
      },
      {
        "x": 69,
        "y": 75
      },
      {
        "x": 92,
        "y": 13
      },
      {
        "x": 97,
        "y": 119
      },
      {
        "x": 22,
        "y": 71
      },
      {
        "x": 5,
        "y": 115
      },
      {
        "x": 95,
        "y": 13
      },
      {
        "x": 17,
        "y": 82
      },
      {
        "x": 45,
        "y": 101
      },
      {
        "x": 78,
        "y": 91
      },
      {
        "x": 78,
        "y": 45
      },
      {
        "x": 15,
        "y": 88
      },
      {
        "x": 72,
        "y": 15
      },
      {
        "x": 88,
        "y": 69
      },
      {
        "x": 95,
        "y": 62
      },
      {
        "x": 66,
        "y": 69
      },
      {
        "x": 38,
        "y": 74
      },
      {
        "x": 16,
        "y": 3
      },
      {
        "x": 37,
        "y": 118
      },
      {
        "x": 60,
        "y": 64
      },
      {
        "x": 81,
        "y": 77
      },
      {
        "x": 38,
        "y": 97
      },
      {
        "x": 73,
        "y": 82
      },
      {
        "x": 73,
        "y": 77
      },
      {
        "x": 79,
        "y": 69
      },
      {
        "x": 68,
        "y": 0
      },
      {
        "x": 82,
        "y": 30
      },
      {
        "x": 79,
        "y": 117
      },
      {
        "x": 67,
        "y": 37
      },
      {
        "x": 78,
        "y": 8
      },
      {
        "x": 58,
        "y": 83
      },
      {
        "x": 8,
        "y": 68
      },
      {
        "x": 13,
        "y": 4
      }
    ]
  },
  {
    "id": "group C",
    "data": [
      {
        "x": 23,
        "y": 37
      },
      {
        "x": 18,
        "y": 1
      },
      {
        "x": 81,
        "y": 26
      },
      {
        "x": 86,
        "y": 16
      },
      {
        "x": 13,
        "y": 4
      },
      {
        "x": 27,
        "y": 60
      },
      {
        "x": 77,
        "y": 31
      },
      {
        "x": 41,
        "y": 55
      },
      {
        "x": 48,
        "y": 98
      },
      {
        "x": 28,
        "y": 56
      },
      {
        "x": 7,
        "y": 106
      },
      {
        "x": 27,
        "y": 33
      },
      {
        "x": 51,
        "y": 33
      },
      {
        "x": 3,
        "y": 119
      },
      {
        "x": 92,
        "y": 81
      },
      {
        "x": 34,
        "y": 12
      },
      {
        "x": 25,
        "y": 38
      },
      {
        "x": 74,
        "y": 22
      },
      {
        "x": 11,
        "y": 9
      },
      {
        "x": 80,
        "y": 107
      },
      {
        "x": 93,
        "y": 50
      },
      {
        "x": 73,
        "y": 119
      },
      {
        "x": 72,
        "y": 33
      },
      {
        "x": 19,
        "y": 78
      },
      {
        "x": 52,
        "y": 7
      },
      {
        "x": 100,
        "y": 58
      },
      {
        "x": 5,
        "y": 21
      },
      {
        "x": 36,
        "y": 23
      },
      {
        "x": 45,
        "y": 40
      },
      {
        "x": 53,
        "y": 45
      },
      {
        "x": 98,
        "y": 113
      },
      {
        "x": 34,
        "y": 85
      },
      {
        "x": 62,
        "y": 75
      },
      {
        "x": 10,
        "y": 99
      },
      {
        "x": 44,
        "y": 15
      },
      {
        "x": 3,
        "y": 60
      },
      {
        "x": 42,
        "y": 65
      },
      {
        "x": 12,
        "y": 90
      },
      {
        "x": 2,
        "y": 40
      },
      {
        "x": 10,
        "y": 49
      },
      {
        "x": 7,
        "y": 54
      },
      {
        "x": 43,
        "y": 77
      },
      {
        "x": 45,
        "y": 54
      },
      {
        "x": 0,
        "y": 66
      },
      {
        "x": 47,
        "y": 85
      },
      {
        "x": 11,
        "y": 7
      },
      {
        "x": 70,
        "y": 71
      },
      {
        "x": 36,
        "y": 117
      },
      {
        "x": 51,
        "y": 26
      },
      {
        "x": 77,
        "y": 59
      }
    ]
  },
  {
    "id": "group D",
    "data": [
      {
        "x": 82,
        "y": 29
      },
      {
        "x": 33,
        "y": 29
      },
      {
        "x": 4,
        "y": 46
      },
      {
        "x": 85,
        "y": 88
      },
      {
        "x": 91,
        "y": 90
      },
      {
        "x": 1,
        "y": 48
      },
      {
        "x": 81,
        "y": 91
      },
      {
        "x": 99,
        "y": 108
      },
      {
        "x": 69,
        "y": 52
      },
      {
        "x": 10,
        "y": 22
      },
      {
        "x": 33,
        "y": 63
      },
      {
        "x": 93,
        "y": 59
      },
      {
        "x": 76,
        "y": 16
      },
      {
        "x": 52,
        "y": 77
      },
      {
        "x": 1,
        "y": 23
      },
      {
        "x": 9,
        "y": 104
      },
      {
        "x": 77,
        "y": 54
      },
      {
        "x": 63,
        "y": 64
      },
      {
        "x": 60,
        "y": 19
      },
      {
        "x": 26,
        "y": 25
      },
      {
        "x": 42,
        "y": 33
      },
      {
        "x": 44,
        "y": 35
      },
      {
        "x": 97,
        "y": 61
      },
      {
        "x": 60,
        "y": 100
      },
      {
        "x": 98,
        "y": 12
      },
      {
        "x": 50,
        "y": 91
      },
      {
        "x": 82,
        "y": 60
      },
      {
        "x": 55,
        "y": 18
      },
      {
        "x": 36,
        "y": 59
      },
      {
        "x": 96,
        "y": 112
      },
      {
        "x": 77,
        "y": 114
      },
      {
        "x": 97,
        "y": 47
      },
      {
        "x": 11,
        "y": 104
      },
      {
        "x": 63,
        "y": 38
      },
      {
        "x": 86,
        "y": 97
      },
      {
        "x": 12,
        "y": 12
      },
      {
        "x": 47,
        "y": 33
      },
      {
        "x": 8,
        "y": 88
      },
      {
        "x": 90,
        "y": 77
      },
      {
        "x": 49,
        "y": 99
      },
      {
        "x": 87,
        "y": 90
      },
      {
        "x": 92,
        "y": 35
      },
      {
        "x": 54,
        "y": 83
      },
      {
        "x": 5,
        "y": 23
      },
      {
        "x": 100,
        "y": 88
      },
      {
        "x": 97,
        "y": 48
      },
      {
        "x": 22,
        "y": 67
      },
      {
        "x": 25,
        "y": 90
      },
      {
        "x": 36,
        "y": 23
      },
      {
        "x": 25,
        "y": 2
      }
    ]
  },
  {
    "id": "group E",
    "data": [
      {
        "x": 13,
        "y": 35
      },
      {
        "x": 48,
        "y": 96
      },
      {
        "x": 53,
        "y": 6
      },
      {
        "x": 35,
        "y": 84
      },
      {
        "x": 94,
        "y": 97
      },
      {
        "x": 75,
        "y": 24
      },
      {
        "x": 12,
        "y": 83
      },
      {
        "x": 61,
        "y": 41
      },
      {
        "x": 91,
        "y": 54
      },
      {
        "x": 16,
        "y": 34
      },
      {
        "x": 82,
        "y": 6
      },
      {
        "x": 67,
        "y": 108
      },
      {
        "x": 37,
        "y": 63
      },
      {
        "x": 16,
        "y": 22
      },
      {
        "x": 10,
        "y": 112
      },
      {
        "x": 57,
        "y": 100
      },
      {
        "x": 48,
        "y": 44
      },
      {
        "x": 60,
        "y": 52
      },
      {
        "x": 28,
        "y": 30
      },
      {
        "x": 88,
        "y": 30
      },
      {
        "x": 85,
        "y": 110
      },
      {
        "x": 88,
        "y": 28
      },
      {
        "x": 52,
        "y": 52
      },
      {
        "x": 83,
        "y": 88
      },
      {
        "x": 57,
        "y": 84
      },
      {
        "x": 64,
        "y": 43
      },
      {
        "x": 58,
        "y": 14
      },
      {
        "x": 6,
        "y": 91
      },
      {
        "x": 68,
        "y": 5
      },
      {
        "x": 10,
        "y": 117
      },
      {
        "x": 69,
        "y": 86
      },
      {
        "x": 72,
        "y": 89
      },
      {
        "x": 56,
        "y": 52
      },
      {
        "x": 50,
        "y": 24
      },
      {
        "x": 100,
        "y": 89
      },
      {
        "x": 14,
        "y": 14
      },
      {
        "x": 88,
        "y": 34
      },
      {
        "x": 15,
        "y": 78
      },
      {
        "x": 88,
        "y": 113
      },
      {
        "x": 86,
        "y": 13
      },
      {
        "x": 90,
        "y": 96
      },
      {
        "x": 14,
        "y": 27
      },
      {
        "x": 98,
        "y": 13
      },
      {
        "x": 99,
        "y": 112
      },
      {
        "x": 78,
        "y": 95
      },
      {
        "x": 88,
        "y": 78
      },
      {
        "x": 47,
        "y": 69
      },
      {
        "x": 4,
        "y": 104
      },
      {
        "x": 59,
        "y": 18
      },
      {
        "x": 100,
        "y": 40
      }
    ]
  }
]

const TreemapData = {
  "name": "nivo",
  "children": [
    {
      "name": "viz",
      "children": [
        {
          "name": "stack",
          "children": [
            {
              "name": "cchart",
              "value": 93440
            },
            {
              "name": "xAxis",
              "value": 187657
            },
            {
              "name": "yAxis",
              "value": 141208
            },
            {
              "name": "layers",
              "value": 174291
            }
          ]
        },
        {
          "name": "ppie",
          "children": [
            {
              "name": "chart",
              "children": [
                {
                  "name": "pie",
                  "children": [
                    {
                      "name": "outline",
                      "value": 60771
                    },
                    {
                      "name": "slices",
                      "value": 34580
                    },
                    {
                      "name": "bbox",
                      "value": 63816
                    }
                  ]
                },
                {
                  "name": "donut",
                  "value": 127750
                },
                {
                  "name": "gauge",
                  "value": 14640
                }
              ]
            },
            {
              "name": "legends",
              "value": 18672
            }
          ]
        }
      ]
    },
    {
      "name": "colors",
      "children": [
        {
          "name": "rgb",
          "value": 195942
        },
        {
          "name": "hsl",
          "value": 73464
        }
      ]
    },
    {
      "name": "utils",
      "children": [
        {
          "name": "randomize",
          "value": 46349
        },
        {
          "name": "resetCvaluek",
          "value": 87071
        },
        {
          "name": "noop",
          "value": 6948
        },
        {
          "name": "tick",
          "value": 142766
        },
        {
          "name": "forceGC",
          "value": 109366
        },
        {
          "name": "stackTrace",
          "value": 119942
        },
        {
          "name": "dbg",
          "value": 25100
        }
      ]
    },
    {
      "name": "generators",
      "children": [
        {
          "name": "address",
          "value": 2300
        },
        {
          "name": "city",
          "value": 48050
        },
        {
          "name": "animal",
          "value": 63268
        },
        {
          "name": "movie",
          "value": 7382
        },
        {
          "name": "user",
          "value": 193278
        }
      ]
    },
    {
      "name": "set",
      "children": [
        {
          "name": "clone",
          "value": 26749
        },
        {
          "name": "intersect",
          "value": 30199
        },
        {
          "name": "merge",
          "value": 6303
        },
        {
          "name": "reverse",
          "value": 173665
        },
        {
          "name": "toArray",
          "value": 4421
        },
        {
          "name": "toObject",
          "value": 159051
        },
        {
          "name": "fromCSV",
          "value": 53510
        },
        {
          "name": "slice",
          "value": 142365
        },
        {
          "name": "append",
          "value": 151753
        },
        {
          "name": "prepend",
          "value": 7871
        },
        {
          "name": "shuffle",
          "value": 34516
        },
        {
          "name": "pick",
          "value": 154260
        },
        {
          "name": "plouc",
          "value": 106502
        }
      ]
    },
    {
      "name": "text",
      "children": [
        {
          "name": "trim",
          "value": 78393
        },
        {
          "name": "slugify",
          "value": 38783
        },
        {
          "name": "snakeCase",
          "value": 10910
        },
        {
          "name": "camelCase",
          "value": 59981
        },
        {
          "name": "repeat",
          "value": 149808
        },
        {
          "name": "padLeft",
          "value": 8303
        },
        {
          "name": "padRight",
          "value": 188805
        },
        {
          "name": "sanitize",
          "value": 56207
        },
        {
          "name": "ploucify",
          "value": 155229
        }
      ]
    },
    {
      "name": "misc",
      "children": [
        {
          "name": "greetings",
          "children": [
            {
              "name": "hey",
              "value": 22468
            },
            {
              "name": "HOWDY",
              "value": 38259
            },
            {
              "name": "aloha",
              "value": 126470
            },
            {
              "name": "AHOY",
              "value": 65678
            }
          ]
        },
        {
          "name": "other",
          "value": 160147
        },
        {
          "name": "path",
          "children": [
            {
              "name": "pathA",
              "value": 87579
            },
            {
              "name": "pathB",
              "children": [
                {
                  "name": "pathB1",
                  "value": 144032
                },
                {
                  "name": "pathB2",
                  "value": 113088
                },
                {
                  "name": "pathB3",
                  "value": 132362
                },
                {
                  "name": "pathB4",
                  "value": 88922
                }
              ]
            },
            {
              "name": "pathC",
              "children": [
                {
                  "name": "pathC1",
                  "value": 9363
                },
                {
                  "name": "pathC2",
                  "value": 18366
                },
                {
                  "name": "pathC3",
                  "value": 176021
                },
                {
                  "name": "pathC4",
                  "value": 38051
                },
                {
                  "name": "pathC5",
                  "value": 198693
                },
                {
                  "name": "pathC6",
                  "value": 25521
                },
                {
                  "name": "pathC7",
                  "value": 155336
                },
                {
                  "name": "pathC8",
                  "value": 9407
                },
                {
                  "name": "pathC9",
                  "value": 96380
                }
              ]
            }
          ]
        }
      ]
    }
  ]
}

const BulletData = [
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

const BarData = [
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

const MarimekkoData = [
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

export default function General(props) {
  var classes = useStyles();
  var theme = useTheme();

	var [calenderData, setCalenderData] = useState([]);
	var [pieChartData, setPieChartData] = useState([]);
	var [scatterPlotData, setScatterPlotData] = useState([]);
	var [bulletData, setBulletData] = useState([]);
	var [barData, setBarData] = useState([]);
	var [marimekkoData, setMarimekkoData] = useState([]);

	useEffect(() => {
		
	})

	return (
		<>
			<Grid container spacing={4}>
				<Grid item lg={6} md={8} sm={12} xs={24}>
					<Widget title="ScatterPlot" noBodyPadding upperTitle>
            <Grid item xs={24}>
							<ResponsiveContainer width="100%" height={350}>
								<ScatterPlot
									data={ScatterPlotData}
									height={300}
								/>
							</ResponsiveContainer>
						</Grid>
					</Widget>
				</Grid>
				<Grid item lg={6} md={8} sm={12} xs={24}>
					<Widget title="Treemap" noBodyPadding upperTitle>
            <Grid item xs={24}>
							<ResponsiveContainer width="100%" height={350}>
								<Treemap
                  data={TreemapData}
									height={300}
								/>
							</ResponsiveContainer>
						</Grid>
					</Widget>
				</Grid>
				<Grid item lg={6} md={8} sm={12} xs={24}>
					<Widget title="Bullet" noBodyPadding upperTitle>
            <Grid item xs={24}>
							<ResponsiveContainer width="100%" height={350}>
								<Bullet
									data={BulletData}
									height={300}
								/>
							</ResponsiveContainer>
						</Grid>
					</Widget>
				</Grid>
				<Grid item lg={6} md={8} sm={12} xs={24}>
					<Widget title="Bar" noBodyPadding upperTitle>
            <Grid item xs={24}>
							<ResponsiveContainer width="100%" height={350}>
								<Bar
									data={BarData}
									height={300}
								/>
							</ResponsiveContainer>
						</Grid>
					</Widget>
				</Grid>
				<Grid item lg={6} md={8} sm={12} xs={24}>
					<Widget title="Marimekko" noBodyPadding upperTitle>
            <Grid item xs={24}>
							<ResponsiveContainer width="100%" height={350}>
								<Marimekko
									data={MarimekkoData}
									height={300}
								/>
							</ResponsiveContainer>
						</Grid>
					</Widget>
				</Grid>
      </Grid>
		</>
	);
}