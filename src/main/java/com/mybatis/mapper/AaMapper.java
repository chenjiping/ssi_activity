package com.mybatis.mapper;

import com.mybatis.model.Aa;
import com.mybatis.model.AaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AaMapper {
    int countByExample(AaExample example);

    int deleteByExample(AaExample example);

    int deleteByPrimaryKey(Integer a);

    int insert(Aa record);

    int insertSelective(Aa record);

    List<Aa> selectByExample(AaExample example);

    Aa selectByPrimaryKey(Integer a);

    int updateByExampleSelective(@Param("record") Aa record, @Param("example") AaExample example);

    int updateByExample(@Param("record") Aa record, @Param("example") AaExample example);

    int updateByPrimaryKeySelective(Aa record);

    int updateByPrimaryKey(Aa record);
}