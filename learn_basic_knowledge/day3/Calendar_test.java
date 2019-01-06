package day3;

import java.util.Calendar;

/**
 *
 * 1: 用来替代 data 类 ，只能使用子类，为了兼容各个语言
 *
 *
 * Created by Administrator on 2019\1\6 0006.
 */
public class Calendar_test {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        calendar.set(calendar.MONTH ,12);

        calendar.set(2020,1,1);   //设置年月日

        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
        int month = calendar.get(Calendar.MONTH);
        System.out.println(month);

    }
}
