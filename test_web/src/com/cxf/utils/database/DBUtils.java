package com.cxf.utils.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Administrator on 2019/2/7 0007.
 */
public class DBUtils {
    //老方法
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static String dirverClassName = null;
    static{

        try {

            //这种方式  properties文件必须放在src目录下
            InputStream in =DBCPUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties p =new Properties();
            p.load(in);
            dirverClassName = p.getProperty("dirverClassName");
            url = p.getProperty("url");
            user = p.getProperty("username");
            password = p.getProperty("password");




            System.out.println("从db.properites取数据:");
            System.out.println("url:" + url);
            System.out.println("user:" + user);
            System.out.println("password:" + password);
            System.out.println("driverClass:" + dirverClassName);

            Class.forName(dirverClassName);//加载驱动

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn){

        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt !=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
