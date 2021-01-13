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

import com.lxz.demo.dao.GradeMapper;
import com.lxz.demo.dao.TeamMapper;
import com.lxz.demo.entity.Team;
import com.lxz.demo.entity.TeamExample;
import com.lxz.demo.service.TeamService;
import com.lxz.demo.vo.query.TeamQryVO;
import com.lxz.demo.vo.request.UpdateTeamReqVO;
import com.lxz.demo.vo.response.ResultRepVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Resource
    GradeMapper gradeMapper;

    @Autowired
    ResultRepVO resultRepVO;

    @Override
    public List<TeamQryVO> listClass() {
        try {
            TeamExample.Criteria criteria = teamExample.createCriteria();
            criteria.andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
            List<Team> teams = teamMapper.selectByExample(teamExample);
            return copyList(teams, TeamQryVO.class);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            teamExample.clear();
        }
        return null;
    }

    @Override
    public TeamQryVO listClassByTeacher(String name) {
        try {
            TeamExample.Criteria criteria = teamExample.createCriteria();
            criteria.andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
            criteria.andTeacherEqualTo(name);
            List<Team> teams = teamMapper.selectByExample(teamExample);
            TeamQryVO teamQryVO = new TeamQryVO();
            BeanUtils.copyProperties(teams.get(0), teamQryVO);
            return teamQryVO;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            teamExample.clear();
        }
        return null;
    }

    @Override
    public List<TeamQryVO> listClassByGrade(Integer grade) {
        try {
            teamExample.clear();
            TeamExample.Criteria criteria = teamExample.createCriteria();
            criteria.andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
            criteria.andGradeEqualTo(grade);

            List<Team> teams = teamMapper.selectByExample(teamExample);
            return copyList(teams, TeamQryVO.class);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            teamExample.clear();
        }
        return null;
    }

    @Override
    public ResultRepVO updateClass(UpdateTeamReqVO updateTeamReqVO) {
        try {
            if(teamMapper.selectByPrimaryKey(updateTeamReqVO.getId()) == null){
                resultRepVO.setSuccess(false);
                resultRepVO.setMessage("班级或年级不存在");
                return resultRepVO;
            }
            LocalDateTime updateDateTime = LocalDateTime.now();
            Date updateTime = Date.from(updateDateTime.atZone(ZoneId.of("Asia/Shanghai")).toInstant());
            TeamExample.Criteria criteria = teamExample.createCriteria();
            criteria.andIdEqualTo(updateTeamReqVO.getId());
            Team team = updateTeamReqVO.teamValueOf();
            team.setUpdateTime(updateTime);
            teamMapper.updateByExampleSelective(team, teamExample);
            resultRepVO.setMessage("成功");
            resultRepVO.setSuccess(true);
            return resultRepVO;
        }catch (Exception e){
            e.printStackTrace();
            resultRepVO.setMessage("内部错误");
            resultRepVO.setSuccess(false);
            return resultRepVO;
        }finally {
            teamExample.clear();
        }
    }

    @Override
    public List<Team> teamListByGrade(Integer grade, Integer name){
        try {
            teamExample.createCriteria().andGradeEqualTo(grade).andNameEqualTo(name).andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
            return teamMapper.selectByExample(teamExample);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            teamExample.clear();
        }
        return null;
    }
}
