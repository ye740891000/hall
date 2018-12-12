**服务器端**
- git init --bare xxx.git
- chown -R git:git xxx.git
- git clone git@IP:/home/gitrepo/xxx.git
**本地关联远程**
- git remote add origin git@IP:/home/gitrepo/xxx.git
- git push -u origin master
- git remote rm origin
**项目说明** 
- 轻量级的，前后端分离
- 支持MySQL、Oracle、SQL Server、PostgreSQL等主流数据库

**项目结构** 
```
hall
├─db  项目SQL语句
│
├─common 公共模块
│  ├─annotation 自定义注解
│  ├─aspect 自定义注解切面
│  ├─constant 自定义常量
│  ├─exception 异常处理
│  ├─Handler 其他Handler
│  ├─utils 工具类
│  ├─validator 后台校验
│  └─xss XSS过滤
│ 
├─config 配置信息 
│ 
├─modules 功能模块
│  ├─app API接口模块(APP调用) 待定 可能合并至 sys 模块
│  ├─netty socket服务
│  ├─job 定时任务模块 待定
│  ├─oss 文件服务模块
│  └─sys 权限模块 
│  └─uec 消息工具
│ 
├─HallApplication 项目启动类
│  
├──resources 
│  ├─mapper SQL对应的XML文件
│  └─static 静态资源（nginx 动静分离）

```

**技术选型：** 
- 核心框架：Spring Boot 2.0
- 安全框架：Apache Shiro 1.4
- 视图框架：Spring MVC 5.0
- 持久层框架：MyBatis 3.3
- 定时器：Quartz 2.3
- 数据库连接池：Druid 1.0
- 日志管理：SLF4J 1.7、Log4j
- 页面交互：Vue2.x 
<br> 


 **后端部署**
- 创建数据库hallcloud，数据库编码为UTF-8
- 执行db/mysql.sql文件，初始化数据
- 修改application-dev.yml，更新MySQL账号和密码
- Eclipse、IDEA运行Application.java，则可启动项目
- Swagger路径：http://localhost:8080/swagger/index.html

 **前端部署**
 - 本项目是前后端分离的，还需要部署前端，才能运行起来
 - 前端部署完毕，就可以访问项目了，账号：admin，密码：admin