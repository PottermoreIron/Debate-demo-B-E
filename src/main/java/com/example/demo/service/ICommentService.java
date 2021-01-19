package com.example.demo.service;

import com.example.demo.pojo.Blog;
import com.example.demo.pojo.Comment;
import com.example.demo.pojo.User;
import java.util.List;

public interface ICommentService {
    void insertComment(Comment comment);
    List<Comment> getCommentByBlog(Integer comment_blog_id);
    List<Comment> getCommentByUser1(Integer comment_user1_id);
    List<Comment> getCommentByUser2(Integer comment_user2_id);
    void deleteComment(Comment comment);
}
