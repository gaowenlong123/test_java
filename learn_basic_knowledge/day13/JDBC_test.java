package day13;

import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * 1：注册驱动  ： 告诉虚拟机，是哪个数据库的驱动
 *
 * 2：获得连接 ：  使用JDBC中的类，完成对mysql数据库的连接
 *
 * 3：获得语句执行平台 ： 通过连接对象获取对sql语句的执行者对象
 *
 *4：执行sql语句 ： 使用执行者对象，向数据库执行sql语句 ，获取数据库的执行结果
 *
 * 5：处理结果
 *
 * 6：释放资源
 *
 *
 *
 * ==================
 * 1：在工程根目录下，新建文件夹 ，复制jar包进来 ,作为 library ，然后仅在本工程下
 *
 *
 * Created by Administrator on 2019\1\17 0017.
 */
public class JDBC_test {
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

        //获取sql 执行者对象  ,返回接口实现类的对象 ,实现类在jar包中无须关心
        Statement stat = con.createStatement();

        //执行sql语句
        // int executeUpdate()  insert ,delete ,update 只能三个操作，因为返回的是int ，为了验证成功修改几行
        int row = stat.executeUpdate("INSERT INTO tb_info(id,sname ,age )VALUES (6,'gao' ,20)");
        System.out.println(row);

        //释放资源
        stat.close();
        con.close();


        String sql = "SELECT * FROM users WHERE username=? AND PASSWORD=?";
        PreparedStatement pst = con.prepareStatement(sql);  ///方法中的参数，全用问号占位符
        String user = "";
        String password = "";

        //调用方法，将问号替换
        pst.setObject(1 ,user);
        pst.setObject(2,password);

        //执行sql，获得结果集
        ResultSet rs = pst.executeQuery();

        System.out.println(rs);



        //释放资源
        rs.close();
        pst.close();
        con.close();
    }
}
