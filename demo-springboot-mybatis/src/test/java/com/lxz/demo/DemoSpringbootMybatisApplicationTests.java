package com.lxz.demo;

import com.lxz.demo.dao.StudentMapper;
import com.lxz.demo.entity.Student;
import com.lxz.demo.entity.StudentExample;
import com.lxz.demo.service.impl.AssociationServiceImpl;
import com.lxz.demo.service.impl.StudentInfoServiceImpl;
import com.lxz.demo.service.impl.TeamServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import static org.assertj.core.util.DateUtil.parse;

@SpringBootTest
class DemoSpringbootMybatisApplicationTests {

    @Autowired
    StudentMapper student;

    @Autowired
    StudentExample ex;

    @Autowired
    StudentInfoServiceImpl studentInfoService;

    @Autowired
    TeamServiceImpl teamService;

    @Autowired
    AssociationServiceImpl associationServiceImpl;


    @Test
    void contextLoads() {
    }

    @Test
    public void selectByIdDaoTest(){
        Student s=student.selectByPrimaryKey(10000);
        System.out.println(s.toString());
    }

    @Test
    public void selectAllDaoTest(){
        List<Student> s= student.selectByExample(ex);
        System.out.println(s.toArray().toString());
    }

    @Test
    public void selectByNameDaoTest(){
        StudentExample.Criteria x= ex.createCriteria();
        x.andNameEqualTo("张三");
        List<Student> s=student.selectByExample(ex);
        System.out.println(s.toArray().toString());
    }

    @Test
    public void selectByNameServiceTest(){
        System.out.println(studentInfoService.listNameStudent("张三").toArray().toString());
    }

    @Test
    public void selectByTeamServiceTest(){
        System.out.println((studentInfoService.listClassStudent(1).toArray().toString()));
    }

    @Test
    public void addDaoTest(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date createTime=parse(df.format(new Date()));
        Student s=new Student();
        s.setCreateTime(createTime);
        s.setAge(21);
        s.setName("蒋斌");
        s.setTeam(2);
        s.setGrade(5);
        s.setCreateUserId("1");
        int line=student.insertSelective(s);
        System.out.println(line);
    }

    @Test
    public void addServiceTest(){
        studentInfoService.addStudent("夏洛",2,5,23,"1");
    }

    @Test
    public  void updateAllServiceTest(){
        studentInfoService.saveStudent(10001,"李毅",24,"1",3,4);
    }

    @Test
    public void deleteServiceTest(){
        studentInfoService.deleteStudent(10000,"1");
    }

    @Test
    public void timeTest(){
        LocalDateTime createDateTime= LocalDateTime.now();
        Date createTime=Date.from(createDateTime.toInstant(ZoneOffset.of("+8")));
        System.out.println(createTime.toString());
    }

    @Test
    public void listAlLTest(){
        System.out.println(studentInfoService.listInfoStudent().toArray().toString());
    }

    @Test
    public void listClassByName(){
        System.out.println(teamService.listClassByTeacher("孙策").toString());
    }

    @Test
    public void associationTest() {
        List<Student> associationVO = student.selectAll();
        System.out.println(associationVO.toString());
        System.out.println(associationVO.get(1).getGradeList().get(0).getName());
    }

    @Test
    public void associationServiceTesta(){
        System.out.println(associationServiceImpl.listAll().toArray().toString());
    }
}

