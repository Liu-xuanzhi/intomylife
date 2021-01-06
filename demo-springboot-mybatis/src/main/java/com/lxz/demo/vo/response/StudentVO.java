package com.lxz.demo.vo.response;/****************************************************
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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * 包名称： com.lxz.demo.vo.response
 * 类名称：StudentVo
 * 类描述：学生信息视图层实体类
 * 创建人：@author liuxuanzhi
 * 创建时间：2021/1/4/14:29
 */

@Data
public class StudentVO implements Serializable {
    private static final long serialVersionUID = 2925326330810180496L;

    private Integer id;

    private String name;

    private Integer age;

    private Integer team;

    private Integer grade;
}

