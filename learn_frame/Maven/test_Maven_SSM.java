package Maven;

/**
 *
 * 1：项目工程目录 ：
 *                  父工程
 *                          -dao模块
 *                          -manager模块
 *                          -model模块
 *                          -service模块
 *                          -api模块
 *                          父工程.xml
 *                          pom.xml
 *
 * 2: 步骤
 *          1：更改IDEA-maven的用户配置文件
 *          2：创建一个空项目  Empty-project
 *          3：创建父项目     创建maven-model：jdk1.8 ，Tomcat8.5，mysql 5.7，SSM（4.X，3.X）
 *                              不选择Create from archetype
 *                              组ID com.公司名字.项目名字       AID：父工程名字 common-parent
 *                              在父工程pom.xml设置<packaging>pom</>    删除src文件夹
 *          4：创建model子工程
 *                             选择父工程 ，new一个model。 在maven中选中Create from archetype
 *                             选择 quickstart(普通的jar包)  。 Aid：输入项目名称model
 *                             选择用户配置文件(需要在第一步进行配置）
 *                             在选择路径的时候， 把模块名加斜杠，放在父工程路径下
 *                              在pom.xml设置<packaging>jar</>
 *          5：创建dao子工程
 *                            同上
 *          6：创建service子工程
 *
 *          7：创建manager后台管理
 *                              选择父工程 ，new一个model。 在maven中选中Create from archetype
 *                             选择 webapp    。 Aid：输入项目名称manager
 *                             选择用户配置文件(需要在第一步进行配置）
 *                              在选择路径的时候， 把模块名加斜杠，放在父工程路径下
 *                              在pom.xml设置<packaging>war</>  （注意API模块也是web项目）
 *          8：在parent中抽取公共的依赖
 *                                 将子工程的重复的依赖 ，放入父工程 ，创建一个公共的版本号管理
 *
 *          9：manager中先集成SpringMVC
 *                                  在pom.xml 添加spring/springMVC的依赖
 *                                  aop , aspects , beans ,context ,core , expression ,orm ,tx,test.txt,web ,webmvc
 *                                  但是版本号看成一个变量 ，定义在父工程的pom.xml文件中
 *          10：Tomcat跑工程
 *                                  配置本地tomcat
 *
 *          11：添加SpringMVC配置文件
 *                                  在manager模块中新建resource包 ，导入springmvc.xml 的配置文件
 *                                  修改xml的约束 ，版本N.N（点击确定可以访问）

 *          12：在web.xml中加载SpringMVC
 *                                  在web.xml 配置spring的拦截请求设置
 *
 *          13：更改web.xml为3.0
 *                              修改web.xml的约束 为3.0
 *
 *          14：dao 整合mybatis ：
 *                              先添加依赖 model 。
 *                             添加mybatis依赖 ，还是父工程管理版本号
 *                             添加mapper公共接口 ，
 *                             添加usermapper.java和xml
 *
 *          15：servie依赖dao
 *                             先依赖dao ，再添加spring的依赖beans ，context，tx（需要自动注入）
 *                             写BaseService的接口   ， 而且还是一个泛型
 *                             写实现BaseService接口的抽象类 （在这里放，所有的dao方法 ，并且需要@自动注入）
 *                             写具体业务的接口（特有的方法），继承上面的抽象类
 *                             然后写具体业务的接口的实现类：继承上面的抽象方法 ，还要实现具体接口的实现类 （需要@service，Transactioncal）
 *
 *          16：manager依赖service
 *                              导入service模型的依赖
 *                              在Controller中，自动注入service方法 。就可以直接用过service里面的方法
 *                              去除自动检查bean是否存在 。因为bean是通过扫描后生产的，不去也行

 *          17：manager添加其他依赖
 *                              添加 数据库驱动，mybatis-spring的整合包 ，数据库连接池 ，jstl标签 ，日志输出 ，动态代理
 *                              把版本号，放在父工程中
 *
 *          18: manager的其他配置文件
 *                              新建resource文件 ，添加 application.xml ，db ，log4j ，mybatis ，springMVC
 *
 *          19: wen.xml加载application.xml配置文件
 *                                  配置spring
 *
 *          20: 在dao打包时要在pom中配置
 *                                  进行配置插件 ，要不然进行打包的时候，不会把mapper.xml不会进入jar包中
 *                                  在dao模块的pom,xml 中配置 xml可以打包
 *                                  （配置这个，直接看第八课）
 *          21: 去除mybatis配置文件
 *                                  将mybatis的包配置在application.xml中
 *
 *          22:整合页面
 *                              导入模板 ：html改成jsp 。 样式和js的路径更换成${pagecontext.}
 *                              在manager模块 ，导入jap servlet-api 依赖
 *                              改springMVC的前后缀文件 路径（？？）
 *                              调整页面的表单的请求
 *
 *          23:抽取控制器的基类
 *
 *          24:mybatis 逆向工程
 *
 *          25:把项目上传git
 *
 * Created by Administrator on 2019/2/14 0014.
 */
public class test_Maven_SSM {
}
