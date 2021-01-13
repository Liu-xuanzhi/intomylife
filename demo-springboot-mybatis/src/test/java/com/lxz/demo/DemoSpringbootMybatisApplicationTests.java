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
import java.util.*;

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

//    @Test
//    public void addServiceTest(){
//        studentInfoService.addStudent("夏洛",2,5,23,"1");
//    }

//    @Test
////    public  void updateAllServiceTest(){
////        studentInfoService.saveStudent(10001,"李毅",24,"1",3,4);
//    }

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

    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int buyPrice = prices[0] + fee;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buyPrice){
                profit += prices[i] - buyPrice;
                buyPrice = prices[i];
            }else if(buyPrice > prices[i] + fee){
                buyPrice = prices[i] + fee;
            }
        }
        return profit;
    }
    @Test
    public void associationServiceTesta(){

        ListNode listNode = new ListNode(-129);
        listNode.next=new ListNode(-129);
//        listNode.next.next=new ListNode((3));
        System.out.println();
        System.out.println(isPalindrome(listNode));
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public boolean isPalindrome(ListNode head) {
        int i=0;
        ListNode load=head;
        List list = new ArrayList();

        while(load!=null){
            list.add(i,load.val);
            load=load.next;
            i++;
        }
        int l=list.size();
        if(l==0||l==1){
            return true;
        }
        if(l==2){
            System.out.println(list.get(0));
            System.out.println(list.get(1));
            if(list.get(0).equals(list.get(1))){
                return true;
            }else{
                return false;
            }
        }

        for(int a=0;a<l/2;a++){
            if(list.get(a)!=list.get(l-a-1)){
                return false;
            }

        }
        return true;
    }

    @Test
    public void intTest(){
        int a=Integer.MAX_VALUE;
        System.out.println(a);
        int b=Integer.MAX_VALUE;
        System.out.println(a+b);
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        TreeMap<String, String> treeMap = new TreeMap<String, String>();
        Collections.synchronizedMap()
        treeMap.comparator();
        int totalPrice = 0;
        int temp = prices[0];
        for (int i = 1; i < prices.length; i++) {
            //找一个最小的买入
            if (prices[i] < temp) {
                temp = prices[i];
            } else if (prices[i] > temp) {
                //只要出售股价比买入股价高，就比较一下是否能获取更大利润
                totalPrice = Math.max(totalPrice, prices[i] - temp);
            }
        }
        return totalPrice;
    }

    @Test
    public void gupiaoTest(){
        int[] i={7,1,5,3,6,4};
        System.out.println(maxProfit(i));
    }
}

