package project.kafkaThings;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.projectDomains.Person;

@SpringBootTest
public class KafkaTest {

    @Autowired
    private KafkaProducerService kafkaProducerService;
//    @Test
//    public void test01(){
//        Person lupe = new Person("lupe", 18);
//        kafkaProducerService.sendMessage("test","fine baby");
//    }
}
