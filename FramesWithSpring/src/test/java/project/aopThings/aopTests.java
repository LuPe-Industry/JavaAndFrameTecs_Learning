package project.aopThings;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.springThings.springAOP.services.service1;
import project.springThings.springAOP.services.service2;

@SpringBootTest
public class aopTests {
    @Autowired
    private service1 s1;
    @Autowired
    private service2 s2;

    @Test
    public void test1(){
        s1.rap1();
    }

    @Test
    public void test2(){
        s2.rap2();
    }
}
