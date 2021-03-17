import React from "react";
// install (please make sure versions match peerDependencies)
// yarn add @nivo/core @nivo/treemap
import { ResponsiveTreeMap } from '@nivo/treemap'
// make sure parent container have a defined height when using
// responsive component, otherwise height will be 0 and
// no chart will be rendered.
// website examples showcase many properties,
// you'll often use just a few of them.
export default () => (
	<ResponsiveTreeMap
    data={data}
    identity="name"
    value="loc"
    valueFormat=".02s"
    margin={{ top: 10, right: 10, bottom: 10, left: 10 }}
    labelSkipSize={12}
    labelTextColor={{ from: 'color', modifiers: [ [ 'darker', 1.2 ] ] }}
    parentLabelTextColor={{ from: 'color', modifiers: [ [ 'darker', 2 ] ] }}
    borderColor={{ from: 'color', modifiers: [ [ 'darker', 0.1 ] ] }}
  />
)

const data = {
  "name": "nivo",
  "color": "hsl(246, 70%, 50%)",
  "children": [
    {
      "name": "viz",
      "color": "hsl(74, 70%, 50%)",
      "children": [
        {
          "name": "stack",
          "color": "hsl(147, 70%, 50%)",
          "children": [
            {
              "name": "cchart",
              "color": "hsl(28, 70%, 50%)",
              "loc": 93440
            },
            {
              "name": "xAxis",
              "color": "hsl(354, 70%, 50%)",
              "loc": 187657
            },
            {
              "name": "yAxis",
              "color": "hsl(110, 70%, 50%)",
              "loc": 141208
            },
            {
              "name": "layers",
              "color": "hsl(338, 70%, 50%)",
              "loc": 174291
            }
          ]
        },
        {
          "name": "ppie",
          "color": "hsl(121, 70%, 50%)",
          "children": [
            {
              "name": "chart",
              "color": "hsl(244, 70%, 50%)",
              "children": [
                {
                  "name": "pie",
                  "color": "hsl(297, 70%, 50%)",
                  "children": [
                    {
                      "name": "outline",
                      "color": "hsl(234, 70%, 50%)",
                      "loc": 60771
                    },
                    {
                      "name": "slices",
                      "color": "hsl(91, 70%, 50%)",
                      "loc": 34580
                    },
                    {
                      "name": "bbox",
                      "color": "hsl(3, 70%, 50%)",
                      "loc": 63816
                    }
                  ]
                },
                {
                  "name": "donut",
                  "color": "hsl(153, 70%, 50%)",
                  "loc": 127750
                },
                {
                  "name": "gauge",
                  "color": "hsl(322, 70%, 50%)",
                  "loc": 14640
                }
              ]
            },
            {
              "name": "legends",
              "color": "hsl(321, 70%, 50%)",
              "loc": 18672
            }
          ]
        }
      ]
    },
    {
      "name": "colors",
      "color": "hsl(227, 70%, 50%)",
      "children": [
        {
          "name": "rgb",
          "color": "hsl(78, 70%, 50%)",
          "loc": 195942
        },
        {
          "name": "hsl",
          "color": "hsl(168, 70%, 50%)",
          "loc": 73464
        }
      ]
    },
    {
      "name": "utils",
      "color": "hsl(298, 70%, 50%)",
      "children": [
        {
          "name": "randomize",
          "color": "hsl(337, 70%, 50%)",
          "loc": 46349
        },
        {
          "name": "resetClock",
          "color": "hsl(194, 70%, 50%)",
          "loc": 87071
        },
        {
          "name": "noop",
          "color": "hsl(294, 70%, 50%)",
          "loc": 6948
        },
        {
          "name": "tick",
          "color": "hsl(334, 70%, 50%)",
          "loc": 142766
        },
        {
          "name": "forceGC",
          "color": "hsl(248, 70%, 50%)",
          "loc": 109366
        },
        {
          "name": "stackTrace",
          "color": "hsl(139, 70%, 50%)",
          "loc": 119942
        },
        {
          "name": "dbg",
          "color": "hsl(205, 70%, 50%)",
          "loc": 25100
        }
      ]
    },
    {
      "name": "generators",
      "color": "hsl(121, 70%, 50%)",
      "children": [
        {
          "name": "address",
          "color": "hsl(140, 70%, 50%)",
          "loc": 2300
        },
        {
          "name": "city",
          "color": "hsl(327, 70%, 50%)",
          "loc": 48050
        },
        {
          "name": "animal",
          "color": "hsl(149, 70%, 50%)",
          "loc": 63268
        },
        {
          "name": "movie",
          "color": "hsl(232, 70%, 50%)",
          "loc": 7382
        },
        {
          "name": "user",
          "color": "hsl(230, 70%, 50%)",
          "loc": 193278
        }
      ]
    },
    {
      "name": "set",
      "color": "hsl(270, 70%, 50%)",
      "children": [
        {
          "name": "clone",
          "color": "hsl(115, 70%, 50%)",
          "loc": 26749
        },
        {
          "name": "intersect",
          "color": "hsl(157, 70%, 50%)",
          "loc": 30199
        },
        {
          "name": "merge",
          "color": "hsl(102, 70%, 50%)",
          "loc": 6303
        },
        {
          "name": "reverse",
          "color": "hsl(355, 70%, 50%)",
          "loc": 173665
        },
        {
          "name": "toArray",
          "color": "hsl(247, 70%, 50%)",
          "loc": 4421
        },
        {
          "name": "toObject",
          "color": "hsl(261, 70%, 50%)",
          "loc": 159051
        },
        {
          "name": "fromCSV",
          "color": "hsl(97, 70%, 50%)",
          "loc": 53510
        },
        {
          "name": "slice",
          "color": "hsl(180, 70%, 50%)",
          "loc": 142365
        },
        {
          "name": "append",
          "color": "hsl(296, 70%, 50%)",
          "loc": 151753
        },
        {
          "name": "prepend",
          "color": "hsl(82, 70%, 50%)",
          "loc": 7871
        },
        {
          "name": "shuffle",
          "color": "hsl(342, 70%, 50%)",
          "loc": 34516
        },
        {
          "name": "pick",
          "color": "hsl(232, 70%, 50%)",
          "loc": 154260
        },
        {
          "name": "plouc",
          "color": "hsl(13, 70%, 50%)",
          "loc": 106502
        }
      ]
    },
    {
      "name": "text",
      "color": "hsl(328, 70%, 50%)",
      "children": [
        {
          "name": "trim",
          "color": "hsl(156, 70%, 50%)",
          "loc": 78393
        },
        {
          "name": "slugify",
          "color": "hsl(142, 70%, 50%)",
          "loc": 38783
        },
        {
          "name": "snakeCase",
          "color": "hsl(125, 70%, 50%)",
          "loc": 10910
        },
        {
          "name": "camelCase",
          "color": "hsl(332, 70%, 50%)",
          "loc": 59981
        },
        {
          "name": "repeat",
          "color": "hsl(208, 70%, 50%)",
          "loc": 149808
        },
        {
          "name": "padLeft",
          "color": "hsl(240, 70%, 50%)",
          "loc": 8303
        },
        {
          "name": "padRight",
          "color": "hsl(111, 70%, 50%)",
          "loc": 188805
        },
        {
          "name": "sanitize",
          "color": "hsl(223, 70%, 50%)",
          "loc": 56207
        },
        {
          "name": "ploucify",
          "color": "hsl(340, 70%, 50%)",
          "loc": 155229
        }
      ]
    },
    {
      "name": "misc",
      "color": "hsl(178, 70%, 50%)",
      "children": [
        {
          "name": "greetings",
          "color": "hsl(238, 70%, 50%)",
          "children": [
            {
              "name": "hey",
              "color": "hsl(282, 70%, 50%)",
              "loc": 22468
            },
            {
              "name": "HOWDY",
              "color": "hsl(288, 70%, 50%)",
              "loc": 38259
            },
            {
              "name": "aloha",
              "color": "hsl(129, 70%, 50%)",
              "loc": 126470
            },
            {
              "name": "AHOY",
              "color": "hsl(227, 70%, 50%)",
              "loc": 65678
            }
          ]
        },
        {
          "name": "other",
          "color": "hsl(316, 70%, 50%)",
          "loc": 160147
        },
        {
          "name": "path",
          "color": "hsl(219, 70%, 50%)",
          "children": [
            {
              "name": "pathA",
              "color": "hsl(248, 70%, 50%)",
              "loc": 87579
            },
            {
              "name": "pathB",
              "color": "hsl(182, 70%, 50%)",
              "children": [
                {
                  "name": "pathB1",
                  "color": "hsl(133, 70%, 50%)",
                  "loc": 144032
                },
                {
                  "name": "pathB2",
                  "color": "hsl(327, 70%, 50%)",
                  "loc": 113088
                },
                {
                  "name": "pathB3",
                  "color": "hsl(179, 70%, 50%)",
                  "loc": 132362
                },
                {
                  "name": "pathB4",
                  "color": "hsl(23, 70%, 50%)",
                  "loc": 88922
                }
              ]
            },
            {
              "name": "pathC",
              "color": "hsl(151, 70%, 50%)",
              "children": [
                {
                  "name": "pathC1",
                  "color": "hsl(149, 70%, 50%)",
                  "loc": 9363
                },
                {
                  "name": "pathC2",
                  "color": "hsl(122, 70%, 50%)",
                  "loc": 18366
                },
                {
                  "name": "pathC3",
                  "color": "hsl(256, 70%, 50%)",
                  "loc": 176021
                },
                {
                  "name": "pathC4",
                  "color": "hsl(239, 70%, 50%)",
                  "loc": 38051
                },
                {
                  "name": "pathC5",
                  "color": "hsl(141, 70%, 50%)",
                  "loc": 198693
                },
                {
                  "name": "pathC6",
                  "color": "hsl(320, 70%, 50%)",
                  "loc": 25521
                },
                {
                  "name": "pathC7",
                  "color": "hsl(3, 70%, 50%)",
                  "loc": 155336
                },
                {
                  "name": "pathC8",
                  "color": "hsl(148, 70%, 50%)",
                  "loc": 9407
                },
                {
                  "name": "pathC9",
                  "color": "hsl(146, 70%, 50%)",
                  "loc": 96380
                }
              ]
            }
          ]
        }
      ]
    }
  ]
}