package project.springMultiThread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.context.Theme;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/threadPool")
public class MultiThreadController {

    @Autowired
    private MultiThreadService service;


    /*
    * 1.结合useSpringItselfPool与useMyPool方法，发现：
    * service中使用的：1.spring自带的线程池 与 2.我引用spring线程池自己设立的线程池是同一个
    * 解释：spring的线程池为懒加载模式 带@Lazy注释 所以我引用初始化后它就激活了
    *
    *
    * */


    @RequestMapping("springPool")
    public String  useSpringItselfPool(){

        System.out.println(Thread.currentThread().getName());
        service.useSpringItselfPool();
        return "useSpringItselfPool";
    }

    @RequestMapping("myPool")
    public String  useMyPool(){
        service.useMyPool();
        return "useMyPool";
    }

    @RequestMapping("/useJavaPool")
    public void useJavaPool(){
        service.useJavaPool();
    }
}
