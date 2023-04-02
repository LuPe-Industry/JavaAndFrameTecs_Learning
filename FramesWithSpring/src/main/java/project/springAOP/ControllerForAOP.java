package project.springAOP;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/AOP")
public class ControllerForAOP {

    @RequestMapping("/test1")
    public void AOPTest1(){
        MyRunning2.function1();
    }


}
