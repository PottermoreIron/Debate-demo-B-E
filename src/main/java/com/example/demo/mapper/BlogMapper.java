package com.example.demo.mapper;

import com.example.demo.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogMapper {

    /*查询*/
    //查询所有博客
    List<Blog> queryBlogList();

    //通过博客Id查询博客
    Blog queryByBlogId(Integer blog_id);

    List<Blog> queryByUserId(Integer user_id);
    /*增加*/
    //增加博客
    void addBlog(Blog blog);

    List<Blog> selectBlog(String select);

    /*更新*/
    //更新博客
    void updateBlog(Blog blog);


    /*删除*/
    //删除博客
    void deleteBlog(Integer blog_id);


}
