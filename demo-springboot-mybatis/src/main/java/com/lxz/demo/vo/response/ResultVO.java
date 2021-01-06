package com.lxz.demo.vo.response;/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2020/12/31/13:15
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.vo
 * 文件描述: @Description: 学生数据库操作结果
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2020
 *
 ********************************************************/

import lombok.Data;
import org.springframework.web.bind.annotation.RestController;
import java.io.Serializable;

/**
 * 包名称： com.lxz.demo.vo
 * 类名称：ResultVO
 * 类描述：学生数据库操作结果
 * 创建人：@author liuxuanzhi
 * 创建时间：2020/12/31/13:15
 */

@RestController
@Data
public class ResultVO implements Serializable {
    private static final long serialVersionUID = 1343634884313243493L;

    private Boolean success;

    private String message;

}
