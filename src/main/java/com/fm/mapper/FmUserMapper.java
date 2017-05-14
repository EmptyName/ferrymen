package com.fm.mapper;

import com.fm.pojo.user.FmUser;
import com.fm.pojo.user.FmUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmUserMapper {
    int countByExample(FmUserExample example);

    int deleteByExample(FmUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FmUser record);

    int insertSelective(FmUser record);

    List<FmUser> selectByExample(FmUserExample example);

    FmUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FmUser record, @Param("example") FmUserExample example);

    int updateByExample(@Param("record") FmUser record, @Param("example") FmUserExample example);

    int updateByPrimaryKeySelective(FmUser record);

    int updateByPrimaryKey(FmUser record);
}