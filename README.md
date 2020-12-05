# Auto TBOX Data System

[![LICENSE](https://img.shields.io/badge/License-MIT-%23FF4D5B.svg?style=flat-square)](LICENSE)
[![Java](https://img.shields.io/badge/Java-v1.8-brown.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)
[![Spring](https://img.shields.io/badge/Spring-v2.4.0-green.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)
[![Maven](https://img.shields.io/badge/Maven-v3.6.3-yellow.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)
[![HTML5](https://img.shields.io/badge/HTML-5-red.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)
[![CSS](https://img.shields.io/badge/CSS-3-blue.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)
[![Javascript](https://img.shields.io/badge/Javascript-v1.8.5-orange.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)
[![MySQL](https://img.shields.io/badge/MySQL-v8.0.22-lightgrey.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem)

汽车TBOX数据采集及分析系统设计与实现

## 开发资料

### Spring

安装环境, 搭建Spring框架

- IDEA创建Spring应用 [Tutorial: Create your first Spring application](https://www.jetbrains.com/help/idea/your-first-spring-application.html)
- Spring配置生成器 [Spring initializr](https://start.spring.io/)
- Maven代理配置(proxy缩进需要调整,可用IDEA打开调试) [jetbrains - Using Maven behind proxy](https://Integerellij-support.jetbrains.com/hc/en-us/community/posts/206200819-Using-Maven-behind-proxy)
- Spring配置调试 [CSDN - idea注解爆红解决](https://blog.csdn.net/lteffp/article/details/89505338)
- Spring配置MySQL [Spring guides - Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

数据库相关部分: JPA, Hibernate

- JPA和Hibernate实体类注释 [VladMihalcea - How to inherit properties from a base class entity using @MappedSuperclass with JPA and Hibernate](https://vladmihalcea.com/how-to-inherit-properties-from-a-base-class-entity-using-mappedsuperclass-with-jpa-and-hibernate/)
- 数据库表注释/字段注释 [CSDN - Spring boot 搭配 JPA 生成表注释 和 字段注释](https://blog.csdn.net/qq_39996837/article/details/84717748)
- JPA之Entity注解说明 [不發光的螢火蟲 - JPA之Entity注解说明](https://sites.google.com/site/hzg139/home/orm-jihibernate/jpaentity)

### MySQL

如果你有一台VPS(虚拟服务器), 可以在服务器上安装MySQL, 之后通过本地的Navicat或其他软件连接此服务器.

```plain
# root登录
> mysql --user=root -p
```

安装MySQL, 创建用户, 授予权限

- 可视化操作数据库 [Navicat Premium 15 永久激活版安装教程](https://www.cnblogs.com/poloyy/p/12231357.html)
- 在VPS上安装MySQL服务器 [How to install MySQL server on Debian 10 Linux](https://www.cyberciti.biz/faq/how-to-install-mysql-server-on-debian-10-linux/#Installing_MySQL)
- (可选)调整ufw防火墙策略 打开3306端口 [How To Set Up a Firewall with UFW on Debian 9](https://www.digitalocean.com/community/tutorials/how-to-set-up-a-firewall-with-ufw-on-debian-9)
- MySQL指令速查 [begtut.com - MySQL教程](https://www.begtut.com/mysql/)
- 创建用户&授予/撤销权限 [简书 - MySQL创建用户与授权](https://www.jianshu.com/p/d7b9c468f20d)
- Spring配置MySQL [Spring guides - Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

创建表格使用Spring的JPA, 详见 __[Spring](#Spring)__ 部分.

## Entity实体类设计

### BaseEntity

基础实体类, 用于让其他类继承一些基础属性.

<table>
  <tr><th colspan="4" align="center">BaseEntity</th></tr>
  <tr><th>Java实体属性类型</th><th>SQL表属性类型</th><th>Java实体属性名</th><th>注释</th></tr>
  <tr><td>Integer</td><td>int</td><td>id</td><td>ID</td></tr>
  <tr><td>String</td><td>varchar(5)</td><td>isActivated</td><td>启用状态</td></tr>
  <tr><td>String</td><td>varchar(5)</td><td>isDeleted</td><td>删除状态</td></tr>
  <tr><td>String</td><td>varchar(5)</td><td>status</td><td>状态</td></tr>
  <tr><td>String</td><td>varchar(30)</td><td>remark</td><td>备注</td></tr>
  <tr><td>String</td><td>varchar(20)</td><td>createdBy</td><td>创建人</td></tr>
  <tr><td>String</td><td>timestamp</td><td>createdDate</td><td>创建日期</td></tr>
  <tr><td>String</td><td>varchar(20)</td><td>lastUpdatedBy</td><td>最后修改人</td></tr>
  <tr><td>String</td><td>timestamp</td><td>lastUpdatedDate</td><td>最后修改日期</td></tr>
</table>

### UserEntity

用户实体类.

<table>
  <tr><th colspan="4" align="center">UserEntity</th></tr><tr><th>Java实体属性类型</th><th>SQL表属性类型</th><th>Java实体属性名</th><th>注释</th></tr>
  <tr><td colspan="4" align="center">BaseEntity</td></tr>
  <tr><td>String</td><td>varchar(20)</td><td>username</td><td>用户名</td></tr>
  <tr><td>String</td><td>varchar(20)</td><td>password</td><td>密码</td></tr>
  <tr><td>String</td><td>varchar(20)</td><td>email</td><td>邮箱</td></tr>
  <tr><td>String</td><td>varchar(20)</td><td>phone</td><td>电话</td></tr>
  <tr><td>String</td><td>varchar(20)</td><td>avatar</td><td>头像</td></tr>
</table>

### RoleEntity

角色实体类.

不同角色赋予不同菜单权限, 不同权限对应不同菜单.

### UserRoleEntity

用户角色类, 关联用户与角色.

<table>
  <tr><th colspan="4" align="center">UserRoleEntity</th></tr><tr><th>Java实体属性类型</th><th>SQL表属性类型</th><th>Java实体属性名</th><th>注释</th></tr>
  <tr><td colspan="4" align="center">BaseEntity</td></tr>
  <tr><td>Integer</td><td>int</td><td>userId</td><td>用户ID</td></tr>
  <tr><td>Integer</td><td>int</td><td>roleId</td><td>角色ID</td></tr>
</table>

## Controller控制类设计

### UserController

用户控制类.

<table>
  <tr><th colspan="5" align="center">UserController</th></tr>
  <tr><th>控制名</th><th>地址</th><th>输入属性</th><th>验证</th><th>注释</th></tr>
  <tr><td>addUser</td><td>/User/addUser</td><td>userEntity</td><td>x</td><td>添加用户</td></tr>
  <tr><td>hardDeleteUserById</td><td>/User/hardDeleteUserById</td><td>userEntity</td><td>x</td><td>硬删除用户</td></tr>
  <tr><td>softDeleteUserById</td><td>/User/softDeleteUserById</td><td>userEntity</td><td>x</td><td>软删除用户</td></tr>
  <tr><td>restoreUserById</td><td>/User/restoreUserById</td><td>userEntity</td><td>x</td><td>恢复软删除用户</td></tr>
  <tr><td>activateUserById</td><td>/User/activateUserById</td><td>userEntity</td><td>x</td><td>激活用户</td></tr>
  <tr><td>deactivateUserById</td><td>/User/deactivateUserById</td><td>userEntity</td><td>x</td><td>禁用用户</td></tr>
  <tr><td>updateUserById</td><td>/User/updateUserById</td><td>userEntity</td><td>x</td><td>更新用户信息</td></tr>
  <tr><td>searchUserById</td><td>/User/searchUserById</td><td>userEntity</td><td>x</td><td>ID查找用户</td></tr>
  <tr><td>searchAllUser</td><td>/User/searchAllUser</td><td>pageEntity</td><td>x</td><td>查找全部用户</td></tr>
</table>
