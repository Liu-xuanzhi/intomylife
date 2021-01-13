package com.lxz.demo.vo.request;/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2021/1/7/14:28
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.vo.request
 * 文件描述: @Description: 更新班级信息请求层VO
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2021
 *
 ********************************************************/

import com.lxz.demo.entity.Student;
import com.lxz.demo.entity.Team;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 包名称： com.lxz.demo.vo.request
 * 类名称：UpdateTeamReqVO
 * 类描述：更新班级信息请求层VO
 * 创建人：@author liuxuanzhi
 * 创建时间：2021/1/7/14:28
 */

@Data
@ApiModel(value = "UpdateTeamReqVO对象",description = "更新班级班主任名字")
public class UpdateTeamReqVO implements Serializable {
    private static final long serialVersionUID = -8026637764652604437L;

    @ApiModelProperty(value = "班级ID")
    private Integer id;

    @ApiModelProperty(value = "班主任")
    private String teacher;

    @ApiModelProperty(value = "更新用户ID")
    private String updateUserId;

    /**
     * @Title: teamValueOf
     * @Description: 转换team
     *
     * @param
     * @return: Student
     * @throws
     * @author: liuxuanzhi
     * @Date:  2021/1/8/12:06
     */
    public Team teamValueOf(){
        return new Team(id, teacher, updateUserId);
    }
}
