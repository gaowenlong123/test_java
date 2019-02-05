package com.gao.web.servlet.bookCity;

import com.gao.model.Book;

import java.util.HashMap;
import java.util.Map;


/**
 * 公用的数据写在一个静态集合
 * @author gyf
 *
 */
public class DBUtils {

	private static Map<Integer,Book> books = new HashMap<Integer,Book>();
	
	//赋值一次的内容最好写在static代码块中
	static{
		books.put(1,new Book(1, "吉它弹奏入门", "lp", "168.88"));
		books.put(2,new Book(2, "锁呐弹奏入门", "hg", "168.88"));
		books.put(3,new Book(3, "带小孩的一些坑", "wf", "168.88"));
		books.put(4,new Book(4, "桌球小王子", "sgx", "168.88"));
		books.put(5,new Book(5, "美食-牛肉丸", "xd", "168.88"));
	}
	
	/**
	 * 返回所有书
	 * @return
	 */
	public static Map<Integer,Book> getAllBooks(){
		return books;
	}
	
	/**
	 * 通过id找到书
	 * @param id
	 * @return
	 */
	public static Book findBookById(Integer id){
		return books.get(id);
	}
}
