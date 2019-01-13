package day9;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * 1: 对象的序列化   就是将对像的数据写到文件中
 *
 *
 * 2: 静态成员变量不能序列化  ， 因为静态数据属于类的，不属于对象 ， 是对象的共享数据。
 *
 * 3 ： private transient int a ；   阻止成员变量序列化  ，transient只有这一种用法
 *
 * 4： Serializable  标记性接口
 *
 * 5：序列号：当修改类文件，会自动修改序列号，从而使对象的反序列化失败
 * 需要自己定义一个序列号，让他们调用
 *
 *
 * Created by Administrator on 2019\1\13 0013.
 */
public class ObjectOutputStream_test implements Serializable {

    static final long serialVersionUID = 100L;   //等号之前不能改，之后无所谓

    public static void main(String[] args) throws IOException ,ClassNotFoundException {

        FileOutputStream fos = new FileOutputStream("C:\\a.txt");

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        ObjectOutputStream_test bt =new ObjectOutputStream_test();

        oos.writeObject(bt);
        oos.close();



        //读对象
        FileInputStream fis = new FileInputStream("C:\\a.txt");  //需要抛类找不到异常  ，反序列化需要有类文件

        ObjectInputStream ois = new ObjectInputStream(fis);



         Object o = ois.readObject();
         ois.close();
    }
}
