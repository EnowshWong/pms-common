package com.pms.mapper;

import com.pms.pojo.PmsProject;
import com.pms.pojo.PmsProjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PmsProjectMapper {
    int countByExample(PmsProjectExample example);

    int deleteByExample(PmsProjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProject record);

    int insertSelective(PmsProject record);

    List<PmsProject> selectByExampleWithBLOBs(PmsProjectExample example);

    List<PmsProject> selectByExample(PmsProjectExample example);

    PmsProject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProject record, @Param("example") PmsProjectExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsProject record, @Param("example") PmsProjectExample example);

    int updateByExample(@Param("record") PmsProject record, @Param("example") PmsProjectExample example);

    int updateByPrimaryKeySelective(PmsProject record);

    int updateByPrimaryKeyWithBLOBs(PmsProject record);

    int updateByPrimaryKey(PmsProject record);

    List<PmsProject> findByPage(Map<String,Object> map);
}