package com.example.demo.mapper;


import com.example.demo.pojo.Competition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CompetitionMapper {
    /*查询*/
    //查询所有比赛
    List<Competition> queryCompetitionList();

    //通过比赛Id查询比赛
    Competition queryByCompetitionId(Integer CompetitionId);


    /*增加*/
    //增加比赛
    void addCompetition(Competition competition);


    /*更新*/
    //更新比赛
    void updateCompetition(Competition competition);


    /*删除*/
    //删除比赛
    void deleteCompetition(Integer competition_id);
}
