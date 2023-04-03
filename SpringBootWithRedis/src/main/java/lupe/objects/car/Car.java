package lupe.objects.car;

import java.io.Serializable;

public class Car implements Serializable {
    private String name;
    private String age;

    private Wheel wheel;


    public Car(String name, String age, Wheel wheel) {
        this.name = name;
        this.age = age;
        this.wheel = wheel;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", wheel=" + wheel +
                '}';
    }
}
