package com.lxz.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "Team对象",description="班级信息entity")
public class Team implements Serializable {
    @ApiModelProperty(value = "班级id")
    private Integer id;

    @ApiModelProperty(value = "班级名")
    private Integer name;

    @ApiModelProperty(value = "所属年级")
    private Integer grade;

    @ApiModelProperty(value = "班主任")
    private String teacher;

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

    private static final long serialVersionUID = 1L;

    public Team() {
    }

    public Team(Integer id, String teacher, String updateUserId) {
        this.id = id;
        this.teacher = teacher;
        this.updateUserId = updateUserId;
    }
}