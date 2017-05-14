package com.fm.mapper;

import com.fm.pojo.goods.FmGoodsPost;
import com.fm.pojo.goods.FmGoodsPostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmGoodsPostMapper {
    int countByExample(FmGoodsPostExample example);

    int deleteByExample(FmGoodsPostExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FmGoodsPost record);

    int insertSelective(FmGoodsPost record);

    List<FmGoodsPost> selectByExampleWithBLOBs(FmGoodsPostExample example);

    List<FmGoodsPost> selectByExample(FmGoodsPostExample example);

    FmGoodsPost selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FmGoodsPost record, @Param("example") FmGoodsPostExample example);

    int updateByExampleWithBLOBs(@Param("record") FmGoodsPost record, @Param("example") FmGoodsPostExample example);

    int updateByExample(@Param("record") FmGoodsPost record, @Param("example") FmGoodsPostExample example);

    int updateByPrimaryKeySelective(FmGoodsPost record);

    int updateByPrimaryKeyWithBLOBs(FmGoodsPost record);

    int updateByPrimaryKey(FmGoodsPost record);
}