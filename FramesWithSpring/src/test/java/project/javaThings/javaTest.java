package project.javaThings;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class javaTest {
    @Test
    public void test01(){
        Machine machine = new Car();

    }

    @Test
    public void test02(){
        HashSet<Car> cars = new HashSet<>();
        Car car1 = new Car();
        Car car2 = new Car();
        cars.add(car2);
        cars.add(car1);
        System.out.println(cars);

        cars.remove(car2);
        System.out.println(cars);



    }
}
