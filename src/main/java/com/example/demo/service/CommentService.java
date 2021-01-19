package com.example.demo.service;

import com.example.demo.mapper.*;
import com.example.demo.pojo.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService implements ICommentService{
    @Resource
    private UserMapper userDao;
    @Resource
    private CommentMapper commentDao;
    @Override
    public void insertComment(Comment comment){
        commentDao.addComment(comment);
    }
    @Override
    public List<Comment> getCommentByBlog(Integer comment_blog_id){
        return commentDao.queryByBlogId(comment_blog_id);
    }
    @Override
    public List<Comment> getCommentByUser1(Integer comment_user1_id){
        return commentDao.queryByUser1Id(comment_user1_id);
    }
    @Override
    public List<Comment> getCommentByUser2(Integer comment_user2_id){
        return commentDao.queryByUser2Id(comment_user2_id);
    }
    @Override
    public void deleteComment(Comment comment){
        commentDao.deleteComment(comment.getComment_id());
    }
}
