package com.lxz.demo.service.impl;/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2021/1/5/14:23
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.service.impl
 * 文件描述: @Description: 联立查询  并将返回数据转换为VO
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2021
 *
 ********************************************************/

import com.lxz.demo.dao.StudentMapper;
import com.lxz.demo.entity.Student;
import com.lxz.demo.service.AssociationService;
import com.lxz.demo.vo.query.AssociationQryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 包名称： com.lxz.demo.service.impl
 * 类名称：AssociationServiceImpl
 * 类描述：联立查询  并将返回数据转换为VO
 * 创建人：@author liuxuanzhi
 * 创建时间：2021/1/5/14:23
 */

@Service
public class AssociationServiceImpl implements AssociationService {
    @Resource
    StudentMapper studentMapper;

    @Override
    public List<AssociationQryVO> listAll() {
        List<AssociationQryVO> listAssociationQryVO =new ArrayList<>();
        List<Student> students = studentMapper.selectAll();
        for(int i=0;i<students.size();i++){
            AssociationQryVO associationQryVO = new AssociationQryVO();
            associationQryVO.setSid(students.get(i).getId());
            associationQryVO.setName(students.get(i).getName());
            associationQryVO.setAge(students.get(i).getAge());
            associationQryVO.setGrade(students.get(i).getGradeList().get(0).getName());
            associationQryVO.setTeam(students.get(i).getGradeList().get(0).getTeam().getName());
            associationQryVO.setTeacher(students.get(i).getGradeList().get(0).getTeam().getTeacher());
            System.out.println(associationQryVO.toString());
            listAssociationQryVO.add(i, associationQryVO);
        }
        return listAssociationQryVO;
    }

}
