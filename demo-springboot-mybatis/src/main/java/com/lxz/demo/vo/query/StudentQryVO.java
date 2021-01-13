package com.lxz.demo.vo.query;/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2021/1/4/14:29
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.vo.response
 * 文件描述: @Description: 学生信息视图层实体类
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2021
 *
 ********************************************************/

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 包名称： com.lxz.demo.vo.response
 * 类名称：StudentVo
 * 类描述：学生信息视图层实体类
 * 创建人：@author liuxuanzhi
 * 创建时间：2021/1/4/14:29
 */
@ApiModel(value = "StudentQryVO对象",description = "student查询信息VO")
@Data
public class StudentQryVO implements Serializable {
    private static final long serialVersionUID = 2925326330810180496L;
    @ApiModelProperty(value = "学生id")
    private Integer id;
    @ApiModelProperty(value = "学生姓名")
    private String name;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "班级id")
    private Integer team;
    @ApiModelProperty(value = "年级")
    private Integer grade;
}

