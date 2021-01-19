package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Integer blog_id;
    private Integer blog_authorId;
    private Date blog_time;
    private String blog_content;
    private String blog_title;

}
