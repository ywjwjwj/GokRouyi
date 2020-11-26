# 若依项目学习

> ### 项目源码：https://gitee.com/y_project/RuoYi



## 2020/11/26



### 1.配置必备环境且下载并导入项目

```
JDK >= 1.8 (推荐1.8版本)
Mysql >= 5.5.0 (推荐5.7版本)
Maven >= 3.0
```

```
下载项目压缩包，导入项目到IDEA

创建数据库ry并导入数据脚本ry_20190215.sql，quartz.sql
```



### 2. 根据文档修改必要配置 部署并运行项目

#### 2.1 修改数据库连接 

```
编辑resources目录下的application-druid.yml

url: 服务器地址
username: 账号 
password: 密码
```

 

![1606402872083](README.assets/1606402872083.png)



#### 2.2 开发环境配置 

```
编辑resources目录下的application.yml 

port: 端口
context-path: 部署路径
```

![1606402762842](README.assets/1606402762842.png)



#### 2.3 运行项目

运行成功则显示该图案

![1606403148670](README.assets/1606403148670.png)

在浏览器中输入http://localhost:端口号（默认80） , 此次是http://localhost:8080



### 3.查看官方项目介绍

#### 3.1 文件结构

```
com.ruoyi     
├── common            // 工具类
│       └── annotation                    // 自定义注解
│       └── config                        // 全局配置
│       └── constant                      // 通用常量
│       └── core                          // 核心控制
│       └── enums                         // 通用枚举
│       └── exception                     // 通用异常
│       └── json                          // JSON数据处理
│       └── utils                         // 通用类处理
│       └── xss                           // XSS过滤处理
├── framework         // 框架核心
│       └── aspectj                       // 注解实现
│       └── config                        // 系统配置
│       └── datasource                    // 数据权限
│       └── interceptor                   // 拦截器
│       └── manager                       // 异步处理
│       └── shiro                         // 权限控制
│       └── util                          // 通用工具
│       └── web                           // 前端控制
├── ruoyi-generator   // 代码生成（可移除）
├── ruoyi-quartz      // 定时任务（可移除）
├── ruoyi-system      // 系统代码
├── ruoyi-admin       // 后台服务
├── ruoyi-xxxxxx      // 其他模块
```

![1606403686809](README.assets/1606403686809.png)



#### 3.2 配置文件

https://doc.ruoyi.vip/ruoyi/document/xmjs.html#%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6



#### 3.3 核心技术

##### 3.3.1 SpringBoot框架

> 1、介绍
> Spring Boot是一款开箱即用框架，提供各种默认配置来简化项目配置。让我们的Spring应用变的更轻量化、更快的入门。 在主程序执行main函数就可以运行。你也可以打包你的应用为jar并通过使用java -jar来运行你的Web应用。它遵循"约定优先于配置"的原则， 使用SpringBoot只需很少的配置，大部分的时候直接使用默认的配置即可。可以与Spring Cloud的微服务无缝结合。
> `Spring Boot2.0 环境要求必须是jdk8或以上版本，Tomcat8或以上版本`
>
> 2、优点
>
> - 使编码变得简单： 推荐使用注解。
> - 使配置变得简单： 自动配置、快速构建项目、快速集成新技术能力 没有冗余代码生成和XML配置的要求
> - 使部署变得简单： 内嵌Tomcat、Jetty、Undertow等web容器，无需以war包形式部署
> - 使监控变得简单： 自带项目监控

##### 3.3.2 Shiro安全控制

> 1、介绍
> Apache Shiro是Java的一个安全框架。Shiro可以帮助我们完成：认证、授权、加密、会话管理、与Web集成、缓存等。其不仅可以用在 JavaSE环境，也可以用在 JavaEE 环境。
>
> 2、优点
>
> - 易于理解的 Java Security API
> - 简单的身份认证，支持多种数据源
> - 对角色的简单的授权，支持细粒度的授权
> - 不跟任何的框架或者容器捆绑，可以独立运行
>
> 3、特性
> `Authentication`身份认证/登录，验证用户是不是拥有相应的身份
> `Authorization`授权，即验证权限，验证某个已认证的用户是否拥有某个权限，即判断用户是否能做事情 `SessionManagement`会话管理，即用户登录后就是一次会话，在没有退出之前，它的所有信息都在会话中
> `Cryptography`加密，保护数据的安全性，如密码加密存储到数据库，而不是明文存储
> `Caching`缓存，比如用户登录后，其用户信息，拥有的角色/权限不必每次去查，提高效率
> `Concurrency`Shiro支持多线程应用的并发验证，即如在一个线程中开启另一个线程，能把权限自动传播过去
> `Testing`提供测试支持
> `RunAs`允许一个用户假装为另一个用户（如果他们允许）的身份进行访问
> `RememberMe`记住我，这是非常常见的功能，即一次登录后，下次再来的话不用登录了
>
> 4、架构
> `Subject`主体，代表了当前的“用户”，这个用户不一定是一个具体的人，与当前应用交互的任何东西都是Subject，如网络爬虫， 机器人等；即一个抽象概念；所有Subject都绑定到SercurityManager，与Subject的所有交互都会委托给SecurityManager；可以把Subject认为是一个门面；SecurityManager才是实际的执行者
> `SecurityManage`安全管理器；即所有与安全有关的操作都会与SecurityManager交互；且它管理着所有Subject； 可以看出它是Shiro的核心，它负责与后边介绍的其他组件进行交互
> `Realm`域，Shiro从Realm获取安全数据（如用户，角色，权限），就是说SecurityManager要验证用户身份， 那么它需要从Realm获取相应的用户进行比较以确定用户身份是否合法；也需要从Realm得到用户相应的角色/权限进行验证用户是否能进行操作；可以有1个或多个Realm，我们一般在应用中都需要实现自己的Realm
> `SessionManager`如果写过Servlet就应该知道Session的概念，Session需要有人去管理它的生命周期，这个组件就是SessionManager
> `SessionDAO`DAO大家都用过，数据库访问对象，用于会话的CRUD，比如我们想把Session保存到数据库，那么可以实现自己的SessionDAO，也可以写入缓存，以提高性能
> `CacheManager`缓存控制器，来管理如用户，角色，权限等的缓存的；因为这些数据基本上很少去改变，放到缓存中后可以提高访问的性能
>
> 应用代码通过Subject来进行认证和授权，而Subject又委托给SecurityManager； 我们需要给Shrio的SecurityManager注入Realm，从而让SecurityManager能得到合法的用户及其权限进行判断，Shiro不提供维护用户/权限，而是通过Realm让开发人员自己注入。
>
> `Shiro不会去维护用户，维护权限；这些需要自己去设计/提供；然后通过响应的接口注入给Shiro即可`

##### 3.3.3 Thymeleaf模板

> 1、介绍
> Thymeleaf是一个用于Web和独立Java环境的模板引擎，能够处理HTML、XML、JavaScript、CSS甚至纯文本。能轻易的与Spring MVC等Web框架进行集成作为Web应用的模板引擎。 与其它模板引擎（比如FreeMaker）相比，Thymeleaf最大的特点是能够直接在浏览器中打开并正确显示模板页面，而不需要启动整个Web应用（更加方便前后端分离，比如方便类似VUE前端设计页面），抛弃JSP吧。 Thymeleaf 3.0是一个完全彻底重构的模板引擎，极大的减少内存占用和提升性能和并发性，避免v2.1版因大量的输出标记的集合产生的资源占用。 Thymeleaf 3.0放弃了大多数面向DOM的处理机制，变成了一个基于事件的模板处理器，它通过处理模板标记或文本并立即生成其输出，甚至在新事件之前响应模板解析器/缓存事件。Thymeleaf是Spring Boot官方的推荐使用模板。
>
> 2、优点
>
> - 国际化支持非常简单
> - 语法简单，功能强大。内置大量常用功能，使用非常方便
> - 可以很好的和Spring集成
> - 静态html嵌入标签属性，浏览器可以直接打开模板文件，便于前后端联调
> - Spring Boot 官方推荐，用户群广



### 4. 查看后台手册

