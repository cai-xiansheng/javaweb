# JavaWeb

## 什么是JavaWeb

1. JavaWeb是指所有通过java语言编写可以通过浏览器访问的程序的总称，叫JavaWeb
2. JavaWeb是基于请求和响应来开发的

## 什么是请求

请求是指客户端给服务器发送数据，叫请求Request。 

## 什么是响应

响应是指服务器给客户端回传数据，叫响应Response。

## 请求和响应的关系

请求和响应式成对出现的，有请求就有响应。

# Web资源的分类

> Web资源按实现的技术和呈现的效果的不同，又分为静态资源和动态资源两种。
>
> 静态资源：html，css，js，txt，mp4视频，jpg图片
>
> 动态资源：jsp页面，Servlet程序

# 常用的Web服务器

 **Tomcat**：由 Apache 组织提供的一种 Web 服务器，提供对 jsp 和 Servlet 的支持。它是一种轻量级的 javaWeb 容器（服务 器），也是当前应用最广的 JavaWeb 服务器（免费）。

 **Jboss**：是一个遵从 JavaEE 规范的、开放源代码的、纯 Java 的 EJB 服务器，它支持所有的 JavaEE 规范（免费）。 

**GlassFish**： 由 Oracle 公司开发的一款 JavaWeb 服务器，是一款强健的商业服务器，达到产品级质量（应用很少）。 

**Resin**：是 CAUCHO 公司的产品，是一个非常流行的服务器，对 servlet 和 JSP 提供了良好的支持， 性能也比较优良，resin 自身采用 JAVA 语言开发（收费，应用比较多）。 

**WebLogic**：是 Oracle 公司的产品，是目前应用最广泛的 Web 服务器（收费服务器中最广泛），支持 JavaEE 规范， 而且不断的完善以适应新的开发要求，适合大型项目（收费，用的不多，适合大公司）。 

# Tomcat的使用

## 安装

找到需要用的Tomcat版本对应的zip压缩包，解压到需要安装的目录即可

## 目录介绍

| 目录    | 功能                                                         |
| ------- | ------------------------------------------------------------ |
| bin     | 专门用来存放Tomcat服务器的可执行程序                         |
| conf    | 专门用来存放Tomcat服务器的配置文件                           |
| lib     | 专门用来存放Tomcat服务器的jar包                              |
| logs    | 专门用来存放Tomcat服务器运行时输出的日记信息                 |
| temp    | 专门用来存放Tomcat服务器运行时产生的临时数据                 |
| webapps | 专门用来存放部署的Web工程                                    |
| work    | 是Tomcat工作时的目录，用来存放Tomcat运行时jsp翻译为Servelet的源码，和Session钝化的 目录 |

+ 钝化：序列化

## 如何启动Tomcat服务器

找到Tomcat目录下的bin目录下的startup.bat文件，双击，就可以启动Tomcat服务器。



### 如何测试Tomcat服务器启动成功

`startup.bat文件不要关`

> 访问本地的8080端口

打开浏览器，在浏览器地址栏中输入一下地址测试：

1. http://localhost:8080
2. http://127.0.0.1:8080
3. http://真实ip:8080

### 常见启动失败的情况

 双击 startup.bat 文件，就会出现一个小黑窗口一闪而来。 这个时候，失败的原因基本上都是因为没有配置好 JAVA_HOME 环境变量。 

JAVA_HOME配置：

+ `JAVA_HOME:C:jdk文件路径`

常见的JAVA_HOME配置错误有一下几种情况：

+ JAVA_HOME必须全部大写
+ JAVA_HOME中间必须是下划线，不是减号
+ JAVA_HOME配置的路径只需要配置到JDK的安装目录即可，不需要带上bin目录

### 另一种启动Tomcat服务器的方式

1. 打开cmd
2. cd到Tomcat的bin目录下
3. `catalina run`

## Tomcat的停止

1. 点击tomcat服务器窗口的关闭按钮
2. 在Tomcat服务器窗口置为当前窗口，Ctrl+c
3. 找到Tomcat的bin目录下的shutdown.bat双击，就可以停止Tomcat服务器

## 如何修改Tomcat的端口号

>  Tomcat的默认端口为8080

+ 找到Tomcat目录下的conf目录，找到server.xml配置文件。

![image-20200812122538376](Tomcat.assets\image-20200812122538376.png)

HTTP协议的默认端口为80端口，80会在地址导航栏会被抹掉

## 如何部署web工程到Tomcat中

###  第一种部署方法：

只需要把 web 工程的目录拷贝到 Tomcat 的 webapps 目录下 即可。 

如何访问Tomcat下的web工程：

+ 只需要在浏览器中输入访问地址格式如下：`http://ip:port/工程名/目录下/文件名`

### 第二种部署方法：

找到Tomcat下的conf目录/Catalina/loaclhost/下创建如下配置文件

```xml
<!--Context表示工程上下文
	path表示工程的访问路径：/abc
	docBase表示你的工程目录
-->
<Context path="/web03" docBase="E/" />
```

##  手托 html 页面到浏览器和在浏览器中输入 http://ip:端 口号/工程名/访问的区别 

![image-20200812125338311](Tomcat.assets\image-20200812125338311.png)

## ROOT的工程的访问，以及默认index.html页面的访问

当我们在浏览器地址栏中输入访问地址如下：

http://ip:port/	===> 没有工程名的时候，默认访问的是**ROOT**工程

当我们在浏览器地址栏中输入的访问地址如下：

http://ip:port/工程名/	===>	没有资源名，默认访问**index.html**文件

# IDEA整合Tomcat服务器

File | Settings | Build, Execution, Deployment | Application Servers

![image-20200812134021683](Tomcat.assets\image-20200812134021683.png)

选择相应的版本即可

![image-20200812134428761](Tomcat.assets\image-20200812134428761.png)

![image-20200812134438443](Tomcat.assets\image-20200812134438443.png)

# IDEA中动态web工程的操作

## IDEA中如何创建动态web工程

1. 创建一个新的模块：

![image-20200812134613847](Tomcat.assets\image-20200812134613847.png)

2. 选择你要创建什么类型的模块

![image-20200812134644311](Tomcat.assets\image-20200812134644311.png)

3. 输入模块名，点击finish完成创建

## Web工程的目录介绍

![image-20200812135041698](Tomcat.assets\image-20200812135041698.png)

## 如何给Web工程添加第三方的jar包

1. 可以打开项目结构菜单操作界面，添加一个自己的类库： 

![image-20200812140003789](Tomcat.assets\image-20200812140003789.png)

2.  添加你你类库需要的 jar 包文件。 

![image-20200812140051024](Tomcat.assets\image-20200812140051024.png)

3.  选择你添加的类库，给哪个模块使用： 

![image-20200812140118126](Tomcat.assets\image-20200812140118126.png)

4. 选择 Artifacts 选项，将类库，添加到打包部署中： 

![image-20200812140252519](Tomcat.assets\image-20200812140252519.png)

## 如何在IDEA中部署工程到Tomcat上运行

1. 建议修改web工程对应的Tomcat运行实例的名称

![image-20200812141013357](Tomcat.assets\image-20200812141013357.png)

2.  确认你的 Tomcat 实例中有你要部署运行的 web 工程模块： 

![image-20200812141338680](Tomcat.assets\image-20200812141338680.png)

3. 还可以修改你的Tomcat实例启动后默认的访问地址

![image-20200812141535938](Tomcat.assets\image-20200812141535938.png)

## 配置资源热部署

![image-20200812143446144](Tomcat.assets\image-20200812143446144.png)

# 

