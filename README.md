# mall_demo
算是一个后端的手脚架吧，尚未完成，正在填充内容。

### 开发环境及工具

JDK1.8,maven,IDEA2018,springboot2.1.6,mysql5.5.62,docker,rabbitmq,elasticsearch

### 技术结构

spring boot                 基础架构

spring data JPA             持久层框架

spring security OAuth2      登录认证及权限控制

redis                       缓存数据库

elasticsearch               集成检索引擎

rabbitmq                    集成消息队列


### 项目启动
1、创建mall_demo数据库，修改url地址（jpa自动创建数据库表）

2、开启redis ,修改redis地址

3、开启es,修改es地址

4、开启rabbitmq,修改rabbitmq地址

5、启动项目

6、访问 http://localhost:2001/oauth/token 获取access_token 如下图所示
（传图有点麻烦，参考博客吧 https://blog.csdn.net/lidai352710967/article/details/95994334）

7、通过 access_token 访问其他接口



