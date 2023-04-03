package lupe.springbootwithredis;

import lupe.objects.car.Car;
import lupe.objects.car.Wheel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringBootWithRedisApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplateForString;

    @Autowired
    private RedisTemplate redisTemplate;


    /*
     * 操作String类型
     * */
    @Test
    void test() throws InterruptedException {

        //ab
        redisTemplateForString.opsForValue().set("a", "b");
        redisTemplateForString.opsForValue().set("c", "d");
        redisTemplateForString.opsForValue().set("e", "f");



        //修改Value
        BoundValueOperations aBounder = redisTemplateForString.boundValueOps("a");
        aBounder.set("cccc");

        //尾部追加字符串
        Integer aasdf = aBounder.append("aasdf");
        System.out.println(aasdf);
        System.out.println("添加aasdf 应该是ccccaasdf才对:" + aBounder.get());

        //定时删除
        redisTemplateForString.opsForValue().set("num", "123", 10L, TimeUnit.SECONDS);
        System.out.println(redisTemplateForString.opsForValue().get("num"));


    }


    //实现事务操作
    @Test
    void test1() {

        //1.方式一
/*      //注意：如果这样写的话会产生异常而且我查阅资料不能解决这个问题
        redisTemplateForString.setEnableTransactionSupport(true);//允许执行事务
        redisTemplateForString.multi();//开启事务
        redisTemplateForString.opsForValue().set("c","d");
        redisTemplateForString.exec();*/


        //2.于是乎我用这个方式
        /*
         * 使用 SessionCallback 接口可以更加方便地将多个 Redis 命令绑定到一个会话中，确保这些命令被原子性地执行。--来自chatGPT
         * */
        SessionCallback<Object> sessionCallback = new SessionCallback<Object>() {
            @Override
            public <K, V> Object execute(RedisOperations<K, V> operations) throws DataAccessException {
                redisTemplateForString.multi();//开启事务
                redisTemplateForString.opsForValue().set("fine", "thankyou");
                return redisTemplateForString.exec();
            }
        };
        //使用核心来执行它
            System.out.println(redisTemplateForString.execute(sessionCallback));
    }


    @Test
    public void test2() {

        Wheel wheel = new Wheel();

        Car car = new Car("a", "b",wheel);

/*        //1.操作hash数据结构，存个车车吧 但是发现还是有乱码现象 不知道怎么解决
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put(car.getClass().getName(), "name", car.getName());
        hashOperations.put(car.getClass().getName(), "age", car.getAge());
        hashOperations.delete(car.getClass().getName(), "name");
        hashOperations.delete(car.getClass().getName(), "age");*/



        //2.
        HashOperations<String, String, Object> hashOperations = redisTemplateForString.opsForHash();
        hashOperations.put("car", "name", car.getName());
        hashOperations.put("car", "age", car.getAge());
        hashOperations.put("car", "wheel", car.getWheel().toString());
        System.out.println(hashOperations.get("car", "name"));
        System.out.println(hashOperations.get("car", "age"));
        System.out.println(hashOperations.get("car", "wheel"));
    }



    }































