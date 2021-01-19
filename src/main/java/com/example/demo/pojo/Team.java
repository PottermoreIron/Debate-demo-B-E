package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private String team_department;
    private String team_photo;
    private Integer team_id;

}
