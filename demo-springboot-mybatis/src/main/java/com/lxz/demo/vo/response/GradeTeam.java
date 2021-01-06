package com.lxz.demo.vo.response;/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2021/1/4/16:43
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.vo.response
 * 文件描述: @Description: 年级视图层实体类
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2021
 *
 ********************************************************/

import lombok.Data;

import java.io.Serializable;

/**
 * 包名称： com.lxz.demo.vo.response
 * 类名称：GradeTeam
 * 类描述：年级视图层实体类
 * 创建人：@author liuxuanzhi
 * 创建时间：2021/1/4/16:43
 */

@Data
public class GradeTeam implements Serializable {
    private static final long serialVersionUID = -3809237669856756255L;

    private int id;

    private String name;

}
