package day2;

/**
 * :StringBuffer和String的区别
 * String是一个不可变的字符序列
 * StringBuffer是一个可变的字符序列

 * Created by Administrator on 2019/1/1 0001.
 */
public class String_buffer
{

    public void say(){
        StringBuffer buffer = new StringBuffer();   //线程安全，速度慢
        StringBuilder builder = new StringBuilder();  //线程不安全  ，速度快
        buffer.append(6).append(false).append('d');   // append 因为返回是 return this

//        buffer.replace();
//        buffer.reverse();
//        buffer.delete();
//        buffer.insert();

        System.out.println(buffer);
    }
}
