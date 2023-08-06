package project.mybatisThings.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName MEM
 */
@Data
public class Mem implements Serializable {
    private Integer id;

    private String memName;

    private String memPrice;

    private String menPerformance;

    private static final long serialVersionUID = 1L;
}