package com.lxz.demo.service;

import com.lxz.demo.entity.Team;
import com.lxz.demo.vo.query.TeamQryVO;
import com.lxz.demo.vo.request.UpdateTeamReqVO;
import com.lxz.demo.vo.response.ResultRepVO;

import java.util.List;

/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2021/1/4/16:47
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.service
 * 文件描述: @Description: ${TODO}
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2021
 *
 ********************************************************/
public interface TeamService {
    /**
     * 获取所有数据
     * @param
     * @return: List<TeamVO>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/16:39
     */
    List<TeamQryVO> listClass();

    /**
     * 获取数据根据老师名
     * @param name
     * @return: TeamVO
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/16:39
     */
    TeamQryVO listClassByTeacher(String name);

    /**
     * 获取所有数据更加年级
     * @param grade
     * @return: List<TeamVO>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/16:39
     */
    List<TeamQryVO> listClassByGrade(Integer grade);

    /**
     * 更新老师通过id
     * @param updateTeamReqVO
     * @return: null
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/16:39
     */
    ResultRepVO updateClass(UpdateTeamReqVO updateTeamReqVO);

    /**
     * 根据班级名年级名查询
     * @param grade
     * @param  name
     * @return:    List<team>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2021/1/8/13:42
     */
     List<Team> teamListByGrade(Integer grade, Integer name);
}
