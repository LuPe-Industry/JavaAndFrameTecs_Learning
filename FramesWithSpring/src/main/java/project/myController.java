package project;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yes")
public class myController implements ApplicationContextAware {
    private ApplicationContext app;

    @RequestMapping("/good")
    public void  fun(){
//        System.out.println(project.app);
//        Object project.myController = project.app.getBean("project.myController");
//        System.out.println(project.myController);
//        Object myDog = app.getBean("myDog");
//        System.out.println(myDog);
//        Object myCar = app.getBean("car");
//        System.out.println(myCar);
//        Object myCar2 = app.getBean("myCar2");
//        System.out.println(myCar2);
        System.out.println("yes");

        //创建一个包含1到10的随机数数组




    }


    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        this.app = applicationContext;
    }
}
