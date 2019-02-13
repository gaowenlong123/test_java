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
 * 3： mybatis的缓存理解  ： 包括一级缓存和二级缓存 。 一级缓存是默认使用的 ， 二级缓存需要手动开启
 *
 *                  1：一级缓存是指sqlsession ，中能够有一个数据区域 ，是map结构
 *                    当第一查询时，会将数据存在该区域 ，当执行任何修改，添加，删除的commit的时候，就会清除缓存。当再次查询时，就会再次执行sql语句
 *                                                     如果没有执行上述操作，当再次查询时，就会查询缓存
 *
 *                  2：二级缓存是指同一个namespace下的 mapper ，多个sqlsession共享缓存 。
 *                              一个sqlsession执行查询并把会话关闭，才可以将数据存入二级缓存中。
 *                              其他sqlsession再执行查询操作时，会自动读取数据。
 *                              如果某个会话执行mapper 提交（插入 ， 更新 ，删除）操作，就会清空二级缓存
 *
 *                          1：在全局的xml，开启二级缓存 。 在想要二级缓存的具体mapper中 再配置开启
 *                          2: 插入 ， 更新 ，删除等操作 可以清除二级缓存，也可以设置禁止
 *                             当然查询语句有存储和清除缓存的选项， select默认清除缓存为False ，但是也可以人为设置为true
 *                             flushCache ：是否清除二级缓存
 *                             useCache   ：是否存储二级缓存
 *
 *                  3： 想要整合mybatis的二级缓存  ，实现Cache的接口就行 。mybatis自己的支持不太好，就需要第三方 Ehcache 支持
 *
 *                  4： 需要引入 Ehcache 分布式的缓存框架 。 因为mybatis只是一个持久层框架
 *                      而系统为了提高性能，会采用分布式部署，使用缓存框架redis 。这里只是简单的配置Ehcache
 *
 *                      （集群部署方式 ：很多服务器，每个服务器跑同样的项目，操作的数据库是一样的，
 *                                         这样产生的缓存，可以进行集中处理即redis集群 。 ）
 *
 *                  5：应用场景 ： 对于访问响应速度要求高，但是实时性不高的查询，可以采用二级缓存技术
 *                                   （注意使用二级缓存技术 ，需要设置一下flashInterval刷新间隔来定时刷新二级缓存 ）
 *                                 局限性：对细粒度的缓存，实现不好
 *
 */
public class test {
}
