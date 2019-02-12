package com.gao.mapper;

import com.gao.model.test1.User;
import com.gao.OneDay.vo.UserQueryVO1;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     *
     * @param user
     * @return 受影响的行数
     */
    //@Insert("INSERT INTO user (username,sex,birthday,address) VALUE (#{username},#{sex},#{birthday},#{address})")
    public int save(User user);

    //@Select("SELECT * FROM user WHERE id = #{id}")
    public User findUserById(int id);

    public List<User> findUserByUserQueryVo(UserQueryVO1 vo);


    public List<User> findUserByMap(Map<String, Object> map);


    /**
     * 返回用户的个数
     * @param vo
     * @return
     */
    public int findUserCount(UserQueryVO1 vo);


    public User findUserByIdResultMap(int userId);

    /**
     * 讲解mybatis的if和where使用
     * @return
     */
    public List<User> findUserList(UserQueryVO1 vo);

    /*查找多个id的用户数据*/
    public List<User> findUserByIds(UserQueryVO1 vo);

    public List<User> findUserByIds2(List<Integer> ids);


    /**
     * 查询用户信息及用户购买的商品信息
     */
    public List<User> findUserAndOrderInfo();
    public User findUserAndOrderInfo(int userId);

}
