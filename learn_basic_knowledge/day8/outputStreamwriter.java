package day8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * 1 ：将字节流转换成字符流
 *
 *
 *
 * Created by Administrator on 2019\1\12 0012.
 */
public class outputStreamwriter {

    public static void main(String[] args) throws IOException{

        //创建字节流
        FileOutputStream fos = new FileOutputStream("C:\\a.txt");

        OutputStreamWriter osw = new OutputStreamWriter(fos ,"UTF-8");

        osw.write("aaaaa");

        //只关最外层的转换流
        osw.close();

    }
}
