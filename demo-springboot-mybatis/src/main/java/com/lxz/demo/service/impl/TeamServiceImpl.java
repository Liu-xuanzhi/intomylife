package com.lxz.demo.service.impl;/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2021/1/4/16:54
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.service.impl
 * 文件描述: @Description: 实现teamService
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2021
 *
 ********************************************************/

import com.lxz.demo.dao.TeamMapper;
import com.lxz.demo.entity.Team;
import com.lxz.demo.entity.TeamExample;
import com.lxz.demo.service.TeamService;
import com.lxz.demo.vo.response.TeamVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static com.lxz.demo.service.impl.StudentInfoServiceImpl.copyList;

/**
 * 包名称： com.lxz.demo.service.impl
 * 类名称：TeamServiceImpl
 * 类描述：实现teamSerice
 * 创建人：@author liuxuanzhi
 * 创建时间：2021/1/4/16:54
 */

@Service
public class TeamServiceImpl implements TeamService {
    String NOT_DELETE = "0";
    String DELETE = "1";

    @Resource
    TeamExample teamExample;
    @Resource
    TeamMapper teamMapper;

    @Override
    public List<TeamVO> listClass() {
        teamExample.clear();
        TeamExample.Criteria criteria = teamExample.createCriteria();
        criteria.andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
        List<Team> teams = teamMapper.selectByExample(teamExample);
        return copyList(teams, TeamVO.class);
    }

    @Override
    public TeamVO listClassByTeacher(String name) {
        teamExample.clear();
        TeamExample.Criteria criteria = teamExample.createCriteria();
        criteria.andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
        criteria.andTeacherEqualTo(name);
        List<Team> teams = teamMapper.selectByExample(teamExample);
        TeamVO teamVO = new TeamVO();
        BeanUtils.copyProperties(teams.get(0),teamVO);
        return teamVO;
    }

    @Override
    public List<TeamVO> listClassByGrade(Integer grade) {
        teamExample.clear();
        TeamExample.Criteria criteria = teamExample.createCriteria();
        criteria.andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
        criteria.andGradeEqualTo(grade);

        List<Team> teams = teamMapper.selectByExample(teamExample);
        return copyList(teams, TeamVO.class);
    }

    @Override
    public void saveClass(Integer id, String teacher) {
        teamExample.clear();
        LocalDateTime updateDateTime= LocalDateTime.now();
        Date updateTime = Date.from(updateDateTime.atZone(ZoneId.of("Asia/Shanghai")).toInstant());
        TeamExample.Criteria criteria = teamExample.createCriteria();
        criteria.andIdEqualTo(id);
        Team team = new Team();
        team.setTeacher(teacher);
        team.setUpdateTime(updateTime);
        team.setUpdateUserId("1");
        teamMapper.updateByExampleSelective(team,teamExample);
    }
}
