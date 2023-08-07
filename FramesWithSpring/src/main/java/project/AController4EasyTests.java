package project;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.StreamHandler;

@RestController
@RequestMapping("/appController")
public class AController4EasyTests implements ApplicationContextAware {
    private ApplicationContext app;

    /*
    * 注入Spring核心
    * 注意使用implements ApplicationContextAware
    * */
    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        this.app = applicationContext;
    }

    @RequestMapping("/yes")
    public String  fun(){
        System.out.println("yes");

        ProcessBuilder processBuilder = new ProcessBuilder();
        return "yes";

    }



}
