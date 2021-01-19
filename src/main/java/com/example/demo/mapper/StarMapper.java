package com.example.demo.mapper;

import com.example.demo.pojo.Star;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StarMapper {
    /*查询*/
    //查询所有收藏
    List<Star> queryStarList();

    //通过收藏ID查询收藏
    Star queryByStarId(Star star);

    //通过用户ID查询
    List<Star> queryByUserId(Integer user_id);

    //通过文章ID查询
    List<Star> queryByBlogId(Integer blog_id);


    /*增加*/
    //增加收藏
    void addStar(Star star);

    /*更新*/


    /*删除*/
    //删除收藏
    void deleteStar(Star star);
}
