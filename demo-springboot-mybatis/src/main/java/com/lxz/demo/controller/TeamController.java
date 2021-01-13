package com.lxz.demo.controller;/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2021/1/4/17:44
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.controller
 * 文件描述: @Description: team控制层
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2021
 *
 ********************************************************/

import com.lxz.demo.service.impl.TeamServiceImpl;
import com.lxz.demo.vo.request.UpdateTeamReqVO;
import com.lxz.demo.vo.response.ResultRepVO;
import com.lxz.demo.vo.query.TeamQryVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 包名称： com.lxz.demo.controller
 * 类名称：TeamController
 * 类描述：team控制层
 * 创建人：@author liuxuanzhi
 * 创建时间：2021/1/4/17:44
 */
@RestController
@Api(tags="班级信息管理")
public class TeamController {
    @Autowired
    TeamServiceImpl teamService;
    @Autowired
    TeamQryVO teamQryVO;
    @Autowired
    ResultRepVO resultRepVO;

    /**
     * @Title: listTeam
     * @Description: 直接查询所有班级
     * @param
     * @return: List<TeamVO>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2021/1/4/17:47
     */
    @GetMapping("/listTeam")
    @ApiOperation(value = "查询所有班级信息", notes = "列表查询")
    public List<TeamQryVO> listTeam(){
        System.out.println("all");
        return teamService.listClass();
    }

    /**
     * @Title: listTeamByTeacher
     * @Description: 查询班级信息根据班主任名字
     * @param teacher
     * @return: TeamVO
     * @throws
     * @author: liuxuanzhi
     * @Date:  2021/1/4/17:47
     */
    @GetMapping("/getTeamByTeacher")
    @ApiOperation(value = "查询班级信息根据teacher", notes = "列表查询")
    @ApiImplicitParam(name = "teacher", value = "班主任名字", dataType = "String",required = true)
    public TeamQryVO listTeamByTeacher(String teacher){
        return teamService.listClassByTeacher(teacher);
    }

    /**
     * @Title: listTeamByGrade
     * @Description: 查询班级信息根据年级
     * @param grade
     * @return: List<TeamVO>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2021/1/4/17:47
     */
    @GetMapping("/getTeamByGrade")
    @ApiOperation(value = "查询班级信息根据年级", notes = "列表查询")
    @ApiImplicitParam(name = "grade", value = "年级", dataType = "int",required = true)
    public List<TeamQryVO> listTeamByGrade(Integer grade){
        return teamService.listClassByGrade(grade);
    }

    /**
     * @Title: updateTeam
     * @Description: 全信息更新
     * @param updateTeamReqVO
     * @return: String
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/17:02
     */
    @PostMapping("/updateTeam")
    @ApiOperation(value = "根据id更改老师名字", notes = "更改老师")
    public ResultRepVO saveTeam(@RequestBody UpdateTeamReqVO updateTeamReqVO){

        resultRepVO = teamService.updateClass(updateTeamReqVO);

        return resultRepVO;
    }
}
