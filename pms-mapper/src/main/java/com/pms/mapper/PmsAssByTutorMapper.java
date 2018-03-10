package com.pms.mapper;

import com.pms.pojo.PmsAssByTutor;
import com.pms.pojo.PmsAssByTutorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsAssByTutorMapper {
    int countByExample(PmsAssByTutorExample example);

    int deleteByExample(PmsAssByTutorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsAssByTutor record);

    int insertSelective(PmsAssByTutor record);

    List<PmsAssByTutor> selectByExampleWithBLOBs(PmsAssByTutorExample example);

    List<PmsAssByTutor> selectByExample(PmsAssByTutorExample example);

    PmsAssByTutor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsAssByTutor record, @Param("example") PmsAssByTutorExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsAssByTutor record, @Param("example") PmsAssByTutorExample example);

    int updateByExample(@Param("record") PmsAssByTutor record, @Param("example") PmsAssByTutorExample example);

    int updateByPrimaryKeySelective(PmsAssByTutor record);

    int updateByPrimaryKeyWithBLOBs(PmsAssByTutor record);

    int updateByPrimaryKey(PmsAssByTutor record);
}