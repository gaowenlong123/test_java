package Redis;

/**
 *
 * 1： 为了解决高并发，高可扩展，高可用，大数据存储问题而产生的数据库解决方案 ，就是NoSql数据库
 *      NoSql泛指非关系形数据库，主要是为了处理大量数据的高访问负载。
 *             数据模型：一系列键值对
 *             优速：快速查询
 *             劣势：存储的数据缺少结构化
 *
 *      redis ： 他通过提供多种键值数据类型来适应不同场景下的存储需求
 *              字符串类型
 *              散列类型
 *              列表类型
 *              集合类型
 *              有序集合类型
 *
 *     2： redis 安装
 *                  1：在虚拟机上安装Centos
 *                  2：安装C语言的环境 ，安装gcc环境  yum install gcc-c++（centOS自带c语言的编译环境，不需要安装）
 *                  3: 将下载的redis 上传到 服务器
 *                  4：解压Redis源码 tar -zxf redis-3.0.0.tar.gz
 *                  5：编译 redis 源码
 *                                    cd redis-3.0.0
 *                                    make
 *                  6: 安装redis
 *                               make install PREFIX=/user/local/redis
 *                  7: 启动
 *
 * Created by Administrator on 2019/2/15 0015.
 */
public class test {
}
