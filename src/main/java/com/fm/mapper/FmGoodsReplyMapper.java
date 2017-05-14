package com.fm.mapper;

import com.fm.pojo.goods.FmGoodsReply;
import com.fm.pojo.goods.FmGoodsReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmGoodsReplyMapper {
    int countByExample(FmGoodsReplyExample example);

    int deleteByExample(FmGoodsReplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FmGoodsReply record);

    int insertSelective(FmGoodsReply record);

    List<FmGoodsReply> selectByExampleWithBLOBs(FmGoodsReplyExample example);

    List<FmGoodsReply> selectByExample(FmGoodsReplyExample example);

    FmGoodsReply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FmGoodsReply record, @Param("example") FmGoodsReplyExample example);

    int updateByExampleWithBLOBs(@Param("record") FmGoodsReply record, @Param("example") FmGoodsReplyExample example);

    int updateByExample(@Param("record") FmGoodsReply record, @Param("example") FmGoodsReplyExample example);

    int updateByPrimaryKeySelective(FmGoodsReply record);

    int updateByPrimaryKeyWithBLOBs(FmGoodsReply record);

    int updateByPrimaryKey(FmGoodsReply record);
}