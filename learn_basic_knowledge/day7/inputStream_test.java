package day7;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *  1 ： 执行一次，就会自动读取下面的字节
 *
 *  返回值是读取到的字节 ，读取到结尾返回 -1
 *
 * Created by Administrator on 2019\1\12 0012.
 */
public class inputStream_test {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("C:\\a.txt");

        int i = fis.read();

        fis.close();

        int len =0;
        while ( (len = fis.read()) != -1){

            System.out.println(len);

        }

    }

    public static void copy(){

        FileInputStream fis =null;
        FileOutputStream fos = null;

        try {

            fis = new FileInputStream("C:\\a.txt");
            fos = new FileOutputStream("F:\\a.txt");

            int len =0;
            byte[] b = new byte[1024*5];

            while ((len = fis.read(b)) !=-1){
                fos.write(b,0,len);
            }

        }catch (IOException ex){
            System.out.println(ex.getMessage());

        }finally {
            try {
                fos.close();
            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }finally {
                try {
                    fis.close();
                }catch (IOException ex){
                    System.out.println(ex.getMessage());
                }

            }

        }

    }


    public void test() throws IOException{
        FileInputStream fis = new FileInputStream("C:\\a.txt");

        //创建数字集合
        byte[] b = new byte[2];
        int len = fis.read(b);  //读数组大小的字节，装进数组中

        System.out.println(new String(b));  //输出文件中的两个字符
        System.out.println(len);



        //优化
        byte[] b1 =new byte[2];
        int len1 =  0;

        while ((len = fis.read(b)) !=-1){
            System.out.println(new String(b));
        }
        fis.close();
    }
}
