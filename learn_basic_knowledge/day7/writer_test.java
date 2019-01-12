package day7;

import java.io.*;

/**
 *
 * 1: 只能写字符流的类  即文本
 *
 * 2;还要执行刷新功能
 *
 * Created by Administrator on 2019\1\12 0012.
 */
public class writer_test {

    public static void main(String[] args) throws IOException {

        FileWriter fw =new FileWriter("C:\\a.txt");
        fw.write(100);
        fw.flush();

        //写入字符数组
        char[] c = {'a','c','v'};
        fw.write(c);
        fw.flush();

        //写入部分字符串
        fw.write(c,2,2);
        fw.flush();

        //写字符串
        String s ="aaa";
        fw.write(s);

        fw.close();

    }

    public static void copy1(){

        FileReader fr =null;
        FileWriter fw = null;

        try {

            fr = new FileReader("C:\\a.txt");
            fw = new FileWriter("F:\\a.txt");

            int len =0;
            char[] c = new char[1024];

            while ((len = fr.read(c)) !=-1){
                fw.write(c,0,len);
                fw.flush();
            }

        }catch (IOException ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException("读写数据失败");
        }finally {
            try {
                if (fw!=null)
                    fw.close();
            }catch (IOException ex){
                System.out.println(ex.getMessage());
                throw new RuntimeException("读写数据");
            }finally {
                try {
                    if(fr !=null)
                        fr.close();
                }catch (IOException ex){
                    System.out.println(ex.getMessage());
                    throw new RuntimeException("读写数据失");
                }

            }

        }

    }
}
