package com.example.demo.mapper;

import com.example.demo.pojo.Star;
import com.example.demo.pojo.Up;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UpMapper {
    /*查询*/
    //查询所有点赞
    List<Up> queryUpList();

    Up queryByUpId(Up up);

    List<Up> queryByBlogId(Integer blog_id);

    /*增加*/
    //增加点赞
    void addUp(Up up);

    /*更新*/


    /*删除*/
    //删除点赞
    void deleteUp(Up up);
}
