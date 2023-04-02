package project.springEventListen;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("eventController")
@RequestMapping("/event")
public class myController implements ApplicationContextAware {
    private ApplicationContext app;
    @RequestMapping("/fun")
    public void fun(){
        //假设从前端拿到了一个数据包Res
        Resource res = new Resource("1", "25");
        //用spring容器发布一个事件
        app.publishEvent(new AEvent(res));
        app.publishEvent(new AEvent2<Resource>(res));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.app = applicationContext;
    }
}
