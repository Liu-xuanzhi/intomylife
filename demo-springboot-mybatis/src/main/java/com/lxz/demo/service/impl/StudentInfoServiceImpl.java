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
import com.lxz.demo.dao.GradeMapper;
import com.lxz.demo.dao.StudentMapper;
import com.lxz.demo.dao.TeamMapper;
import com.lxz.demo.entity.*;
import com.lxz.demo.service.StudentInfoService;
import com.lxz.demo.vo.query.StudentQryVO;
import com.lxz.demo.vo.request.SaveStudentReqVO;
import com.lxz.demo.vo.request.UpdateStudentReqVO;
import com.lxz.demo.vo.response.ResultRepVO;
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

    @Resource
    GradeMapper gradeMapper;

    @Autowired
    TeamExample teamExample;

    @Autowired
    ResultRepVO resultRepVO;

    @Autowired
    TeamServiceImpl teamService;

    @Override
    public Student getInfoStudentById(Integer id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        return student;
    }

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
    public List<StudentQryVO> listInfoStudent() {
        try {
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
            List<Student> students = studentMapper.selectByExample(studentExample);
            return copyList(students, StudentQryVO.class);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            studentExample.clear();
        }
        return null;
    }

    @Override
    public List<StudentQryVO> listNameStudent(String name) {
        try {
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
            criteria.andNameEqualTo(name);

            List<Student> students = studentMapper.selectByExample(studentExample);
            return copyList(students, StudentQryVO.class);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            studentExample.clear();
        }
            return null;
    }

    @Override
    public List<StudentQryVO> listClassStudent(Integer team) {
        try{
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
            criteria.andTeamEqualTo(team);

            List<Student> students = studentMapper.selectByExample(studentExample);
            return copyList(students, StudentQryVO.class);
         }catch (Exception e){
            e.printStackTrace();
        }finally {
            studentExample.clear();
        }
        return null;
    }

    @Override
    public List<StudentQryVO> listGradeStudent(Integer grade) {
        try {
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
            criteria.andGradeEqualTo(grade);

            List<Student> students = studentMapper.selectByExample(studentExample);
            return copyList(students, StudentQryVO.class);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            studentExample.clear();
        }
        return null;
    }

    @Override
    public List<StudentQryVO> listAgeStudent(Integer age) {
        try {
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andDeleteFlagEqualTo(Long.parseLong(NOT_DELETE));
            criteria.andAgeEqualTo(age);

            List<Student> students = studentMapper.selectByExample(studentExample);
            return copyList(students, StudentQryVO.class);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            studentExample.clear();
        }
        return null;
    }

    @Override
    public ResultRepVO saveStudent(SaveStudentReqVO saveStudentReqVO) {
        try {
            if(gradeMapper.selectByPrimaryKey(saveStudentReqVO.getGrade()) == null){
                resultRepVO.setSuccess(false);
                resultRepVO.setMessage("年级不存在");
                return resultRepVO;
            }
            if(teamService.teamListByGrade(saveStudentReqVO.getGrade(),saveStudentReqVO.getTeam()).isEmpty()){
                resultRepVO.setSuccess(false);
                resultRepVO.setMessage("班级不存在");
                return resultRepVO;
            }
            LocalDateTime createDateTime = LocalDateTime.now();
            Date createTime = Date.from(createDateTime.atZone(ZoneId.systemDefault()).toInstant());
            //对应班级数据字典
            Integer teamId = saveStudentReqVO.getTeam() + (saveStudentReqVO.getGrade() - 1) * 3;
            Student student = saveStudentReqVO.studentValueOf();
            student.setTeam(teamId);
            student.setCreateTime(createTime);
            studentMapper.insertSelective(student);
            resultRepVO.setMessage("成功");
            resultRepVO.setSuccess(true);
            return resultRepVO;
        }catch (Exception e){
            e.printStackTrace();
            resultRepVO.setMessage("内部错误");
            resultRepVO.setSuccess(false);
            return resultRepVO;
        }

    }

    @Override
    public ResultRepVO updateStudent(UpdateStudentReqVO updateStudentReqVO) {
        try {
            if(gradeMapper.selectByPrimaryKey(updateStudentReqVO.getGrade()) == null){
                resultRepVO.setSuccess(false);
                resultRepVO.setMessage("年级不存在");
                return resultRepVO;
            }
            if(teamService.teamListByGrade(updateStudentReqVO.getGrade(),updateStudentReqVO.getTeam()).isEmpty()){
                resultRepVO.setSuccess(false);
                resultRepVO.setMessage("班级不存在");
                return resultRepVO;
            }

            LocalDateTime updateDateTime = LocalDateTime.now();
            Date updateTime = Date.from(updateDateTime.atZone(ZoneId.of("Asia/Shanghai")).toInstant());
            StudentExample.Criteria criteria = studentExample.createCriteria();
            //对应班级数据字典
            Integer teamId = updateStudentReqVO.getTeam() + (updateStudentReqVO.getGrade() - 1) * 3;
            criteria.andIdEqualTo(updateStudentReqVO.getId());
            Student student = updateStudentReqVO.studentValueOf();
            student.setTeam(teamId);
            student.setUpdateTime(updateTime);
            studentMapper.updateByExampleSelective(student, studentExample);
            resultRepVO.setMessage("成功");
            resultRepVO.setSuccess(true);
            return resultRepVO;
        }catch (Exception e){
            e.printStackTrace();
            resultRepVO.setMessage("内部错误");
            resultRepVO.setSuccess(false);
            return resultRepVO;
        }finally {
            studentExample.clear();
        }

    }

    @Override
    public void deleteStudent(Integer id, String updateUserId) {
        try {
            LocalDateTime updateDateTime = LocalDateTime.now();
            Date updateTime = Date.from(updateDateTime.toInstant(ZoneOffset.of("+8")));
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andIdEqualTo(id);
            Student student = new Student();
            student.setDeleteFlag(Long.parseLong(DELETE));
            student.setUpdateTime(updateTime);
            student.setUpdateUserId(updateUserId);
            studentMapper.updateByExampleSelective(student, studentExample);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            studentExample.clear();
        }
    }

    @Override
    public void saveStudent(Student student) {
        try {
            LocalDateTime updateDateTime = LocalDateTime.now();
            Date updateTime = Date.from(updateDateTime.atZone(ZoneId.of("Asia/Shanghai")).toInstant());
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andIdEqualTo(student.getId());
            student.setUpdateTime(updateTime);
            studentMapper.updateByExampleSelective(student, studentExample);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            studentExample.clear();
        }
    }


}
