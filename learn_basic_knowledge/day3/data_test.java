package day3;



/**
 *
 * 
 * Created by Administrator on 2019\1\6 0006.
 */
import java.text.SimpleDateFormat;
import java.util.Date;
public class data_test {
    public static void main(String[] args) throws Exception {

        long time = System.currentTimeMillis();   //当前时间的毫秒值
        System.out.println(time);

        func();
        DateForm();
        DateDuiXiang();
    }

    public static void func(){
//        Data date = new Date();  构造方法过时了吗？
//        System.out.println(date);

    }

    public static void DateForm(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH点mm分钟ss秒");
        String date = sdf.format(new Date());
        System.out.println(date);
    }

    public static void DateDuiXiang() throws Exception{     //生成字符串对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("1993-12-01");
        System.out.println(date);
    }


    public static void Calendar(){

    }
}
