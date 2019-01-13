package day9;

import java.io.*;

/**
 *
 * 1： 打印流
 *
 *         2: 自动刷新
 *              1：输出的数据目的必须是流对象  outputStream  ， writer
 *              2：必须调用 println ， printf ， format ，这三个其中的一个方法
 *
 *3: 打印流复制文本文件 比较 buffererwriter  代码少
 *
 *
 * Created by Administrator on 2019\1\14 0014.
 */
public class printStream {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\a.txt");

        PrintWriter pw = new PrintWriter(file);

        pw.println(100);
        pw.flush();
        pw.close();


        //

        FileOutputStream fos = new FileOutputStream("C:\\a.txt");
        PrintWriter pw1 = new PrintWriter(fos);


    }
}
