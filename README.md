# newspaper-subscription
java 课程设计，报刊订阅系统

## 需求
（1）登陆功能：登陆系统为身份验证登录。分为管理员登录和一般用户登录。分别通过不同的用户名和密码进入报刊订阅管理界面，新的用户需要注册。
（2）录入新信息功能：对于管理员，包括新用户信息和新报刊信息的录入功能，信息一旦提交就存入到后台数据库中；普通用户自行注册进行可以修改个人信息。
（3）订阅功能：用户可以订阅报刊，系统自动计算所需金额，并显示在界面上；管理员不可订阅报刊，必须以用户身份订阅报刊。
（4）查询功能：用户可以查询并显示自己所订阅的信息；管理员可以按人员、报刊、出版社分类查询。查询出的信息显示在界面上,并且可以预览和打印出结果。
（5）统计功能：管理员可以按用户、部门、报刊统计报刊的销售情况，并对一些重要的订阅信息进行统计；普通用户可以统计出自己的订阅情况，并且可以预览和打印出结果。

## 技术选型
Java 8 
mysql

## 开发环境
idea2021 java8 mysql8 maven3.6.XX

## 测试部署
- 找到newspaper_subscription.sql 文件，新建newspaper_subscription数据库，然后执行sql文件
- 在resources目录下新建database.properties文件，配置数据库信息
- 启动主程序main就能直接测试