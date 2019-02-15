package Nginx;

/**
 *
 *
 * 1：Ngix是一个高性能的HTTP和反向代理服务器  。 内存占用少并发能力强
 *
 *    （1） 一个tomcat只能并发一千到两千 ， 增加tomcat服务器可以提高并发 ，但是请求应该走哪个tomcat？？
 *          请求
 *          请求   -----   Linux Tomcat
 *          请求
 *                         Linux Tomcat
 *                         Linux Tomcat
 *
 *    （2）所以需要代理来接收请求，然后分发给tomcat
 *
 *          请求                               Linux Tomcat
 *          请求   -----  Ngix(代理）  -----   Linux Tomcat
 *          请求                               Linux Tomcat
 *
 *    （3） 自动分流机制 ，实现高并发

    2： 安装配置Nginx
            在配置文件中，添加ip地址。然后配置在变量里
            注意还要配置集群里面公用的sessionID
 *
 * Created by Administrator on 2019/2/15 0015.
 */
public class test {
}
