package day7;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 1：从java写到文件中  ，都是写的方法
 *
 * write（int b） 写入一个字节
 * write（byte[] b） 写入字节数组
 * write（byte []  b ,int ,int ）  写入字节数组  ，第一个是索引 ，第二个是多少个
 *
 * close（）
 *
 *
 *2：操作一个字节 ，可以操作任意的文件
 *
 *
 * 3： 使用父类方法  ，调用子类对象 ，在子类的构造方法中绑定数据源
 *
 *
 * Created by Administrator on 2019\1\12 0012.
 */
public class outputStream_test {

    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("C:\\a.txt" ,true);  //续写功能

        fos.write(100);  ///在文件中根据数字转成ASCII编码

        byte[] bytes = {65,66,67,68};
        fos.write(bytes);
        fos.write(bytes , 1,2);

        fos.write("hahah".getBytes());

        fos.close();

    }

    public void test(){

        FileOutputStream fos = null;

        try {
           fos= new FileOutputStream("C:\\a.txt");
        }catch (IOException ex){
//            ex.printStackTrace();
            System.out.println(ex.getMessage());       //抛出消息
            throw new RuntimeException("文件输入异常，请重试");  //停下程序
        }finally {

            try {

                if (fos!=null)  //文件对象没有建立成功，就不用关闭资源
                    fos.close();

            }catch (IOException ex){
                throw new RuntimeException("释放系统资源，失败");  //停下程序
            }

        }
    }

}
