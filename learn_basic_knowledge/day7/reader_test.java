package day7;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * 1: 只能读取文本文件
 *
 * Created by Administrator on 2019\1\12 0012.
 */
public class reader_test {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("C:\\a.txt");

        int len =0;
        while ((len = fr.read())!=-1){
            System.out.println((char)len);
        }

        int len1=0;
        char[] ch =  new char[1024];
        while ((len = fr.read(ch))!=-1){
            System.out.println(new String(ch ,0,len));
        }

        fr.close();
    }
}
