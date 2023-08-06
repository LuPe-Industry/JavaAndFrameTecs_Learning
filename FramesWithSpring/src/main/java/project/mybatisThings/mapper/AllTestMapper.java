package project.mybatisThings.mapper;

import org.apache.ibatis.annotations.Mapper;
import project.mybatisThings.entity.Cpu;
import project.mybatisThings.vo.Bundle1;
import project.mybatisThings.vo.Bundle2;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AllTestMapper {
    Bundle1 selectBundle1();

    Bundle2 multipleBundle();

    int insertOneCpu(Cpu cpu);

    int insertMultipleCpu(List<Cpu> list);

    List<Cpu> selectSomeCpu(String name);

    int insertOneCpuSpecial02(Cpu cpu);

    int insertCpuWithMap(HashMap<String, Object> map);


}
