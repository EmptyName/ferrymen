package com.fm.mapper;

import com.fm.pojo.order.FmOrderItem;
import com.fm.pojo.order.FmOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmOrderItemMapper {
    int countByExample(FmOrderItemExample example);

    int deleteByExample(FmOrderItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FmOrderItem record);

    int insertSelective(FmOrderItem record);

    List<FmOrderItem> selectByExample(FmOrderItemExample example);

    FmOrderItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FmOrderItem record, @Param("example") FmOrderItemExample example);

    int updateByExample(@Param("record") FmOrderItem record, @Param("example") FmOrderItemExample example);

    int updateByPrimaryKeySelective(FmOrderItem record);

    int updateByPrimaryKey(FmOrderItem record);
}