package com.example.demo.service;

import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Blog;
import com.example.demo.pojo.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentPlusService {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private UserMapper userMapper;
    private Comment comment;
    private String sender_name;

    public CommentMapper getCommentMapper() {
        return commentMapper;
    }

    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    private String receiver_name;
    public CommentPlusService(Comment comment){
        sender_name=userMapper.queryByUserId(comment.getComment_senderId()).getUser_name();
        receiver_name=userMapper.queryByUserId(comment.getComment_receiverId()).getUser_name();
        this.comment=comment;
    }

    public CommentPlusService() {
    }

    public List<CommentPlusService> showCommentPlus(List<Comment> list1){
        List<CommentPlusService> list2=new ArrayList<>();
        for(Comment comment:list1){
            list2.add(new CommentPlusService(comment));
        }
        return list2;
    }
}
