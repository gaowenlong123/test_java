package day13;

import java.sql.*;

/**
 * Created by Administrator on 2019\1\19 0019.
 */
public class JDBCUtils {

    private JDBCUtils(){}
    private static Connection con;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");   //要写类的全名

            //连接数据库
            String url = "jdbc:mysql://localhost:3306/laomeng";
            String root = "root";
            String pass = "root";

            con = DriverManager.getConnection(url , root , pass);
        }catch (Exception ex){

            throw new RuntimeException(ex + "数据库连接失败");
        }

    }

    //定义静态方法，返回数据库的连接对象
    public static Connection getConnection(){
        return con;
    }


    //增删改，没有rs，不用管
    public static void close(Connection con , Statement sta){

        if(sta!=null){
            try {
                sta.close();
            }catch (SQLException sql){}
        }

        if(con!=null){
            try {
                con.close();
            }catch (SQLException sql){}
        }

    }

    public static void close(Connection con , Statement sta , ResultSet rs){

        if(rs!=null){
            try {
                rs.close();
            }catch (SQLException sql){}
        }

        if(sta!=null){
            try {
                sta.close();
            }catch (SQLException sql){}
        }

        if(con!=null){
            try {
                con.close();
            }catch (SQLException sql){}
        }

    }
}
