package com.lxz.demo.service.impl;/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2020/12/29/13:53
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.service.impl
 * 文件描述: @Description: 实现StudentInfoService接口
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2020
 *
 ********************************************************/

import com.alibaba.fastjson.JSON;
import com.lxz.demo.dao.StudentMapper;
import com.lxz.demo.entity.Student;
import com.lxz.demo.entity.StudentExample;
import com.lxz.demo.service.StudentInfoService;
import com.lxz.demo.vo.response.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 包名称： com.lxz.demo.service.impl
 * 类名称：StudentInfoServiceImpl
 * 类描述：实现StudentInfoService接口
 * 创建人：@author liuxuanzhi
 * 创建时间：2020/12/29/13:53
 */

@Service
public class StudentInfoServiceImpl implements StudentInfoService {
    String NOT_DELETE = "0";
    String DELETE = "1";

    @Resource
    StudentMapper studentMapper;

    @Autowired
    StudentExample studentExample;

    @Override
    public Student getInfoStudentById(Integer id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        return student;
    }

    /**
     * @Title: copyList
     * @Description: 用来转换list属性赋值给实体类
     *
 * @param list tClass
     * @return:    <T>List
     * @throws
     * @author: liuxuanzhi
     * @Date:  2021/1/4/15:28
     */

    /**
     * @Title: copyList
     * @Description: 将集合中的数据转换成理想数据类型
 * @param list 要转换的集合
     * @param tClass 目标类
     * @return:  <T>List
     * @throws
     * @author: liuxuanzhi
     * @Date:  2021/1/5/15:34
     */


    public static <T> List copyList(List<T> list,Class tClass) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList();
        }
        return JSON.parseArray(JSON.toJSONString(list), tClass);
    }


    @Override
    public List<StudentVO> listInfoStudent() {
        studentExample.clear();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
        List<Student> students = studentMapper.selectByExample(studentExample);
        return copyList(students,StudentVO.class);
    }

    @Override
    public List<StudentVO> listNameStudent(String name) {
        studentExample.clear();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
        criteria.andNameEqualTo(name);

        List<Student> students = studentMapper.selectByExample(studentExample);
        return copyList(students,StudentVO.class);
    }

    @Override
    public List<StudentVO> listClassStudent(Integer team) {
        studentExample.clear();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
        criteria.andTeamEqualTo(team);

        List<Student> students = studentMapper.selectByExample(studentExample);
        return copyList(students,StudentVO.class);
    }

    @Override
    public List<StudentVO> listGradeStudent(Integer grade) {
        studentExample.clear();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
        criteria.andGradeEqualTo(grade);

        List<Student> students = studentMapper.selectByExample(studentExample);
        return copyList(students,StudentVO.class);
    }

    @Override
    public List<StudentVO> listAgeStudent(Integer age) {
        studentExample.clear();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
        criteria.andAgeEqualTo(age);

        List<Student> students = studentMapper.selectByExample(studentExample);
        return copyList(students,StudentVO.class);
    }

    @Override
    public void addStudent(String name, Integer team, Integer grade, Integer age, String createUserId) {
        LocalDateTime createDateTime = LocalDateTime.now();
        Date createTime = Date.from(createDateTime.atZone(ZoneId.systemDefault()).toInstant());
        //对应班级数据字典
        Integer teamid=team+(grade-1)*3;
        Student student = new Student();
        student.setName(name);
        student.setTeam(teamid);
        student.setGrade(grade);
        student.setAge(age);
        student.setCreateTime(createTime);
        student.setCreateUserId(createUserId);
        studentMapper.insertSelective(student);
    }

    @Override
    public void saveStudent(Integer id, String name, Integer age, String updateUserId, Integer team, Integer grade) {
        studentExample.clear();
        LocalDateTime updateDateTime= LocalDateTime.now();
        Date updateTime = Date.from(updateDateTime.atZone(ZoneId.of("Asia/Shanghai")).toInstant());
        StudentExample.Criteria criteria = studentExample.createCriteria();
        //对应班级数据字典
        Integer teamid=team+(grade-1)*3;
        criteria.andIdEqualTo(id);
        Student student = new Student();
        student.setName(name);
        student.setTeam(teamid);
        student.setGrade(grade);
        student.setAge(age);
        student.setUpdateTime(updateTime);
        student.setUpdateUserId(updateUserId);
        studentMapper.updateByExampleSelective(student,studentExample);
    }

    @Override
    public void deleteStudent(Integer id,String updateUserId) {
        studentExample.clear();
        LocalDateTime updateDateTime= LocalDateTime.now();
        Date updateTime = Date.from(updateDateTime.toInstant(ZoneOffset.of("+8")));
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andIdEqualTo(id);
        Student student=new Student();
        student.setDeleteFlag(Long.parseLong(DELETE));
        student.setUpdateTime(updateTime);
        student.setUpdateUserId(updateUserId);
        studentMapper.updateByExampleSelective(student,studentExample);
    }

    @Override
    public void saveStudent(Student student) {
        studentExample.clear();
        LocalDateTime updateDateTime= LocalDateTime.now();
        Date updateTime = Date.from(updateDateTime.atZone(ZoneId.of("Asia/Shanghai")).toInstant());
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andIdEqualTo(student.getId());
        student.setUpdateTime(updateTime);
        studentMapper.updateByExampleSelective(student,studentExample);
    }


}
