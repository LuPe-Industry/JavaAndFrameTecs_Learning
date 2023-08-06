package project.springThings.springAnnotation.Component;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //代表这是个配置类
/*
* 注意@Configurable这个注解 上面的Configuration代表本类是个配置类,而Configurable注解的作用是:
* 加入有个我自己写的类,没有被spring管理,但是类里面需要用到springBean,可以使用这个注解放在头上,下面直接Autowire Resource自动注入 就可以用啦 牛得很
 * */
@ComponentScan("crazylupe.project.springAnnotation.Component") //扫描哪个包下的所有类
public class springConfig {
}
