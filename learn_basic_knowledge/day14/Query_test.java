package day14;

import day13.JDBCUtilsConfig;
import day13.test_sort;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * 1： 返回值都是泛型
 *
 *
 ArrayHandler	        将结果集中的第一条记录封装到一个Object[]数组中，数组中的每一个元素就是这条记录中的每一个字段的值
 ArrayListHandler	    将结果集中的每一条记录都封装到一个Object[]数组中，将这些数组在封装到List集合中。
 BeanHandler	        将结果集中第一条记录封装到一个指定的javaBean中。
 BeanListHandler	    将结果集中每一条记录封装到指定的javaBean中，将这些javaBean在封装到List集合中
 ColumnListHandler	    将结果集中指定的列的字段值，封装到一个List集合中
 ScalarHandler	        它是用于单数据。例如select count(*) from 表操作。
 MapHandler	            将结果集第一行封装到Map集合中,Key 列名, Value 该列数据
 MapListHandler	        将结果集第一行封装到Map集合中,Key 列名, Value 该列数据,Map集合存储到List集合
 *
 *
 * Created by Administrator on 2019\1\19 0019.
 */
public class Query_test {
    private static Connection con = JDBCUtilsConfig.getConnection();

    public static void main(String[] args) throws SQLException {
        QueryRunner qr = new QueryRunner();

        String sql ="SELECT * FROM sort";

        //1
        Object[] result = qr.query(con,sql , new ArrayHandler() );

        //2
        List<Object[]> result1 = qr.query(con,sql , new ArrayListHandler() );

        //3                                                  根据反射将对象传入
//        test_sort[] result2 = qr.query(con,sql , new BeanHandler<test_sort>(test_sort.class));

        //4
//        List<test_sort>[] result3 = qr.query(con,sql , new BeanListHandler<test_sort>(test_sort.class));

        //5指定列装进List集合
//        List<Object[]> result4 = qr.query(con,sql , new ColumnListHandler<Object>("sname") );

        //6 一个数据集 ,聚合函数的结果
        String sql2 ="SELECT COUNT *   FROM sort";
        Object result6 = qr.query(con,sql2 , new ScalarHandler<Object>() );

        //7  map<键，值>  键：列数  列：这列的数据
        Map<String,Object> result7 = qr.query(con,sql , new MapHandler() );

        //8
        List<Map<String,Object>> result8 = qr.query(con,sql , new MapListHandler() );


    }
}
