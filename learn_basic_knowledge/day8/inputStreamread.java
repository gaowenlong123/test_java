package day8;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;

/**
 * Created by Administrator on 2019\1\12 0012.
 */
public class inputStreamread
{

    public static void main(String[] args) throws IOException {

        //创建字节流
        FileInputStream fis = new FileInputStream("C:\\a.txt");

        InputStreamReader isw = new InputStreamReader(fis ,"UTF-8");

        char[] ch =new char[1024];

        //只关最外层的转换流
        int len = isw.read(ch);
        System.out.println(new String(ch , 0 ,len));

        isw.close();
    }
}
