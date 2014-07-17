package com.mybatis.mapper;

import com.mybatis.model.Aaa;
import com.mybatis.model.AaaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AaaMapper {
    int countByExample(AaaExample example);

    int deleteByExample(AaaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Aaa record);

    int insertSelective(Aaa record);

    List<Aaa> selectByExample(AaaExample example);

    Aaa selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Aaa record, @Param("example") AaaExample example);

    int updateByExample(@Param("record") Aaa record, @Param("example") AaaExample example);

    int updateByPrimaryKeySelective(Aaa record);

    int updateByPrimaryKey(Aaa record);
}