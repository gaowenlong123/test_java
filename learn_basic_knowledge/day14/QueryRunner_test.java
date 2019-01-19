package day14;

import day13.JDBCUtilsConfig;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 1：
 *
 *
 * Created by Administrator on 2019\1\19 0019.
 */
public class QueryRunner_test {

    private static Connection con = JDBCUtilsConfig.getConnection();

    public static void main(String[] args) throws SQLException {

        QueryRunner qr = new QueryRunner();


        //update ,执行语句
        //返回影响了几行
//        String sql ="INSERT INTO sort (sname,sprice,sdesc) VALUES(?,?,?)";
//        String sql ="UPDATE  sort SET sname=? ,sprice=? WHERE sid=?";
//        Object[] params = {"医疗" ,1.22,"购买药品"};
//        int row = qr.update(con,sql,params);


        //2 删除只要一个问号，直接写就行
        String sql ="DELETE FROM sort WHERE sid=?";
        int row = qr.update(con,sql,8);            //返回零就是已经删除过了或没有数据，删除失败

        //安静关闭，就是处理异常
        DbUtils.closeQuietly(con);


    }
}
