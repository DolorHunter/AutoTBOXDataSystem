# Auto TBOX Data System

[![LICENSE](https://img.shields.io/badge/License-MIT-%23FF4D5B.svg?style=flat-square)](LICENSE)
[![Java](https://img.shields.io/badge/Java-v1.8-brown.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)
[![Spring](https://img.shields.io/badge/Spring-v2.4.0-green.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)
[![Maven](https://img.shields.io/badge/Maven-v3.6.3-yellow.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)
[![Tomcat](https://img.shields.io/badge/Tomcat-v7.0.94-darkgreen.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)
[![HTML5](https://img.shields.io/badge/HTML-5-red.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)
[![CSS](https://img.shields.io/badge/CSS-3-blue.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)
[![Javascript](https://img.shields.io/badge/Javascript-v1.8.5-orange.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)
[![Nodejs](https://img.shields.io/badge/Nodejs-v14.15.1-lightgreen.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)
[![React](https://img.shields.io/badge/React-v17.0.1-lightblue.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)
[![MySQL](https://img.shields.io/badge/MySQL-v8.0.22-lightgrey.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)

汽车TBOX数据采集及分析系统设计与实现

## 预览

![login](https://res.cloudinary.com/dfb5w2ccj/image/upload/v1619695879/temp/2021-03-31_162335_cksnwx.webp)

![register](https://res.cloudinary.com/dfb5w2ccj/image/upload/v1619695879/temp/2021-03-31_162321_jwwjm1.webp)

登录与注册界面，沿用react-material-admin模板。

![profile](https://res.cloudinary.com/dfb5w2ccj/image/upload/v1619695879/temp/2021-04-29_192637_ubtiuy.webp)

用户个人资料界面，可修改邮箱，电话，头像。支援6个可选头像。

![security](https://res.cloudinary.com/dfb5w2ccj/image/upload/v1621146897/temp/2021-05-16_142852_qavrsd.webp)

用户账户安全界面，可修改密码。

![dashboard](https://res.cloudinary.com/dfb5w2ccj/image/upload/v1619695879/temp/2021-04-29_192506_t9z5kd.webp)

数据面板/仪表盘对昨日故障，过去一周故障，本年度故障，过去24h实时故障做统计，并渲染图表。

![general](https://res.cloudinary.com/dfb5w2ccj/image/upload/v1619695879/temp/2021-04-29_192557_uwvhmy.webp)

概览使用散列图对单元并发故障次数分布统计；使用树形图对车型/单元/故障占比统计；使用条形图对车型故障单元与4S店售出车辆故障单元统计。

![maps](https://res.cloudinary.com/dfb5w2ccj/image/upload/v1619695880/temp/2021-04-29_192335_n3vtsk.webp)

![maps2](https://res.cloudinary.com/dfb5w2ccj/image/upload/v1619695880/temp/2021-04-29_192418_cqlplx.webp)

地图使用必应地图接口对故障发生的位置进行标记，相同座标的故障求和后显示在标记上。

![warningTable](https://res.cloudinary.com/dfb5w2ccj/image/upload/v1619695881/temp/2021-04-29_192040_cympgk.webp)

车辆故障信息表对数据库中的故障信息进行增删改查并且支持导出/下载。

![userTable](https://res.cloudinary.com/dfb5w2ccj/image/upload/v1619695879/temp/2021-04-29_191930_edfek1.webp)

用户信息表对数据库中的用户信息进行增删改查并且支持导出/下载。其他表格功能类似，也可用来实现基础信息维护。

## 目录结构

```plain
AutoTBOXDataSystem （Spring后端服务与接口，Java）
├ CarCrawlers （爬虫车辆信息数据采集，python）
├ HttpClient （故障数据采集与分析，python）
└ react-material-admin （react前端页面）
```

*注：MySQL搭建于服务器端，其中这是导出的 [SQL源文件](https://github.com/DolorHunter/AutoTBOXDataSystem/blob/master/AutoTBOXDataSystem.sql)。*

## 使用

数据库：安装MySQL到本地或服务器（其他应该也行，只要JPA支持）。

后端：安装Maven（包管理工具），安装Spring包环境(刷新maven自动下载)，安装Tomcat（服务）。

前端：安装Nodejs，安装yarn或npm。

运行HttpClient中的main.py（数据采集与分析），生成visual chart数据，每天执行一次即可。

分别启动Spring和React（命令如下）。

```plain
yarn
$ yarn start

npm
$ npm start
```

## 系统设计与实现细节

- [系统设计与实现细节](README.wiki)
