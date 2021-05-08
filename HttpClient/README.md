# HttpClient

[![LICENSE](https://img.shields.io/badge/License-MIT-%23FF4D5B.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem/blob/master/LICENSE)
[![Python](https://img.shields.io/badge/Python-v3.9.0-blue.svg?style=flat-square)](https://github.com/DolorHunter/1p3aMSCSAdminReport/releases)

## 目录结构

```plain
HttpClient （车辆故障信息采集与分析）
├ Analysis.py （数据分析模块）
├ HttpUtil.py （数据采集与保存模块）
└ main.py （主调模块）
```

## 使用

每日执行一次数据采集与分析任务（可部署于crontab）。

```plain
yarn
$ python main.py
```
