package com.fm.mapper;

import com.fm.pojo.user.FmUserFm;
import com.fm.pojo.user.FmUserFmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmUserFmMapper {
    int countByExample(FmUserFmExample example);

    int deleteByExample(FmUserFmExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FmUserFm record);

    int insertSelective(FmUserFm record);

    List<FmUserFm> selectByExample(FmUserFmExample example);

    FmUserFm selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FmUserFm record, @Param("example") FmUserFmExample example);

    int updateByExample(@Param("record") FmUserFm record, @Param("example") FmUserFmExample example);

    int updateByPrimaryKeySelective(FmUserFm record);

    int updateByPrimaryKey(FmUserFm record);
}