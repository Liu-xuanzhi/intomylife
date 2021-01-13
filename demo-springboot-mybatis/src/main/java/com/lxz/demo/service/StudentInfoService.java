package com.lxz.demo.service;

/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2020/12/29/13:31
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.service
 * 文件描述: @Description: ${TODO}
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2020
 *
 ********************************************************/

import com.lxz.demo.entity.Student;
import com.lxz.demo.vo.query.StudentQryVO;
import com.lxz.demo.vo.request.SaveStudentReqVO;
import com.lxz.demo.vo.request.UpdateStudentReqVO;
import com.lxz.demo.vo.response.ResultRepVO;

import java.util.List;

/**
 * @author: liuxuanzhi 
 * @Date:  2020/12/29/13:35 
 */
public interface StudentInfoService {
    /**
     *  根据id获取单条数据
     *
     * @param id
     * @return: Student
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/29/13:49
     */
    Student getInfoStudentById (Integer id);

    /**
     * 获取所有数据
     * @param
     * @return:
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/16:39
     */
    List<StudentQryVO> listInfoStudent();

    /**
     *  获取名字学生
     *
     * @param name
     * @return: List<Student>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/29/13:50
     */
    List<StudentQryVO> listNameStudent(String name);

    /**
     * 获取class下的人
     *
     * @param team
     * @return: List<Student>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/29/13:50
     */
    List<StudentQryVO> listClassStudent(Integer team);

    /**
     * 获取年级下的人
     * @param grade
     * @return: List<Student>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/29/13:50
     */
    List<StudentQryVO> listGradeStudent(Integer grade);

    /**
     * 获取年龄下的人
     *
     * @param age
     * @return: List<Student>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/29/13:50
     */
    List<StudentQryVO> listAgeStudent(Integer age);

    /**
     *  添加学生
     * @param saveStudentReqVO
     * @return:null
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/29/15:59
     */
    ResultRepVO saveStudent(SaveStudentReqVO saveStudentReqVO);

    /**
     *  类说明：id修改名字，年龄，班级，年级
     * @param updateStudentReqVO
     * @return:    null
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/29/17:35
     */
    ResultRepVO updateStudent(UpdateStudentReqVO updateStudentReqVO);


    /**
     * 类说明： 删除Student  根据id  改变删除标记
     * @param id
     * @param updateUserId
     * @return: null
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/9:01
     */
    void deleteStudent(Integer id,String updateUserId);

    /**
     * 更新操作通过传student
     *
 * @param student
     * @return:    null
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/10:03
     */
    void saveStudent(Student student);

}
