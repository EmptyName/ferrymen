package com.fm.mapper;

import com.fm.pojo.flower.FmFlower;
import com.fm.pojo.flower.FmFlowerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmFlowerMapper {
    int countByExample(FmFlowerExample example);

    int deleteByExample(FmFlowerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FmFlower record);

    int insertSelective(FmFlower record);

    List<FmFlower> selectByExample(FmFlowerExample example);

    FmFlower selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FmFlower record, @Param("example") FmFlowerExample example);

    int updateByExample(@Param("record") FmFlower record, @Param("example") FmFlowerExample example);

    int updateByPrimaryKeySelective(FmFlower record);

    int updateByPrimaryKey(FmFlower record);
}