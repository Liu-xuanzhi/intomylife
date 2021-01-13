package com.lxz.demo.vo.request;/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2021/1/7/14:05
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.vo.request
 * 文件描述: @Description: 更新学生信息的请求层VO
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2021
 *
 ********************************************************/

import com.lxz.demo.entity.Student;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 包名称： com.lxz.demo.vo.request
 * 类名称：UpdateStudentReqVO
 * 类描述：更新学生信息的请求层VO
 * 创建人：@author liuxuanzhi
 * 创建时间：2021/1/7/14:05
 */
@Data
@ApiModel(value = "UpdateStudentReqVO对象",description = "更新学生信息属性")
public class UpdateStudentReqVO implements Serializable {
    private static final long serialVersionUID = -6032769165305171607L;

    @ApiModelProperty(value = "学生ID")
    private Integer id;

    @ApiModelProperty(value = "学生姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "更新用户ID")
    private String updateUserId;

    @ApiModelProperty(value = "班级")
    private Integer team;

    @ApiModelProperty(value = "年级")
    private Integer grade;

    /**
     * @Title: studentValueOf
     * @Description: 转换student
     *
     * @param
     * @return: Student
     * @throws
     * @author: liuxuanzhi
     * @Date:  2021/1/8/12:06
     */
    public Student studentValueOf(){
        return new Student(id,name,age,updateUserId,team,grade);
    }
}
