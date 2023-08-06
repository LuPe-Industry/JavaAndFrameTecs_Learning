package project.springThings.springEventListen;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class listener1 implements ApplicationListener<AEvent> {
    @Override
    public void onApplicationEvent(AEvent event) {
        event.Event1();
    }
}
