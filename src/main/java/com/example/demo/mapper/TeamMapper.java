package com.example.demo.mapper;

import com.example.demo.pojo.Team;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeamMapper {
    /*查询*/
    //查询所有辩论队
    List<Team> queryTeamList();

    //通过队Id查询辩论队
    Team queryByTeamId(Integer team_id);


    /*增加*/
    //增加辩论队
    void addTeam(Team team);


    /*更新*/
    //更新辩论队
    void updateTeam(Team team);


    /*删除*/
    //删除辩论队
    void deleteTeam(Integer team_id);
}
