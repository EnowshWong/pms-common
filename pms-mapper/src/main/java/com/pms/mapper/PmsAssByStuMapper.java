package com.pms.mapper;

import com.pms.pojo.PmsAssByStu;
import com.pms.pojo.PmsAssByStuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsAssByStuMapper {
    int countByExample(PmsAssByStuExample example);

    int deleteByExample(PmsAssByStuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsAssByStu record);

    int insertSelective(PmsAssByStu record);

    List<PmsAssByStu> selectByExampleWithBLOBs(PmsAssByStuExample example);

    List<PmsAssByStu> selectByExample(PmsAssByStuExample example);

    PmsAssByStu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsAssByStu record, @Param("example") PmsAssByStuExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsAssByStu record, @Param("example") PmsAssByStuExample example);

    int updateByExample(@Param("record") PmsAssByStu record, @Param("example") PmsAssByStuExample example);

    int updateByPrimaryKeySelective(PmsAssByStu record);

    int updateByPrimaryKeyWithBLOBs(PmsAssByStu record);

    int updateByPrimaryKey(PmsAssByStu record);
}