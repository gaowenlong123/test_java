package day7;

import java.io.File;
import java.io.IOException;

import static java.lang.System.out;
/**
 * Created by Administrator on 2019\1\10 0010.
 */
public class file_test
{
    public static void main(String[] args) throws IOException {

        //默认系统分割符
        String s = File.pathSeparator;
        out.println(s);

        //默认目录分隔符
        String s1 = File.separator;          //  ===>  /



        //构造器   只将路径变成对象
        File file = new File("D:\\a");
        out.println(file);


        //2
        File file1 = new File("c:" ,"a");


        //3
        File father = new File("c:");
        File file2 = new File(father , "a");


        fun1();

    }

    public static void fun1() throws IOException{
        //创建文件
        File file3 = new File("C:\\a.txt");
        boolean b = file3.createNewFile();
        out.println(b);


        File file4 = new File("C:\\aaa");
        boolean b1  = file4.mkdir();


        boolean b3  = file4.delete();

        String name = file4.getName();// 获取最后部分的名字

        long l = file4.length();  //文件字节

        String path = file4.getAbsolutePath(); // 获取绝对路径
        File file = file4.getAbsoluteFile();   //同上，只是对象不同

        file4.getParent();
        file4.getParentFile().getParentFile().getParentFile(); //方法返回值 可以调用方法

        boolean b2 = file4.exists();
        boolean b6 = file4.isDirectory();

        String[] strArr = file.list();  // 输出该文件夹中的所有文件
        File[] fileArr = file.listFiles();  // 输出该文件夹中的所有文件

        File file5 = new File("C:\\aaa\\bb\\cc");
        boolean b7  = file5.mkdirs();
    }
}
