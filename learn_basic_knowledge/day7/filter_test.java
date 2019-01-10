package day7;

import java.io.File;

/**
 * 1:
 *
 *
 * Created by Administrator on 2019\1\10 0010.
 */
public class filter_test
{

    public static void main(String[] args) {

        File file = new File("C:\\a");

        File[] filter = file.listFiles(new filefilter_test());
    }
}
