package project.mybatisThings.vo;

import lombok.Data;
import project.mybatisThings.entity.Mem;

import java.util.List;

@Data
public class Bundle2 {
    private String Country;
    private String CountryID;

    private List<Mem> Mems;

}
