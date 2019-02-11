package com.test;

import com.cxf.model.User;
import com.cxf.utils.C3P0Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Administrator on 2019/2/6 0006.
 */

public class test {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;


        conn = C3P0Utils.getConnection();

        String sql = "insert into t_user (username,password,email,birthday ) values(?,?,?,?)";
        ps = conn.prepareStatement(sql);

        // 设置参数
        ps.setString(1, "test");
        ps.setString(2, "test");
        ps.setString(3, "hahahah");
        ps.setDate(4, new java.sql.Date(1111111));

        int r = ps.executeUpdate();
        System.out.println("受影响的结果行数:" + r);



        //查询
        /*String sql = "select * from t_user where username = ? and password = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, "gao");
        ps.setString(2, "123");

        rs = ps.executeQuery();

        //4.遍历
        while(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setBirthday(rs.getDate("birthday"));
        }*/



    }
}
