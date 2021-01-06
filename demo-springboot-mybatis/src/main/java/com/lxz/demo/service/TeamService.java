package com.lxz.demo.service;

import com.lxz.demo.vo.response.TeamVO;

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
    List<TeamVO> listClass();

    /**
     * 获取数据根据老师名
     * @param name
     * @return: TeamVO
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/16:39
     */
    TeamVO listClassByTeacher(String name);

    /**
     * 获取所有数据更加年级
     * @param grade
     * @return: List<TeamVO>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/16:39
     */
    List<TeamVO> listClassByGrade(Integer grade);

    /**
     * 更新老师通过id
     * @param id
     * @param teacher
     * @return: null
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/16:39
     */
    void saveClass(Integer id,String teacher);
}
