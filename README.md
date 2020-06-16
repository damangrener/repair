# repair
基于Spring Cloud的空调维修平台(前端小程序，毕设用，非实际项目)
项目中的repairWx、repairAdmin、repairServiceMan是相同的，仅是为了项目展示。
## 1.平台环境
小程序名称：WTF空调维修平台  
面向用户：普通用户、平台管理员、空调维修工程师  
运行环境：centos7、微信  
开发工具：idea2019、微信开发者工具、Navicat、Redis Desktop Management  
开发语言：Java、小程序语言  
开发版本：各个服务介绍jdk1.8、maven3.5.4、Spring Boot2.2.5、MySql8、MyBatis3、redis4.3、openFeign2.2  
## 2.各个服务介绍
| 服务名称| 	服务简称| 	服务端口| 
|  :----:   | :----:   |:----:   |
|Eureka注册中心|	service-eureka|	9010|
|Zuul网关服务|	service-gateway	|9020|
|用户服务	|api-user	|9091|
|订单服务|	api-service|	9092|
|文章服务	|api-article|	9094|
## 3.部分界面效果图
![image](https://github.com/ReklFly/repair/blob/master/repair/img/%E5%AE%A2%E6%88%B7%E6%9F%A5%E7%9C%8B%E8%AE%A2%E5%8D%95%E7%8A%B6%E6%80%81.PNG)
![image](https://github.com/ReklFly/repair/blob/master/repair/img/2.PNG)
