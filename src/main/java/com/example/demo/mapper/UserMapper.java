package com.example.demo.mapper;


import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    /*查询*/
    //查询所有用户
    List<User> queryUserList();

    //通过用户Id查询用户
    User queryByUserId(Integer userId);


    /*增加*/
    //增加用户
    void addUser(User user);

    /*更新*/
    //更新用户
    void updateUser(User user);

    /*删除*/
    //删除用户
    void deleteUser(User user);
}
