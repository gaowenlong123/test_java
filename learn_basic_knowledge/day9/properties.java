package day9;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * 1：hashtable 的子类，实现map接口 ，  不能使用泛型 ，键值都是字符串
 *
 *  可以和IO对象结合使用，实现数据的持久存储
 *
 *2: load()  传递任意的字节 字符流
 * load（inputStream is）
 * load（reader r）
 *
 *
 *
 * Created by Administrator on 2019\1\13 0013.
 */
public class properties {

    public static void main(String[] args) {

        Properties pro = new Properties();
        pro.setProperty("a","b");


        String value = pro.getProperty("a");

    }

    public static void load_test() throws IOException{
        Properties p = new Properties();
        FileReader fr  = new FileReader("C:\\a.properties");

        p.load(fr);  //取出文件中的所有数据 ，
        fr.close();

        //store
        Properties p1 = new Properties();
        p.setProperty("name"  ,"aaa");
        FileWriter fw  = new FileWriter("C:\\a.properties");

        p1.store(fw ,"reason");  //不要写中文

        p.load(fr);  //取出文件中的所有数据 ，
        fr.close();

    }

}
