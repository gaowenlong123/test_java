package day14;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * 1:网络编程中，tcp连接后断开，不能一断开就释放资源。
 * 用完资源就放回池里面，不用销毁再创建。
 *
 *
 * dbcp + pool
 *
 * Created by Administrator on 2019\1\19 0019.
 */
public class Pool {

    private static BasicDataSource dataSource = new BasicDataSource();

    //静态代码块，对象的配置
    static {

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //对象连接池中的连接配置，可选配置，不配置有默认数据
        dataSource.setInitialSize(10);//初始化数量
        dataSource.setMaxIdle(8);//最大空闲数
        dataSource.setMaxIdle(1);//最小空闲数


    }


            //返回接口，可以多态调用
    public static DataSource getDatesource(){
        return dataSource;
    }




    //连接数据池,运行
    private static QueryRunner qr =new QueryRunner(Pool.getDatesource());
    public static void main(String[] args) {

        String sql = "INSERT INTO sort (sname ,sprice,sdesc)VALUES(?,?,?)";
        Object[] params = {"水果" ,120,"贵"};

        try {
            int row = qr.update(sql , params);
        }catch (SQLException ex){

        }


        String sql2 ="SELECT * FROM sort";
        List<Object[]> list =null;

        try {
            list = qr.query(sql,new ArrayListHandler());

        }catch (SQLException ex){

        }




    }



    //连接失败，需要进行其他设置
    public void DataSoruce_test() {
        //实现数据源的规范接口        dataSource是javaX的接口 ，在dbcp中类去实现这个接口

//        BasicDataSource bds = new BasicDataSource();
//        //连接数据库的最基本的四个信息通过方法来实现
//
//        bds.setDriverClassName("com.mysql.jdbc.Driver");
//        bds.setUrl("");
//        bds.setUsername("root");
//        bds.setPassword("root");
//
//        //调用对象的方法，获取数据库的连接
//        try {
//            Connection con = bds.getConnection();
//        }catch (SQLException ex){
//            ex.printStackTrace();
//            throw new RuntimeException(ex);
//        }
//
//
//    }
    }
}
