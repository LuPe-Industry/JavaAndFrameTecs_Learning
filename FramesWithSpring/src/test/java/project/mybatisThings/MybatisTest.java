package project.mybatisThings;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project.mybatisThings.entity.Cpu;
import project.mybatisThings.entity.Gpu;
import project.mybatisThings.entity.Student;
import project.mybatisThings.mapper.AllTestMapper;
import project.mybatisThings.mapper.StudentMapper;
import project.mybatisThings.vo.Bundle1;
import project.mybatisThings.vo.Bundle2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class MybatisTest {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private AllTestMapper allTestMapper;

    @Test
    public void test01(){
        ArrayList<Student> students = studentMapper.selectAll();
        System.out.println(students);
    }

    @Test
    public void test02(){
        HashMap<String, String> map = studentMapper.select02("junda");
        System.out.println(map);
    }

    @Test
    public  void  test03(){
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("bird", "12"));
        list.add(new Student("goose", "13"));
        int i = studentMapper.insertMultipleStudents(list);
        if (i!=0) {
            System.out.println("success  and  " + i);
        }else {
            System.out.println("fail");
        }
    }

    //查一个表，但是结果分成两个对象展示（只会查到一个记录）
    @Test
    public  void  test04(){
        Bundle1 bundle1 = allTestMapper.selectBundle1();
        Cpu cpu = bundle1.getCpu();
        Gpu gpu = bundle1.getGpu();
        System.out.println(cpu);
        System.out.println(gpu);
    }

    //查一个表，但是结果分成两个对象展示（会查到多个记录）
    @Test
    public  void  test05(){
        Bundle2 bundle = allTestMapper.multipleBundle();
        System.out.println(bundle);
    }

    /*
    * 插入一个数据，看自增情况
    * */
    @Test
    public void test06(){
        int intel1000 = allTestMapper.insertOneCpu(new Cpu("1000", "intel1000", "123"));
        System.out.println(intel1000);
    }

    @Test
    public void test07(){
        LinkedList<Cpu> cpus = new LinkedList<>();
        cpus.add(new Cpu("100","intel1","123"));
        cpus.add(new Cpu("001","intel2","123"));
        cpus.add(new Cpu("200","intel3","123"));
        int i = allTestMapper.insertMultipleCpu(cpus);
        System.out.println("成功与否？："+i);

    }

    @Test
    public void test08(){
        List<Cpu> intel = allTestMapper.selectSomeCpu("intel");
        System.out.println(intel);
    }

    /*
    * 插入一条数据，库表是自增的
    * 目的：获取它自增的id
    * */
    @Test
    public void test09(){
        Cpu amd7600 = new Cpu("1000", "amd7800", "4567");
        int i = allTestMapper.insertOneCpuSpecial02(amd7600);
        System.out.println(amd7600.getId());
    }

    @Test
    public void test10(){

    }
    /*
    * 使用hashmap插入
    * */
    @Test
    @Transactional
    public void test11(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("cpuPrice","1000");
        map.put("cpuName","amd1234");
        map.put("cpuPerformance","3000");
        int i = allTestMapper.insertCpuWithMap(map);
        System.out.println(map.get("id"));

    }

    @Test
    public void test12(){

    }
    @Test
    public void test13(){

    }

    @Test
    public void test14(){

    }

    @Test
    public void test15(){

    }
    @Test
    public void test16(){

    }
    @Test
    public void test17(){

    }
    @Test
    public void test18(){

    }




}
