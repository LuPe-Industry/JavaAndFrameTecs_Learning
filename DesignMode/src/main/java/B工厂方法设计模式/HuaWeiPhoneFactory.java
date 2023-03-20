package B工厂方法设计模式;

public class HuaWeiPhoneFactory {

    //学会新技能了：
    /*
    * 返回的的对象用一个接口来接 虽然我在学InputStream的时候用过但是没这么直观哈哈哈
    *
    * */
    public HuaweiPhone AProduct(String type){
        if("Mate50".equals(type)){
            return  new Mate50();
        }
        else if ("P50".equals(type)){
            return  new P50();
        }
        else {//原来可以这么写 直接throw
            throw new RuntimeException("该类型手机不存在");       }
    }
}
