package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Competition {
    private Integer competition_id;
    private Integer team_department1;
    private Integer team_department2;
    private Date competition_time;
    private String competition_title;

}
