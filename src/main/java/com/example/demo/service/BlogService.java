package com.example.demo.service;

import com.example.demo.mapper.*;
import com.example.demo.pojo.Blog;
import com.example.demo.pojo.Comment;
import com.example.demo.pojo.Star;
import com.example.demo.pojo.User;
import com.example.demo.pojo.Up;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService{
    @Resource
    private UserMapper userDao;
    @Resource
    private StarMapper starDao;
    @Resource
    private BlogMapper blogDao;
    @Resource
    private UpMapper upDao;
    @Resource
    private CommentMapper commentDao;
    @Override
    public void updateBlog(Blog blog){
        blogDao.addBlog(blog);
    }
    @Override
    public String showBlog(Blog blog){
        return blog.getBlog_content();
    }
    @Override
    public String showTitle(Blog blog){
        return blog.getBlog_title();
    }
    @Override
    public int countUp(Blog blog){
        return upDao.queryByBlogId(blog.getBlog_id()).size();
    }
    @Override
    public int countStar(Blog blog){
        return starDao.queryByBlogId(blog.getBlog_id()).size();
    }
    public int value(Blog blog){
        return countStar(blog)*3+countUp(blog);
    }
    @Override
    public void blogUp(Blog blog, User user){
        if(upDao.queryByUpId(new Up(user.getUser_id(),blog.getBlog_id()))==null){
            upDao.addUp(new Up(user.getUser_id(),blog.getBlog_id()));
            //使图标亮
        }
        else{
            upDao.deleteUp(new Up(user.getUser_id(),blog.getBlog_id()));
            //不亮
        }
    }
    @Override
    public void blogStar(Blog blog,User user){
        if(starDao.queryByStarId(new Star(user.getUser_id(),blog.getBlog_id()))==null){
            starDao.addStar(new Star(user.getUser_id(),blog.getBlog_id()));
            //使图标亮
        }
        else{
            starDao.deleteStar(new Star(user.getUser_id(),blog.getBlog_id()));
            //不亮
        }
    }
    public boolean if_Up(Blog blog, User user){
        if(upDao.queryByUpId(new Up(user.getUser_id(),blog.getBlog_id()))==null){
            return true;
            //使图标亮
        }
        else{
            return false;
            //不亮
        }
    }
    public boolean if_Star(Blog blog, User user){
        if(starDao.queryByStarId(new Star(user.getUser_id(),blog.getBlog_id()))==null){
            return true;
            //使图标亮
        }
        else{
            return false;
            //不亮
        }
    }
    @Override
    public void blogComment(String content,Blog blog,Integer comment_id){

    }

    @Override
    public List<Comment> showComment(Blog blog){
        return commentDao.queryByBlogId(blog.getBlog_id());
    }
    @Override
    public User blogAuthor(Blog blog){
        return userDao.queryByUserId(blog.getBlog_authorId());
    }
    @Override
    public List<Blog> showBlogByTime(){
        return blogDao.queryBlogList().stream().sorted(Comparator.comparing(Blog::getBlog_id).reversed()).collect(Collectors.toList());
    }
    @Override
    public List<Blog> showBlogByValue(){
        List<Blog> list=blogDao.queryBlogList();
        QuickSort(list,0,list.size()-1);
        return list;
    }
    private void QuickSort(List<Blog> list1,int low,int high){
        int i,j,temp;
        Blog t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp=value(list1.get(0));
        while (i<j) {
            //先看右边，依次往左递减
            while (temp>=value(list1.get(j))&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp<=value(list1.get(i))&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = list1.get(j);
                list1.set(j, list1.get(i));
                list1.set(i,t);
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        t=list1.get(0);
        list1.set(low, list1.get(i));
        list1.set(i,t);
        //递归调用左半数组
        QuickSort(list1, low, j-1);
        //递归调用右半数组
        QuickSort(list1, j+1, high);

    }


}
