package day7;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * 1 :
 * Created by Administrator on 2019\1\10 0010.
 */
public class filefilter_test implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        //调用者走这里

//        return true;
        return pathname.getName().endsWith(".java");
    }

}
