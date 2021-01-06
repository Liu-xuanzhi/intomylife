package com.lxz.demo.vo.response;/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2021/1/4/15:53
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.vo.response
 * 文件描述: @Description: 展示到视图层的实体类
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2021
 *
 ********************************************************/

import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * 包名称： com.lxz.demo.vo.response
 * 类名称：TeamVO
 * 类描述：展示到视图层的实体类
 * 创建人：@author liuxuanzhi
 * 创建时间：2021/1/4/15:53
 */

@RestController
@Data
public class TeamVO implements Serializable {
    private static final long serialVersionUID = -2485845569302827458L;

    private Integer id;

    private Integer name;

    private String teacher;

    private Integer grade;

}
