package com.pms.mapper;

import com.pms.pojo.PmsUser;
import com.pms.pojo.PmsUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsUserMapper {
    int countByExample(PmsUserExample example);

    int deleteByExample(PmsUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsUser record);

    int insertSelective(PmsUser record);

    List<PmsUser> selectByExample(PmsUserExample example);

    PmsUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsUser record, @Param("example") PmsUserExample example);

    int updateByExample(@Param("record") PmsUser record, @Param("example") PmsUserExample example);

    int updateByPrimaryKeySelective(PmsUser record);

    int updateByPrimaryKey(PmsUser record);

}