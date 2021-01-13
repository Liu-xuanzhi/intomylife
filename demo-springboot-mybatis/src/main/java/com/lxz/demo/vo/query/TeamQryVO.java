package com.lxz.demo.vo.query;/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2021/1/4/15:53
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.vo.response
 * 文件描述: @Description: 展示到视图层的实体类
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2021
 *
 ********************************************************/

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * 包名称： com.lxz.demo.vo.response
 * 类名称：TeamVO
 * 类描述：展示到视图层的实体类
 * 创建人：@author liuxuanzhi
 * 创建时间：2021/1/4/15:53
 */

@RestController
@Data
@ApiModel(value = "TeamQryVO对象",description = "班级查询信息VO")
public class TeamQryVO implements Serializable {
    private static final long serialVersionUID = -2485845569302827458L;
    @ApiModelProperty(value = "班级id")
    private Integer id;
    @ApiModelProperty(value = "班级名")
    private Integer name;
    @ApiModelProperty(value = "班主任")
    private String teacher;
    @ApiModelProperty(value = "所属年级")
    private Integer grade;

}
