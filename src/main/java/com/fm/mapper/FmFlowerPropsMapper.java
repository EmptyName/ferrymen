package com.fm.mapper;

import com.fm.pojo.flower.FmFlowerProps;
import com.fm.pojo.flower.FmFlowerPropsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmFlowerPropsMapper {
    int countByExample(FmFlowerPropsExample example);

    int deleteByExample(FmFlowerPropsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FmFlowerProps record);

    int insertSelective(FmFlowerProps record);

    List<FmFlowerProps> selectByExample(FmFlowerPropsExample example);

    FmFlowerProps selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FmFlowerProps record, @Param("example") FmFlowerPropsExample example);

    int updateByExample(@Param("record") FmFlowerProps record, @Param("example") FmFlowerPropsExample example);

    int updateByPrimaryKeySelective(FmFlowerProps record);

    int updateByPrimaryKey(FmFlowerProps record);

    List<Long> getAllPropsWithPrice0();

    List<Long> getAllPropsWithPriceNot0();
}