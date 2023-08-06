package lang包.enum相关;

public enum car {
    BMW(1000,"宝马"),
    BENZ(2000,"奔驰"),
    AUDI(3000,"奥迪");
    private int code;
    private String CHName;

    car(int code, String CHName) {
        this.code = code;
        this.CHName = CHName;
    }


}
