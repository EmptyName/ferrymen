package com.fm.mapper;

import com.fm.pojo.flower.FmFlowerPropsLog;
import com.fm.pojo.flower.FmFlowerPropsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmFlowerPropsLogMapper {
    int countByExample(FmFlowerPropsLogExample example);

    int deleteByExample(FmFlowerPropsLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FmFlowerPropsLog record);

    int insertSelective(FmFlowerPropsLog record);

    List<FmFlowerPropsLog> selectByExample(FmFlowerPropsLogExample example);

    FmFlowerPropsLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FmFlowerPropsLog record, @Param("example") FmFlowerPropsLogExample example);

    int updateByExample(@Param("record") FmFlowerPropsLog record, @Param("example") FmFlowerPropsLogExample example);

    int updateByPrimaryKeySelective(FmFlowerPropsLog record);

    int updateByPrimaryKey(FmFlowerPropsLog record);
}