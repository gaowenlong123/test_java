package day8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * 1:特有方法   : mewline()换行  ；  没有返回值
 *
 *
 * windows的换行  \r\n      linux 换行 \n
 *
 * Created by Administrator on 2019\1\12 0012.
 */
public class bufferedWriter {
    public static void main(String[] args) throws IOException {

        FileWriter fw =new FileWriter("C:\\a.txt");
        BufferedWriter bfw = new BufferedWriter(fw);

        bfw.write("aaaa");
        bfw.flush();

        bfw.write(100);
        bfw.newLine();
        bfw.write("哈哈".toCharArray());
        bfw.flush();
        bfw.close();
    }
}
