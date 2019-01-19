package day13;

import java.sql.*;

/**
 * 1：
 *
 *
 *
 * Created by Administrator on 2019\1\19 0019.
 */
public class JDBC_demo1 {

    public static void main(String[] args) throws ClassNotFoundException ,SQLException {

        //注册驱动
        //  DriverManager.registerDriver(new Driver());
        // 这样会注册两次 ，推荐方式 用反射技术，将驱动类加入内存，静态类对象会自动调用，new对象
        Class.forName("com.mysql.jdbc.Driver");   //要写类的全名

        //连接数据库
        String url = "jdbc:mysql://localhost:3306/laomeng";
        String root = "root";
        String pass = "root";

        Connection con = DriverManager.getConnection(url , root , pass);


        String sql = "UPDATE  sort SET sname=? ,sprice=? WHERE sid=?";
        //获取sql语句的预编译对象
        PreparedStatement pst = con.prepareStatement(sql);  ///方法中的参数，全用问号占位符


        //调用方法，将问号替换
        pst.setObject(1 ,"汽车用品");
        pst.setObject(2,4999);
        pst.setObject(3,7);

        //增删改 ， 执行sql，获得结果集
        ResultSet rs = pst.executeQuery();

        System.out.println(rs);


        //查
        //获取sql语句的预编译对象
        PreparedStatement pst1 = con.prepareStatement("SELECT * FROM sort");
        ResultSet rs1 = pst.executeQuery();
        while (rs1.next()){
            System.out.println(rs.getString("id") + rs1.getNString("sanme"));
        }


        //释放资源
        rs.close();
        pst.close();
        con.close();
    }
}
