package project.mybatisThings.mapper;

import org.apache.ibatis.annotations.Mapper;
import project.mybatisThings.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;

/**
* @author 76655
* @description 针对表【student】的数据库操作Mapper
* @createDate 2023-07-02 20:06:14
* @Entity project/mybatis.entity.Student
*/

@Mapper
public interface StudentMapper {

    ArrayList<Student> selectAll();

    HashMap<String,String> select02(String name);

    int insertMultipleStudents(ArrayList<Student> list);

}
