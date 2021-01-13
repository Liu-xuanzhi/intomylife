package com.lxz.demo.controller;/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2020/12/30/16:19
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.controller
 * 文件描述: @Description: 学生控制层：增删查改
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2020
 *
 ********************************************************/

import com.lxz.demo.entity.Student;
import com.lxz.demo.service.StudentInfoService;
import com.lxz.demo.vo.request.SaveStudentReqVO;
import com.lxz.demo.vo.request.UpdateStudentReqVO;
import com.lxz.demo.vo.response.ResultRepVO;
import com.lxz.demo.vo.query.StudentQryVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 包名称： com.lxz.demo.controller
 * 类名称：StudentController
 * 类描述：学生控制层：增删查改
 * 创建人：@author liuxuanzhi
 * 创建时间：2020/12/30/16:19
 */

@RestController
@Api(tags="学生管理")
public class StudentController {
    @Autowired
    StudentInfoService studentInfoService;

    @Autowired
    ResultRepVO resultRepVO;

    /**
     * @Title: getStudentById
     * @Description: 根据id获取学生全部信息
     * @param id
     * @return:    Student
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/16:59
     */
    @GetMapping("/getStudentById")
    @ApiOperation(value = "根据id获取学生信息")
    @ApiImplicitParam(name = "id", value = "编号", dataType = "int",required = true)
    public Student getStudentById(@RequestParam Integer id){
        return studentInfoService.getInfoStudentById(id);
    }

    /**
     * @Title: listStudent
     * @Description: 查询所有未被删除学生
     * @param
     * @return: List<Student>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/17:00
     */
    @GetMapping("/listStudent")
    @ApiOperation(value = "查询所有未被删除学生", notes = "列表查询")
    public List<StudentQryVO> listStudent(){
        System.out.println("all");
        return studentInfoService.listInfoStudent();
    }

    /**
     * @Title: listAgeStudent
     * @Description: 通过年龄获取信息
     * @param age
     * @return:    List<Student>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/17:02
     */
    @GetMapping("/listStudentByAge")
    @ApiOperation(value = "根据age获取学生信息")
    @ApiImplicitParam(name = "age", value = "年龄", dataType = "int",required = true)
    public List<StudentQryVO> listAgeStudent(@RequestParam Integer age){
        return studentInfoService.listAgeStudent(age);
    }

    /**
     * @Title: listClassStudent
     * @Description: 通过班级获取信息
     * @param team
     * @return:    List<Student>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/17:02
     */
    @GetMapping("/listStudentByClass")
    @ApiOperation(value = "通过班级获取信息")
    @ApiImplicitParam(name = "team", value = "班级", dataType = "int",required = true)
    public List<StudentQryVO> listClassStudent(@ApiParam(value = "根据team获取学生信息") @RequestParam Integer team){
        return studentInfoService.listClassStudent(team);
    }

    /**
     * @Title: listGradeStudent
     * @Description: 通过年级获取信息
     * @param grade
     * @return:    List<Student>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/17:02
     */
    @GetMapping("/listStudentByGrade")
    @ApiOperation(value = "通过年级获取信息")
    @ApiImplicitParam(name = "grade", value = "年级", dataType = "int",required = true)
    public List<StudentQryVO> listGradeStudent(@ApiParam(value = "根据grade获取学生信息") @RequestParam Integer grade){
        return studentInfoService.listGradeStudent(grade);
    }

    /**
     * @Title: listNameStudent
     * @Description: 通过名字获取信息
     * @param name
     * @return:    List<Student>
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/17:02
     */
    @GetMapping("/listStudentByName")
    @ApiOperation(value = "通过名字获取信息")
    @ApiImplicitParam(name = "name", value = "名字", dataType = "string",required = true)
    public List<StudentQryVO> listNameStudent(@ApiParam(value = "根据name获取学生信息") @RequestParam String name){
        return studentInfoService.listNameStudent(name);
    }

    /**
     * @Title: updateStudent
     * @Description: 全信息更新
     * @param updateStudentReqVO
     * @return: String
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/17:02
     */
    @PostMapping("/updateStudent")
    @ApiOperation(value = "全信息更新")
    public ResultRepVO updateStudent(@ApiParam(value = "根据id更新学生信息") @RequestBody UpdateStudentReqVO updateStudentReqVO){

        resultRepVO = studentInfoService.updateStudent(updateStudentReqVO);

        return resultRepVO;
    }

    /**
     * @Title: saveStudent
     * @Description: 全信息添加
     * @param saveStudentReqVO
     * @return: String
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/17:02
     */
    @PostMapping("/saveStudent")
    @ApiOperation(value = "添加学生信息")
    public ResultRepVO saveStudent(@ApiParam(value = "添加学生信息") @RequestBody SaveStudentReqVO saveStudentReqVO){

        resultRepVO = studentInfoService.saveStudent(saveStudentReqVO);

        return resultRepVO;
    }

    /**
     * @Title: deleteStudent
     * @Description: 删除学生
     * @param id,updateUserId
     * @return: String
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/17:02
     */
    @PostMapping("/deleteStudent")
    @ApiOperation(value = "根据id删除学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", dataType = "int",required = true),
            @ApiImplicitParam(name = "updateUserId", value = "更新用户ID", dataType = "String",required = true)
    })
    public ResultRepVO deleteStudent(@ApiParam(value = "删除学生信息") @RequestBody Integer id, String updateUserId){
        try {
            studentInfoService.deleteStudent(id, updateUserId);
        }catch (Exception e){
            e.printStackTrace();
            resultRepVO.setMessage("删除失败，原因："+e.getMessage());
            resultRepVO.setSuccess(false);
            return resultRepVO;
        }
        resultRepVO.setSuccess(true);
        resultRepVO.setMessage("删除成功");
        return resultRepVO;
    }

}
