package project.projectDomains;

import lombok.Data;

@Data
public class Pig {
    private String name;
    private int weight;

    public Pig(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Pig() {
    }
}
