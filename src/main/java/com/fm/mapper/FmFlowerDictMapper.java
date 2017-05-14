package com.fm.mapper;

import com.fm.pojo.flower.FmFlowerDict;
import com.fm.pojo.flower.FmFlowerDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmFlowerDictMapper {
    int countByExample(FmFlowerDictExample example);

    int deleteByExample(FmFlowerDictExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FmFlowerDict record);

    int insertSelective(FmFlowerDict record);

    List<FmFlowerDict> selectByExample(FmFlowerDictExample example);

    FmFlowerDict selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FmFlowerDict record, @Param("example") FmFlowerDictExample example);

    int updateByExample(@Param("record") FmFlowerDict record, @Param("example") FmFlowerDictExample example);

    int updateByPrimaryKeySelective(FmFlowerDict record);

    int updateByPrimaryKey(FmFlowerDict record);

    List<Long> getAllSeedWithPriceEqual0();
}