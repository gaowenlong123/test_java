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
 *
 *
 * Created by Administrator on 2019\1\13 0013.
 */
public class ObjectOutputStream_test implements Serializable {

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
