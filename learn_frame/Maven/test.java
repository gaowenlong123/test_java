package Maven;

/**
 *
 * 1: 是基于项目对象模型 。 方便jra包管理 。
 *       maven仓库 是用来存放网上下载到本地的jar包。仓库的默认路径在C盘
 *
 * 2：项目结构 ：
 *      projectName
 *          -src
 *                 -main
 *                        -java    --存放项目的.java文件
 *                        -resources    --存放项目资源文件，如spring, hibernate配置文件
 *                 -test.txt
 *                        -java    --存放所有测试.java文件，如JUnit测试类
 *                        -resources   --测试资源文件
 *
 *          -target   --目标文件输出位置例如.class、.jar（普通项目）、.war文件(web项目）
 *          -pom.xml     --maven项目核心配置文件
 *
 *
 *
 * 3：本地安装Maven
 *
 *         1：下载压缩包，安装到本地，配置环境变量   MAVEN_HOME：安装路径  path ：%MAVEN_HOME%\bin;
 *              在cmd 输入 ：mvn -version 查看版本
 *              修改本地仓库目录 （暂无操作）
 *         2：在cmd中输入：mvn help:system 。 下载帮助系统
 *         3：修改setting.xml 配置文件 。 修改中央仓库
 *         4：配置Maven插件 ： 在idea中 setting 搜索maven 。 把安装目录和配置文件目录配置好
 *
 *4：Maven指令
 *          mvn compile  ：把java文件编译成class文件 ， 执行完生成target目录，该目录中存放了编译后的字节码文件
 *          mvn clean  ： 将target目录删除
 *          mvn test.txt  ： 完成单元测试操作 ， 执行完会在target目录中生成三个文件夹：
 *                          surefire ，surefire-reports（测试报告） ， test.txt-classes（测试的字节码文件）
 *          mvn package ： 打包操作。 当项目打成jar包
 *          mvn install ： 将打好的jar包安装到本地仓库的操作。执行完毕后，会在本地仓库中出现安装后的jar包，方便其他工程引用。
 *
 *
 * 5：pom.xml
 *             GAV : 在maven中坐标就是为了定位一个唯一确定的jar包 。
 *                        groupId ：定义当前maven组织名称
 *                        artifactId：定义实际项目名称
 *                        version ： 定义当前项目的当前版本
 *                                   https://mvnrepository.com/   用来查找所需要的jar包版本号
 *                        scope ： 依赖的范围
 *                                  compile :(默认依赖范围) 对于编译，测试，运行三种classpath都有效
 *                                  test.txt : 只有测试有效
 *                                  provided: 对编译，测试有效，运行无效
 *                                  runtime: 只在运行时有效
 *
 *                        optional ：可选依赖。如果设置为true ，则依赖不可以传递。反之则可以
 *
 *                        exclusions： 排除依赖
 *
 *
 *              直接依赖和间接依赖
 *                          当第二依赖是compile的时候，依赖可以传递
 *                         当第二依赖是test的时候，依赖不可以传递
 *
 *              就近依赖
 *                       如果有三个项目，第一，第二个项目的依赖项目名相同，但是版本号不同 ，
 *                       那么第三个项目就会依赖最近的一个
 *
 *
 * 6：maven的生命周期
 *
 *
 *7： 父工程 一般不写代码 ，统一管理依赖（相同的依赖）和版本号（所有的版本号）
 *
 * 8：聚合： 是一个工程拆分成多个模块开发，每个模块是一个独立的工程 ，
 *           但是要是运行时必须把所有模块聚合到一起才是一个完整的工程。
 *
 *
 * 9： 把仓库打包一份，用的时候就复制替换一下
 *
 *
 */
public class test {
}
