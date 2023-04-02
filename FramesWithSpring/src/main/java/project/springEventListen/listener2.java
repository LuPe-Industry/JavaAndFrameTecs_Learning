package project.springEventListen;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class listener2 {
    @EventListener
    public void onApplicationEvent(AEvent event) {//3.
        event.Event1();
    }


    @EventListener
    public void onApplicationEvent2(AEvent2 event) {//3.
        event.Event2();
    }


}
