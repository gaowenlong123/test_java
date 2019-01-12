package day8;

import java.io.*;

/**
 *
 * 1：
 *
 * Created by Administrator on 2019\1\12 0012.
 */
public class bufferedInputStream {

    public static void main(String[] args) throws IOException {

        BufferedInputStream bos = new BufferedInputStream(new FileInputStream("C:\\a.txt"));



        byte[] bytes = new byte[10];
        int len = 0;

        while ((len = bos.read(bytes))!=-1){
            System.out.print(new String(bytes ,0,len));
        }


        bos.close();

    }


    public static void  copy(){

        BufferedInputStream bis =null ;
        BufferedOutputStream bos =null ;

        try {
            bis = new BufferedInputStream(new FileInputStream("C:\\a.txt"));
            bos = new BufferedOutputStream(new FileOutputStream("C:\\a.txt"));

            byte[] bytes = new byte[1024];
            int len = 0;

            while ((len = bis.read(bytes))!=-1){
                bos.write(bytes ,0,len);
            }


        }catch (IOException ex){

        }


    }
}
