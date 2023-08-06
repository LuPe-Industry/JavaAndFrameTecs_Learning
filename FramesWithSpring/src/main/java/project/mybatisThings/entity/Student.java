package project.mybatisThings.entity;

import java.io.Serializable;
import lombok.Data;
@Data
public class Student implements Serializable {
    private String name;
    private String age;
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Student{" +
                "STU_NAME='" + name + '\'' +
                ", STU_AGE='" + age + '\'' +
                '}';
    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }
}