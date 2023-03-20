package C创建者设计模式;

public class main {
    public static void main(String[] args) {
        Computer.Builder builder = new Computer.Builder();
        Computer myComputer = builder.Build().ABox("nzxt").ACpu("intel").AGcard("rog").APower("changcheng").AStorage("海盗船").getAccomplishedComputer();
        System.out.println(myComputer);//Computer(cpu=intel, box=nzxt, board=null, storage=海盗船, power=changcheng, Gcard=rog)

    }
}
