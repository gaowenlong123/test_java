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
 *                 -test
 *                        -java    --存放所有测试.java文件，如JUnit测试类
 *                        -resources   --测试资源文件
 *
 *          -target   --目标文件输出位置例如.class、.jar（普通项目）、.war文件(web项目）
 *          -pom.xml     --maven项目核心配置文件
 *
 *
 *
 * 3：
 *         1：下载压缩包，安装到本地，配置环境变量   MAVEN_HOME：安装路径  path ：%MAVEN_HOME%\bin;
 *              在cmd 输入 ：mvn -version 查看版本
 *              修改本地仓库目录 （暂无操作）
 *         2：在cmd中输入：mvn help:system 。 下载帮助系统
 *         3：修改setting.xml 配置文件 。 修改中央仓库
 *         4：配置Maven插件 ： 在idea中 setting 搜索maven 。 把安装目录和配置文件目录配置好
 *
 *
 *
 * Created by Administrator on 2019/2/14 0014.
 */
public class test {
}
