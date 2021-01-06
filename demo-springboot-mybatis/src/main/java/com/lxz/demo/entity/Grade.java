package com.lxz.demo.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class Grade implements Serializable {
    private Integer id;

    private String name;

    private Team team;

    private static final long serialVersionUID = 1L;

}