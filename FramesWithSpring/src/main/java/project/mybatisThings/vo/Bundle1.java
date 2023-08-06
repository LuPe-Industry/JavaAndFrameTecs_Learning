package project.mybatisThings.vo;

import lombok.Data;
import project.mybatisThings.entity.Cpu;
import project.mybatisThings.entity.Gpu;
@Data
public class Bundle1 {
    private Cpu cpu;
    private Gpu gpu;
}
