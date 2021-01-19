package com.example.demo.mapper;


import com.example.demo.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.example.demo.pojo.Blog;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    /*查询*/
    //查询所有评论
    List<Comment> queryCommentList();

    //通过评论Id查询评论
    Comment queryByCommentId(Integer comment_id);

    List<Comment> queryByUser1Id(Integer user1_id);
    List<Comment> queryByUser2Id(Integer user2_id);
    /*增加*/
    //增加评论
    void addComment(Comment comment);

    List<Comment> queryByBlogId(Integer blog_id);

    /*更新*/
    //更新评论
    void updateComment(Comment comment);

    /*删除*/
    //删除评论
    void deleteComment(Integer comment_id);
}
