package com.fm.mapper;

import com.fm.pojo.order.FmOrder;
import com.fm.pojo.order.FmOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmOrderMapper {
    int countByExample(FmOrderExample example);

    int deleteByExample(FmOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FmOrder record);

    int insertSelective(FmOrder record);

    List<FmOrder> selectByExample(FmOrderExample example);

    FmOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FmOrder record, @Param("example") FmOrderExample example);

    int updateByExample(@Param("record") FmOrder record, @Param("example") FmOrderExample example);

    int updateByPrimaryKeySelective(FmOrder record);

    int updateByPrimaryKey(FmOrder record);
}