package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer comment_id;
    private Integer comment_blogId;
    private Integer comment_senderId;
    private Integer comment_receiverId;
    private Date comment_time;
    private String comment_content;


}
