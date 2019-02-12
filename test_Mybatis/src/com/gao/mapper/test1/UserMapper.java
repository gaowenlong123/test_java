package com.gao.mapper.test1;

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
//    @Insert("INSERT INTO user (username,sex,birthday,address) VALUE (#{username},#{sex},#{birthday},#{address})")
    public int save(User user);

//    @Select("SELECT * FROM user WHERE id = #{id}")
    public User findUserById(int id);

    public List<User> findUserByUserQueryVo(UserQueryVO1 vo);


    public List<User> findUserByMap(Map<String, Object> map);
}
