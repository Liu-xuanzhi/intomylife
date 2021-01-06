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
import com.lxz.demo.vo.response.StudentVO;

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
    List<StudentVO> listInfoStudent();

    /**
     *  获取名字学生
     *
     * @param name
     * @return: List<Student>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/29/13:50
     */
    List<StudentVO> listNameStudent(String name);

    /**
     * 获取class下的人
     *
     * @param team
     * @return: List<Student>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/29/13:50
     */
    List<StudentVO> listClassStudent(Integer team);

    /**
     * 获取年级下的人
     * @param grade
     * @return: List<Student>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/29/13:50
     */
    List<StudentVO> listGradeStudent(Integer grade);

    /**
     * 获取年龄下的人
     *
     * @param age
     * @return: List<Student>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/29/13:50
     */
    List<StudentVO> listAgeStudent(Integer age);

    /**
     *  添加学生
     * @param name,
     * @param  team,
     * @param grade,
     * @param age,
     * @param createUserId
     * @return:null
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/29/15:59
     */
    void addStudent(String name,Integer team,Integer grade,Integer age,String createUserId);

    /**
     *  类说明：id修改名字，年龄，班级，年级
     * @param id
     * @param name
     * @param age
     * @param updateUserId
     * @param team
     * @param grade
     * @return:    null
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/29/17:35
     */
    void saveStudent(Integer id,String name,Integer age,String updateUserId,Integer team,Integer grade);


    /**
     * 类说明： 删除Student  根据id  改变删除标记
     * @param id
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
