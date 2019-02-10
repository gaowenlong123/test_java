package com.gao.dao;

import com.gao.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("mydao")
public class UserDaoImpl implements IUserDao{

    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(User user) {
        System.out.println("dao 添加用户:" + user);
        jdbcTemplate.update("INSERT t_user (username,password) VALUES (?,?)",user.getUsername(),user.getPassword());

    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
