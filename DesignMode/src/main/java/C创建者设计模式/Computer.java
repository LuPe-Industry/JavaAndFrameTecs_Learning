package C创建者设计模式;

import lombok.Data;

@Data
public class Computer {

    private String cpu;
    private String box;
    private String board;
    private String storage;
    private String power;
    private String Gcard;




    public static class Builder{

        private final Computer computer = new Computer();
        public Builder Build(){
            return new Builder();
        }

        public Builder ACpu(String c){
            computer.setCpu(c);
            return this;
        }
        public Builder AStorage(String c){
            computer.setStorage(c);
            return this;
        }
        public Builder ABox(String c){
            computer.setBox(c);
            return this;
        }
        public Builder APower(String c){
            computer.setPower(c);
            return this;
        }
        public Builder AGcard(String c){
            computer.setGcard(c);
            return this;
        }
        public Computer getAccomplishedComputer(){
            return computer;
        }


    }
}
