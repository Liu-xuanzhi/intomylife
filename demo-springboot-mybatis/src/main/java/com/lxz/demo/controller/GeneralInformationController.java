package com.lxz.demo.controller;/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2021/1/5/15:07
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.controller
 * 文件描述: @Description: 综合信息   联立查询
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2021
 *
 ********************************************************/

import com.lxz.demo.service.impl.AssociationServiceImpl;
import com.lxz.demo.vo.response.AssociationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 包名称： com.lxz.demo.controller
 * 类名称：GeneralInformationController
 * 类描述：综合信息  联立查询所得出
 * 创建人：@author liuxuanzhi
 * 创建时间：2021/1/5/15:07
 */
@RestController
@Api(tags="综合查询")
public class GeneralInformationController {
    @Autowired
    AssociationServiceImpl associationService;

    /**
     * @Title: listStudent
     * @Description: 查询综合信息
     * @param
     * @return: List<AssociationVO>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/17:00
     */
    @GetMapping("/selectAll")
    @ApiOperation(value = "查询综合信息", notes = "学号、姓名、年级、班级、年龄、班主任查询")
    public List<AssociationVO> selectAll(){
        return associationService.listAll();
    }

}
