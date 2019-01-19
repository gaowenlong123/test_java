package day13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *1： 读取数据表sort ， 每行数据封装到sort类的对象中
 * 很多sort类对象，存储到list的集合中
 * Created by Administrator on 2019\1\19 0019.
 */
public class test_Utils {

    public static void main(String[] args) throws SQLException {

        Connection con =JDBCUtils.getConnection();
        PreparedStatement pst = con.prepareStatement("SELECT * FROM sort");
        ResultSet rs = pst.executeQuery();

        //创建集合对象
        List<test_sort> list = new ArrayList<test_sort>();

        while (rs.next()){
//            System.out.println(rs.getString("id") + rs.getNString("sanme"));

            test_sort s = new test_sort(rs.getInt("sid") ,rs.getString("sname"),rs.getDouble("sprice"),rs.getString("sdesc"));
            list.add(s);
        }


        //PreparedStatement 是 Statement 的子类
        JDBCUtils.close(con , pst ,rs);



        //输出
        for (test_sort s : list){
            System.out.println(s);
        }


    }
}
