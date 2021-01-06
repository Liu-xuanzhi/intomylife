package com.lxz.demo.service;

import com.lxz.demo.vo.response.AssociationVO;
import java.util.List;

/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2021/1/4/16:27
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.service
 * 文件描述: @Description: ${联立查询操作}
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2021
 *
 ********************************************************/
public interface AssociationService {
    /**
     * 联立获取所有数据  并将返回值转换成AssociationVO
     * @param
     * @return: List<AssociationVO>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/16:39
     */
    List<AssociationVO> listAll();
}


