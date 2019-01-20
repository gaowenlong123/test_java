package day15;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * 1： IP地址类
 *
 * 不能new，只有静态方法获取对象
 *
 * Created by Administrator on 2019\1\19 0019.
 */
public class InetAddress_test {

    public static void main(String[] args) throws UnknownHostException{

        //1
        InetAddress inet = InetAddress.getLocalHost();
        System.out.println(inet);//GMFRF98Y4YMH8OE/192.168.56.1



        System.out.println(inet.getHostAddress());//192.168.56.1
        System.out.println(inet.getHostName());//GMFRF98Y4YMH8OE




        //2 根据主机名，找其他人的ip地址对象。根据ip地址找ip地址对象。但是ip不会重复
        InetAddress inet1 = InetAddress.getByName("www.baidu.com");
        System.out.println(inet1);


    }
}
