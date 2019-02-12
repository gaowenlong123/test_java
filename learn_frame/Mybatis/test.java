package Mybatis;

/**
 *
 * 1： 通过xml  或者注解的方式 将要执行的各种对象配置起来 ，
 * 并通过java对象和statement中的sql进行映射生成最终执行的sql语句，
 * 最后由mybatis框架执行sql 并将结果映射成java对象并返回 。
 *
 * 2：核心
 *           1： mybatis 配置文件，包括mybatis全局配置文件 和 mybatis 映射文件
 *           2： mybatis读取配置文件 构造出  sqlSessionFactory
 *           3： 通过 ，可以创建SqlSession 即会话。 mybatis是通过SqlSession来操作数据库的
 *           4： sqlSeesion本身不能直接操作数据库 ， 它是通过底层的Executor 执行器接口来操作数据库的。
 *                  Executor 接口有两个实现类 ，一个是普通执行器 ，一个是缓存执行器（默认）
 *           5： Executor 执行器要处理的SQL信息封装到一个底层对象 MappedStatement中。该对象包括：SQL语句
 *                 输入参数映射 ， 输出结果集映射信息。
 *                 其中输入参数和输出结果的映射类型包括 java的简单类型 ，hashmap集合对象 ，pojo对象类型
 *
 *
 * Created by Administrator on 2019/2/12 0012.
 */
public class test {
}
