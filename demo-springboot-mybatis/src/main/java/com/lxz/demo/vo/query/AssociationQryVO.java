package com.lxz.demo.vo.query;/****************************************************
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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;


/**
 * 包名称： com.lxz.demo.vo.response
 * 类名称：AssociationVO
 * 类描述：多张表联立查询信息
 * 创建人：@author liuxuanzhi
 * 创建时间：2021/1/5/10:17
 */

@Data
@RestController
@ApiModel(value = "AssociationQryVO对象",description = "综合查询的属性VO")
public class AssociationQryVO implements Serializable {
    private static final long serialVersionUID = -1884594830856514487L;

    @ApiModelProperty(value = "用户id")
    private Integer sid;
    @ApiModelProperty(value = "用户姓名")
    private String name;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "班级")
    private Integer team;
    @ApiModelProperty(value = "班主任")
    private String teacher;
    @ApiModelProperty(value = "年级")
    private String grade;

}
