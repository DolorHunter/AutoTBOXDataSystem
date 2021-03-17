import React from "react";
// install (please make sure versions match peerDependencies)
// yarn add @nivo/core @nivo/calendar
import { ResponsiveCalendar } from '@nivo/calendar'
// make sure parent container have a defined height when using
// responsive component, otherwise height will be 0 and
// no chart will be rendered.
// website examples showcase many properties,
// you'll often use just a few of them.
export default () => (
	<ResponsiveCalendar
		data={data}
		from="2016-01-01"
		to="2016-12-31"
		emptyColor="#eeeeee"
		colors={['#3CD4A0', '#536DFE', '#FFC260', '#FF5C93']}
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

const data = [
	{
		"day": "2015-10-15",
		"value": 243
	},
	{
		"day": "2017-06-04",
		"value": 285
	},
	{
		"day": "2018-01-17",
		"value": 261
	},
	{
		"day": "2016-09-02",
		"value": 178
	},
	{
		"day": "2018-02-06",
		"value": 214
	},
	{
		"day": "2016-10-19",
		"value": 292
	},
	{
		"day": "2016-04-02",
		"value": 79
	},
	{
		"day": "2016-08-08",
		"value": 228
	},
	{
		"day": "2018-03-08",
		"value": 92
	},
	{
		"day": "2016-03-24",
		"value": 346
	},
	{
		"day": "2016-06-07",
		"value": 137
	},
	{
		"day": "2017-01-06",
		"value": 4
	},
	{
		"day": "2018-03-19",
		"value": 242
	},
	{
		"day": "2016-04-15",
		"value": 275
	},
	{
		"day": "2016-07-31",
		"value": 270
	},
	{
		"day": "2018-05-13",
		"value": 317
	},
	{
		"day": "2018-02-21",
		"value": 211
	},
	{
		"day": "2016-12-06",
		"value": 155
	},
	{
		"day": "2018-03-14",
		"value": 239
	},
	{
		"day": "2017-02-23",
		"value": 135
	},
	{
		"day": "2017-01-14",
		"value": 98
	},
	{
		"day": "2017-02-01",
		"value": 104
	},
	{
		"day": "2016-03-21",
		"value": 75
	},
	{
		"day": "2016-09-08",
		"value": 170
	},
	{
		"day": "2017-04-17",
		"value": 165
	},
	{
		"day": "2016-09-17",
		"value": 174
	},
	{
		"day": "2016-05-06",
		"value": 226
	},
	{
		"day": "2017-03-18",
		"value": 321
	},
	{
		"day": "2017-02-12",
		"value": 183
	},
	{
		"day": "2017-04-16",
		"value": 232
	},
	{
		"day": "2018-06-18",
		"value": 316
	},
	{
		"day": "2018-03-04",
		"value": 186
	},
	{
		"day": "2017-02-27",
		"value": 68
	},
	{
		"day": "2016-01-14",
		"value": 233
	},
	{
		"day": "2018-03-17",
		"value": 179
	},
	{
		"day": "2016-07-01",
		"value": 184
	},
	{
		"day": "2017-08-22",
		"value": 32
	},
	{
		"day": "2016-03-19",
		"value": 312
	},
	{
		"day": "2016-11-29",
		"value": 80
	},
	{
		"day": "2018-06-07",
		"value": 121
	},
	{
		"day": "2017-09-24",
		"value": 195
	},
	{
		"day": "2017-08-21",
		"value": 281
	},
	{
		"day": "2017-01-20",
		"value": 294
	},
	{
		"day": "2016-07-12",
		"value": 24
	},
	{
		"day": "2017-08-15",
		"value": 236
	},
	{
		"day": "2017-03-09",
		"value": 54
	},
	{
		"day": "2016-07-13",
		"value": 247
	},
	{
		"day": "2017-06-02",
		"value": 74
	},
	{
		"day": "2017-02-19",
		"value": 342
	},
	{
		"day": "2017-09-17",
		"value": 72
	},
	{
		"day": "2016-12-03",
		"value": 165
	},
	{
		"day": "2017-11-27",
		"value": 378
	},
	{
		"day": "2018-04-09",
		"value": 35
	},
	{
		"day": "2017-02-13",
		"value": 149
	},
	{
		"day": "2016-04-14",
		"value": 289
	},
	{
		"day": "2017-09-13",
		"value": 33
	},
	{
		"day": "2016-10-14",
		"value": 122
	},
	{
		"day": "2017-01-27",
		"value": 195
	},
	{
		"day": "2016-08-19",
		"value": 8
	},
	{
		"day": "2016-09-22",
		"value": 17
	},
	{
		"day": "2017-04-23",
		"value": 13
	},
	{
		"day": "2017-04-19",
		"value": 161
	},
	{
		"day": "2018-06-02",
		"value": 333
	},
	{
		"day": "2017-12-28",
		"value": 274
	},
	{
		"day": "2016-08-22",
		"value": 215
	},
	{
		"day": "2016-09-19",
		"value": 120
	},
	{
		"day": "2018-04-07",
		"value": 387
	},
	{
		"day": "2016-02-03",
		"value": 130
	},
	{
		"day": "2018-02-16",
		"value": 91
	},
	{
		"day": "2016-07-14",
		"value": 252
	},
	{
		"day": "2017-04-06",
		"value": 381
	},
	{
		"day": "2017-08-18",
		"value": 209
	},
	{
		"day": "2016-01-15",
		"value": 347
	},
	{
		"day": "2017-08-27",
		"value": 358
	},
	{
		"day": "2016-04-25",
		"value": 79
	},
	{
		"day": "2016-01-04",
		"value": 163
	},
	{
		"day": "2017-07-17",
		"value": 145
	},
	{
		"day": "2017-02-06",
		"value": 187
	},
	{
		"day": "2016-03-18",
		"value": 126
	},
	{
		"day": "2018-03-09",
		"value": 45
	},
	{
		"day": "2017-05-22",
		"value": 68
	},
	{
		"day": "2018-05-06",
		"value": 272
	},
	{
		"day": "2017-03-06",
		"value": 239
	},
	{
		"day": "2017-08-23",
		"value": 240
	},
	{
		"day": "2018-05-23",
		"value": 236
	},
	{
		"day": "2017-02-21",
		"value": 259
	},
	{
		"day": "2017-09-05",
		"value": 144
	},
	{
		"day": "2016-09-21",
		"value": 333
	},
	{
		"day": "2018-01-12",
		"value": 225
	},
	{
		"day": "2016-06-20",
		"value": 292
	},
	{
		"day": "2016-01-27",
		"value": 173
	},
	{
		"day": "2017-07-07",
		"value": 358
	},
	{
		"day": "2016-03-05",
		"value": 103
	},
	{
		"day": "2016-11-12",
		"value": 367
	},
	{
		"day": "2016-08-15",
		"value": 279
	},
	{
		"day": "2016-01-06",
		"value": 167
	},
	{
		"day": "2017-04-15",
		"value": 205
	},
	{
		"day": "2016-05-07",
		"value": 385
	},
	{
		"day": "2017-10-13",
		"value": 125
	},
	{
		"day": "2016-06-22",
		"value": 142
	},
	{
		"day": "2017-07-01",
		"value": 189
	},
	{
		"day": "2017-10-22",
		"value": 47
	},
	{
		"day": "2018-03-25",
		"value": 322
	},
	{
		"day": "2017-12-15",
		"value": 222
	},
	{
		"day": "2016-04-09",
		"value": 387
	},
	{
		"day": "2018-01-31",
		"value": 261
	},
	{
		"day": "2016-02-12",
		"value": 15
	},
	{
		"day": "2017-11-13",
		"value": 369
	},
	{
		"day": "2017-08-10",
		"value": 181
	},
	{
		"day": "2017-03-25",
		"value": 325
	},
	{
		"day": "2018-07-13",
		"value": 34
	},
	{
		"day": "2017-12-29",
		"value": 275
	},
	{
		"day": "2017-01-31",
		"value": 334
	},
	{
		"day": "2018-03-24",
		"value": 219
	},
	{
		"day": "2016-10-15",
		"value": 219
	},
	{
		"day": "2018-07-20",
		"value": 253
	},
	{
		"day": "2016-03-27",
		"value": 41
	},
	{
		"day": "2018-04-01",
		"value": 94
	},
	{
		"day": "2017-01-21",
		"value": 357
	},
	{
		"day": "2018-07-21",
		"value": 399
	},
	{
		"day": "2016-05-28",
		"value": 308
	},
	{
		"day": "2016-09-01",
		"value": 276
	},
	{
		"day": "2017-04-27",
		"value": 217
	},
	{
		"day": "2017-12-16",
		"value": 248
	},
	{
		"day": "2016-02-29",
		"value": 104
	},
	{
		"day": "2016-08-12",
		"value": 68
	},
	{
		"day": "2018-06-28",
		"value": 334
	},
	{
		"day": "2017-01-13",
		"value": 220
	},
	{
		"day": "2017-09-01",
		"value": 185
	},
	{
		"day": "2017-02-20",
		"value": 83
	},
	{
		"day": "2018-05-19",
		"value": 279
	},
	{
		"day": "2016-10-26",
		"value": 127
	},
	{
		"day": "2018-07-15",
		"value": 19
	},
	{
		"day": "2018-07-11",
		"value": 117
	},
	{
		"day": "2016-04-10",
		"value": 282
	},
	{
		"day": "2018-02-03",
		"value": 215
	},
	{
		"day": "2016-07-03",
		"value": 266
	},
	{
		"day": "2016-09-25",
		"value": 202
	},
	{
		"day": "2016-07-10",
		"value": 147
	},
	{
		"day": "2017-05-27",
		"value": 38
	},
	{
		"day": "2016-10-11",
		"value": 148
	},
	{
		"day": "2016-09-29",
		"value": 143
	},
	{
		"day": "2017-02-08",
		"value": 333
	},
	{
		"day": "2018-02-12",
		"value": 280
	},
	{
		"day": "2018-01-21",
		"value": 392
	},
	{
		"day": "2016-06-03",
		"value": 131
	},
	{
		"day": "2016-06-13",
		"value": 319
	},
	{
		"day": "2018-04-11",
		"value": 231
	},
	{
		"day": "2016-08-24",
		"value": 264
	},
	{
		"day": "2016-05-24",
		"value": 11
	},
	{
		"day": "2016-12-15",
		"value": 26
	},
	{
		"day": "2016-02-19",
		"value": 66
	},
	{
		"day": "2018-04-26",
		"value": 343
	},
	{
		"day": "2016-06-26",
		"value": 289
	},
	{
		"day": "2017-03-24",
		"value": 166
	},
	{
		"day": "2016-10-29",
		"value": 111
	},
	{
		"day": "2016-05-15",
		"value": 53
	},
	{
		"day": "2017-12-20",
		"value": 282
	},
	{
		"day": "2016-02-20",
		"value": 10
	},
	{
		"day": "2017-04-10",
		"value": 70
	},
	{
		"day": "2016-10-17",
		"value": 400
	},
	{
		"day": "2016-03-28",
		"value": 349
	},
	{
		"day": "2016-03-15",
		"value": 177
	},
	{
		"day": "2016-11-15",
		"value": 370
	},
	{
		"day": "2016-04-30",
		"value": 183
	},
	{
		"day": "2016-12-21",
		"value": 382
	},
	{
		"day": "2017-12-18",
		"value": 117
	},
	{
		"day": "2016-11-28",
		"value": 320
	},
	{
		"day": "2018-07-07",
		"value": 103
	},
	{
		"day": "2017-03-07",
		"value": 350
	},
	{
		"day": "2017-07-23",
		"value": 272
	},
	{
		"day": "2016-01-20",
		"value": 381
	},
	{
		"day": "2016-12-11",
		"value": 331
	},
	{
		"day": "2016-05-03",
		"value": 49
	},
	{
		"day": "2016-12-27",
		"value": 136
	},
	{
		"day": "2017-10-27",
		"value": 366
	},
	{
		"day": "2017-09-08",
		"value": 302
	},
	{
		"day": "2016-11-19",
		"value": 51
	},
	{
		"day": "2018-04-28",
		"value": 388
	},
	{
		"day": "2017-01-07",
		"value": 26
	},
	{
		"day": "2018-07-09",
		"value": 330
	},
	{
		"day": "2018-01-18",
		"value": 294
	},
	{
		"day": "2018-05-05",
		"value": 157
	},
	{
		"day": "2016-10-12",
		"value": 330
	},
	{
		"day": "2016-10-22",
		"value": 95
	},
	{
		"day": "2017-04-30",
		"value": 7
	},
	{
		"day": "2017-07-26",
		"value": 361
	},
	{
		"day": "2016-03-26",
		"value": 274
	},
	{
		"day": "2017-05-23",
		"value": 248
	},
	{
		"day": "2018-01-01",
		"value": 83
	},
	{
		"day": "2018-07-18",
		"value": 64
	},
	{
		"day": "2017-05-10",
		"value": 380
	}
]
