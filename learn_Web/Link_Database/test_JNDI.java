package Link_Database;

/**
 *
 * 1： 所以的J2ee 的容器 都必须提供一个JNDI的服务
 *
 * 2： 配置步骤 ：
 *              1：在lib文件中导入 beanutils / logging
 *              2：把mysql连接数据库的jar包放在 tomcat  lib目录下
 *              3：需要先在生成 META文件 ，配置Context.xml文件  ， 给数据源配置别名
 *
 * 3： 通过JNDI 获取数据源  ，然后再调用 tomcat 自带的 jdbc
 *
 * 4： 想访问多个数据库 ，就配置多个数据源
 *
 * Created by Administrator on 2019/2/7 0007.
 */
public class test_JNDI {
}
