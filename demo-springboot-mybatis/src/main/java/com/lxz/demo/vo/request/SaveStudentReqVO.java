package com.lxz.demo.vo.request;/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2021/1/7/14:17
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.vo.request
 * 文件描述: @Description: 添加学生信息请求层VO
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2021
 *
 ********************************************************/

import com.lxz.demo.entity.Student;
import com.lxz.demo.vo.query.StudentQryVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 包名称： com.lxz.demo.vo.request
 * 类名称：SaveStudentReqVO
 * 类描述：添加学生信息请求层VO
 * 创建人：@author liuxuanzhi
 * 创建时间：2021/1/7/14:17
 */

@Data
@ApiModel(value = "SaveStudentReqVO对象",description = "添加学生信息属性")
public class SaveStudentReqVO implements Serializable {
    private static final long serialVersionUID = -6908098062711188377L;

    @ApiModelProperty(value = "学生名字")
    String name;

    @ApiModelProperty(value = "班级")
    Integer team;

    @ApiModelProperty(value = "年级")
    Integer grade;

    @ApiModelProperty(value = "年龄")
    Integer age;

    @ApiModelProperty(value = "创建用户ID")
    String createUserId;

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
        return new Student(name, team, grade, age, createUserId);
    }


}
