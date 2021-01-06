package com.lxz.demo.vo.response;/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2021/1/5/10:17
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.vo.response
 * 文件描述: @Description: 多张表联立查询信息
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2021
 *
 ********************************************************/

import lombok.Data;
import org.springframework.web.bind.annotation.RestController;


/**
 * 包名称： com.lxz.demo.vo.response
 * 类名称：AssociationVO
 * 类描述：多张表联立查询信息
 * 创建人：@author liuxuanzhi
 * 创建时间：2021/1/5/10:17
 */

@Data
@RestController
public class AssociationVO {
    private Integer sid;
    private String name;
    private Integer age;
    private Integer team;
    private String teacher;
    private String grade;

}
