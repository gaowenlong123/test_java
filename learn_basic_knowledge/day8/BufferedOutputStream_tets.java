package day8;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * 1: 字节输出缓冲流
 *
 *
 * 1:从程序 写到 jvm中 ，存到一定数量再写入文件中
 *
 *
 * Created by Administrator on 2019\1\12 0012.
 */
public class BufferedOutputStream_tets {

    public static void main(String[] args) throws IOException {

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\a.txt"));

        bos.write(55);

        byte[] bytes = "hhhh".getBytes();

        bos.write(bytes);

        bos.close();

    }
}
