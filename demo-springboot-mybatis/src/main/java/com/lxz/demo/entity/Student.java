package com.lxz.demo.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Student implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private String createUserId;

    private Date createTime;

    private String updateUserId;

    private Date updateTime;

    private Long deleteFlag;

    private Integer team;

    private Integer grade;

    private List<Grade> gradeList;

    private static final long serialVersionUID = 1L;


}