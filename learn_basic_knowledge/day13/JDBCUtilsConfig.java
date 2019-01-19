package day13;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * 1：
 *
 *
 * Created by Administrator on 2019\1\19 0019.
 */
public class JDBCUtilsConfig {
    private JDBCUtilsConfig(){}
    private static Connection con;
    private static String driverclass;
    private static String url;
    private static String username;
    private static String password;

    static {
        try {

            readConfig();

            //连接数据库
            Class.forName(driverclass);   //要写类的全名
            con = DriverManager.getConnection(url , username , password);
        }catch (Exception ex){

            throw new RuntimeException(ex + "数据库连接失败");
        }

    }


    private static void readConfig() throws Exception{
        //读
        InputStream in =properties.class.getClassLoader().getResourceAsStream("datebase.properties");
        Properties pro =new Properties();
        pro.load(in);

        driverclass = pro.getProperty("driverClass");
        url = pro.getProperty("url");
        username = pro.getProperty("username");
        password = pro.getProperty("driverClass");

    }
    //定义静态方法，返回数据库的连接对象
    public static Connection getConnection(){
        return con;
    }

}
