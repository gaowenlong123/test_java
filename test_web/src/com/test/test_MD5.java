package com.test;

import com.cxf.utils.MD5Utils;
import org.junit.Test;

/**
 * 1：
 *
 * Created by Administrator on 2019/2/8 0008.
 */
public class test_MD5 {
    @Test
    public void test1(){

        String s ="123456";
        String ms = MD5Utils.md5(s);
        System.out.println(ms);
    }
}
