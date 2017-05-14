package com.fm.mapper;

import com.fm.pojo.order.FmOrderShipping;
import com.fm.pojo.order.FmOrderShippingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmOrderShippingMapper {
    int countByExample(FmOrderShippingExample example);

    int deleteByExample(FmOrderShippingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FmOrderShipping record);

    int insertSelective(FmOrderShipping record);

    List<FmOrderShipping> selectByExample(FmOrderShippingExample example);

    FmOrderShipping selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FmOrderShipping record, @Param("example") FmOrderShippingExample example);

    int updateByExample(@Param("record") FmOrderShipping record, @Param("example") FmOrderShippingExample example);

    int updateByPrimaryKeySelective(FmOrderShipping record);

    int updateByPrimaryKey(FmOrderShipping record);
}