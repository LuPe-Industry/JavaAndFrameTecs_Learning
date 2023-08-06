package project.mybatisThings.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName GPU
 */
@Data
public class Gpu implements Serializable {
    private Integer id;

    private String gpuName;

    private String gpuPrice;

    private String gpuPerformance;

    private static final long serialVersionUID = 1L;
}