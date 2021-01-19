package com.example.demo.controller;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Comment;
import com.example.demo.service.BlogService;
import com.example.demo.service.CommentPlusService;
import com.example.demo.service.CommentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Comment")
public class CommentController extends BaseController{
    @Resource
    private BlogService blogService;
    @Resource
    private CommentService commentService;
    @Resource
    private CommentMapper commentDao;
    @Resource
    private CommentPlusService commentPlusService;
    @Resource
    private UserMapper userMapper;
    //显示当前博客评论  无传参 返回List<Comment>  /Comment
    public List<CommentPlusService> showCommentPlus(List<Comment> list1){
        List<CommentPlusService> list2=new ArrayList<CommentPlusService>();
        for(Comment comment:list1){
            CommentPlusService commentPlusService=new CommentPlusService();
            commentPlusService.setSender_name(userMapper.queryByUserId(comment.getComment_senderId()).getUser_name());
            commentPlusService.setComment(comment);
            list2.add(commentPlusService);
        }
        return list2;
    }

    @ResponseBody
    @RequestMapping("")
    public List<CommentPlusService> showComment(@RequestParam("bid") Integer bid){
        return showCommentPlus(commentService.getCommentByBlog(bid));
    }

    //回复评论   传参点击评论id（若评论文章本身，则为0）和评论内容  无返回值  /Comment/{cid}
    @ResponseBody
    @GetMapping("/publish")
    public void comment (@RequestParam Integer bid, @RequestParam("content") String content,@RequestParam Integer uid){
        Comment comment;
        if(commentDao.queryCommentList().size()==0){
            comment=new Comment(0,bid,uid,null,new Date(),content);
        }
        else{
            comment=new Comment(commentDao.queryCommentList().get(commentDao.queryCommentList().size()-1).getComment_id()+1,bid,uid,null,new Date(),content);
        }

        commentService.insertComment(comment);
    }

    //退出评论，回到博客 无传参
    @RequestMapping("/exit")
    @ResponseBody
    public void exit(){

    }
}

