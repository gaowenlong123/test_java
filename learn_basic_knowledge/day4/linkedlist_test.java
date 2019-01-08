package day4;

import java.util.LinkedList;

/**
 *1 ： 链表
 * 线程不同步
 *
 * 增删快  ，提供了 开头和结尾的操作
 *
 *
 *
 * Created by Administrator on 2019\1\8 0008.
 */
public class linkedlist_test {

    public static void main(String[] args) {

        LinkedList<String> arr = new LinkedList<String>();

        arr.add("dd");

        arr.addFirst("aaaa");

        String a =arr.getFirst();
        arr.getLast();

        arr.clear();

        arr.isEmpty();

    }

}


