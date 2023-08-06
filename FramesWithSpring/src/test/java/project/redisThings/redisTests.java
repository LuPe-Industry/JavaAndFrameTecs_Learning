package project.redisThings;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import project.projectDomains.Person;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class redisTests {

    @Autowired
    private StringRedisTemplate redisTemplateForString;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


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

//        Wheel wheel = new Wheel();
//
//        Car car = new Car("a", "b",wheel);

/*        //1.操作hash数据结构，存个车车吧 但是发现还是有乱码现象 不知道怎么解决
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put(car.getClass().getName(), "name", car.getName());
        hashOperations.put(car.getClass().getName(), "age", car.getAge());
        hashOperations.delete(car.getClass().getName(), "name");
        hashOperations.delete(car.getClass().getName(), "age");*/



//        //2.
//        HashOperations<String, String, Object> hashOperations = redisTemplateForString.opsForHash();
//        hashOperations.put("car", "name", car.getName());
//        hashOperations.put("car", "age", car.getAge());
//        hashOperations.put("car", "wheel", car.getWheel().toString());
//        System.out.println(hashOperations.get("car", "name"));
//        System.out.println(hashOperations.get("car", "age"));
//        System.out.println(hashOperations.get("car", "wheel"));
    }

    @Test
    public void test03(){
        String s = (String) redisTemplate.opsForHash().get("HashTest", "good");
        System.out.println(s);

    }
    /*
    * list插入
    * */
    @Test
    public void test04(){
        HashMap<String, String> hash = new HashMap<>();
        hash.put("刘","鹏");
        hash.put("孙","俊达");
        try{
            redisTemplate.opsForHash().putAll("HashTest2",hash);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    /*
    * list查询内容
    * */
    @Test
    public void test05(){
        //单个值
        Object o = redisTemplate.opsForHash().get("HashTest2", "刘");
        List<Object> values = redisTemplate.opsForHash().values("HashTest2");
        Map<Object, Object> allEntries = redisTemplate.opsForHash().entries("HashTest2");
        //查询是否存在
        boolean exists = redisTemplate.opsForHash().hasKey("HashTest2", "key1");

        System.out.println(o);
        System.out.println(values);
        System.out.println(allEntries);

    }
    /*
    * set插入
    * */
    @Test
    public void test06(){
        redisTemplate.opsForSet().add("SetTest", "value1", "value2");

    }

    /*
    * set查询内容
    * */
    @Test
    public void test07(){
        //判断内容在不在
        boolean isMember = redisTemplate.opsForSet().isMember("SetTest", "value1");
        System.out.println(isMember);
        //全部内容
        Set<Object> setMembers = redisTemplate.opsForSet().members("SetTest");
        System.out.println(setMembers);
        //查询两个集合的交集
        Set<Object> intersection = redisTemplate.opsForSet().intersect("SetTest", "set2");
        System.out.println(intersection);
        //查询两个集合的差集
        Set<Object> difference = redisTemplate.opsForSet().difference("SetTest", "set2");
        System.out.println(difference);

    }


    /*
     * 对key的操作
     * */
    @Test
    public void test08(){
        Boolean mykey = redisTemplate.expire("mykey", 60, TimeUnit.SECONDS);// 将mykey设置为60秒后过期
        System.out.println(mykey);
    }
    @Test
    public void test09(){
        //创建一个定时挂掉的key 60s
        redisTemplate.opsForValue().set("keyTest1","value",60,TimeUnit.SECONDS);
    }

    /*
    * 存储对象
    * */
    @Test
    public void test10(){
        Person lupe = new Person("刘鹏", 18);
        redisTemplate.opsForValue().set("objectTest1",lupe);
        Object lupeFromRedis = redisTemplate.opsForValue().get("objectTest1");
        System.out.println(lupeFromRedis);
    }





}































