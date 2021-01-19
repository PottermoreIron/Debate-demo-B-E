package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String user_name;
    private Integer user_id;
    private String user_password;
    private String user_photo;
    private Integer team_id;
    private Integer user_grade;
    private Boolean if_captain;

}
