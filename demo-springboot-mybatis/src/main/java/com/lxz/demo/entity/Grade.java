package com.lxz.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

@ApiModel(value = "Grade对象",description="年级信息entity")
@Data
public class Grade implements Serializable {

    @ApiModelProperty(value = "年级id")
    private Integer id;

    @ApiModelProperty(value = "年级名")
    private String name;

    @ApiModelProperty(value = "班级类")
    private Team team;

    private static final long serialVersionUID = 1L;

}