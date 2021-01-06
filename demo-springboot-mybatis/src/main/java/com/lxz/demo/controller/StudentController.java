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
import com.lxz.demo.vo.response.ResultVO;
import com.lxz.demo.vo.response.StudentVO;
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
    ResultVO resultVO;

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
    public List<StudentVO> listStudent(){
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
    public List<StudentVO> listAgeStudent(@RequestParam Integer age){
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
    public List<StudentVO> listClassStudent(@ApiParam(value = "根据team获取学生信息") @RequestParam Integer team){
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
    public List<StudentVO> listGradeStudent(@ApiParam(value = "根据grade获取学生信息") @RequestParam Integer grade){
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
    public List<StudentVO> listNameStudent(@ApiParam(value = "根据name获取学生信息") @RequestParam String name){
        return studentInfoService.listNameStudent(name);
    }

    /**
     * @Title: updateStudent
     * @Description: 全信息更新
     * @param id,name,age,updateUserId,team,grade
     * @return: String
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/17:02
     */
    @PostMapping("/saveStudent")
    @ApiOperation(value = "全信息更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", dataType = "int",required = true),
            @ApiImplicitParam(name = "name", value = "名字", dataType = "String"),
            @ApiImplicitParam(name = "age", value = "年龄", dataType = "int"),
            @ApiImplicitParam(name = "updateUserId", value = "更新用户ID", dataType = "String"),
            @ApiImplicitParam(name = "team", value = "班级", dataType = "int"),
            @ApiImplicitParam(name = "grade", value = "年级", dataType = "int")
    })
    public ResultVO saveStudent(@ApiParam(value = "根据id更新学生信息") @RequestBody Integer id, String name, Integer age, String updateUserId, Integer team, Integer grade){
        try {
            studentInfoService.saveStudent(id, name, age, updateUserId, team, grade);
        }catch (Exception e){
            e.printStackTrace();
            resultVO.setMessage("更新失败，原因："+e.getMessage());
            resultVO.setSuccess(false);
            return resultVO;
        }
        resultVO.setSuccess(true);
        resultVO.setMessage("更新成功");
        return resultVO;
    }

    /**
     * @Title: addStudent
     * @Description: 全信息添加
     * @param name,age,updateUserId,team,grade
     * @return: String
     * @throws
     * @author: liuxuanzhi
     * @Date:  2020/12/30/17:02
     */
    @PostMapping("/addStudent")
    @ApiOperation(value = "添加学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名字", dataType = "string",required = true),
            @ApiImplicitParam(name = "age", value = "年龄", dataType = "int",required = true),
            @ApiImplicitParam(name = "createUserId", value = "创建用户ID", dataType = "string",required = true),
            @ApiImplicitParam(name = "team", value = "班级", dataType = "int",required = true),
            @ApiImplicitParam(name = "grade", value = "年级", dataType = "int",required = true)
    })
    public ResultVO addStudent(@ApiParam(value = "添加学生信息") @RequestBody String name, Integer team, Integer grade, Integer age, String createUserId){
        try {
            studentInfoService.addStudent(name, team, grade, age, createUserId);
        }catch (Exception e){
            e.printStackTrace();
            resultVO.setMessage("添加失败，原因："+e.getMessage());
            resultVO.setSuccess(false);
            return resultVO;
        }
        resultVO.setSuccess(true);
        resultVO.setMessage("添加成功");
        return resultVO;
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
    public ResultVO deleteStudent(@ApiParam(value = "删除学生信息") @RequestBody Integer id, String updateUserId){
        try {
            studentInfoService.deleteStudent(id, updateUserId);
        }catch (Exception e){
            e.printStackTrace();
            resultVO.setMessage("删除失败，原因："+e.getMessage());
            resultVO.setSuccess(false);
            return resultVO;
        }
        resultVO.setSuccess(true);
        resultVO.setMessage("删除成功");
        return resultVO;
    }

}
