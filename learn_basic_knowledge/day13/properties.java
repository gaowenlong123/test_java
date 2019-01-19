package day13;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * 1： properties配置文件
 *
 *  建议放在src下，更好的是放在服务器上   ， 不支持中文需要Unicode转码 ，
 *
 * Created by Administrator on 2019\1\19 0019.
 */
public class properties {

    public static void main(String[] args) throws Exception {
        //加载文件 ， IO读取到集合中

//        FileInputStream fis = new FileInputStream("datebase.properties");
//
        //上面读不到，使用  类的加载器  来读,在类的bin目录下找文件.  自动减src下面的properties文件复制一份到自己bin文件下
        InputStream in =properties.class.getClassLoader().getResourceAsStream("datebase.properties");
        System.out.println(in);
        Properties p =new Properties();
        p.load(in);
        System.out.println(p);

        String diver = p.getProperty("dirverClass");
        System.out.println(diver);

        //下面就是连接数据库

    }
}
