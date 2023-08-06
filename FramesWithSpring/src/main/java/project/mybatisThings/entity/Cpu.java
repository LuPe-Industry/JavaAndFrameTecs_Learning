package project.mybatisThings.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName CPU
 */
@Data
public class Cpu implements Serializable {
    private Integer id;

    private String cpuPrice;

    private String cpuName;

    private String cpuPerformance;

    private static final long serialVersionUID = 1L;

    public Cpu(String cpuPrice, String cpuName, String cpuPerformance) {
        this.cpuPrice = cpuPrice;
        this.cpuName = cpuName;
        this.cpuPerformance = cpuPerformance;
    }

}