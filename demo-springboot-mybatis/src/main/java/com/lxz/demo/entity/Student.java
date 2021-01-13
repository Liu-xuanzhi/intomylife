package com.lxz.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "Student对象",description="student信息entity")
public class Student implements Serializable {
    @ApiModelProperty(value = "学生id")
    private Integer id;

    @ApiModelProperty(value = "学生姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "创建用户id")
    private String createUserId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新用户id")
    private String updateUserId;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "删除标记")
    private Long deleteFlag;

    @ApiModelProperty(value = "班级id")
    private Integer team;

    @ApiModelProperty(value = "年级")
    private Integer grade;

    @ApiModelProperty(value = "年级信息List类")
    private List<Grade> gradeList;


    private static final long serialVersionUID = 1L;

    public Student(String name, Integer team, Integer grade, Integer age, String createUserId ) {
        this.name = name;
        this.team = team;
        this.grade = grade;
        this.age = age;
        this.createUserId = createUserId;
    }

    public Student(Integer id,String name,Integer age,String updateUserId,Integer team,Integer grade){
        this.name = name;
        this.team = team;
        this.grade = grade;
        this.age = age;
        this.updateUserId = updateUserId;
        this.id=id;
    }

    public Student() {

    }
}