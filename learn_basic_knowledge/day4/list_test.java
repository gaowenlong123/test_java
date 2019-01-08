package day4;

import java.util.ArrayList;

/**
 * 1 ； 有序 索引 可以重复元素
 *
 * 1: 使用迭代器    报 并发修改异常时 ，需要注意 迭代的时候不能修改集合长度
 *
 *2： 堆栈 先进后出     队列 先进先出     数组 查找快，删除慢      链表  删除快，查找慢 （ 通过几个节点连接起来 ， 一个节点记住下一个节点的地址
 *
 *
 *
 * arraylist 就是一个可变的数组
 *
 *
 * Created by Administrator on 2019\1\8 0008.
 */
public class list_test {

    public static void main(String[] args) {

        ArrayList<String> arr = new ArrayList<String>();

        arr.add("11");
        arr.add("bbb");


        arr.add(1,"dd");
        arr.remove(0);

        arr.set(2,"ss");

    }
}
