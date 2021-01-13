package com.lxz.demo.vo.query;/****************************************************
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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 包名称： com.lxz.demo.vo.response
 * 类名称：GradeQryVO
 * 类描述：年级视图层实体类
 * 创建人：@author liuxuanzhi
 * 创建时间：2021/1/4/16:43
 */

@Data
@ApiModel(value = "GradeQryVO对象",description = "年级信息查询VO")
public class GradeQryVO implements Serializable {
    private static final long serialVersionUID = -3809237669856756255L;
    @ApiModelProperty(value = "年级id")
    private int id;
    @ApiModelProperty(value = "年级名")
    private String name;

}
