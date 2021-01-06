package com.lxz.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Team implements Serializable {
    private Integer id;

    private Integer name;

    private Integer grade;

    private String teacher;

    private String createUserId;

    private Date createTime;

    private String updateUserId;

    private Date updateTime;

    private Long deleteFlag;

    private static final long serialVersionUID = 1L;


}