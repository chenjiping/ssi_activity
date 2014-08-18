package com.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mybatis.model.Aaa;
import com.mybatis.model.AaaExample;

public interface AaaMapper {
    int countByExample(AaaExample example);

    int deleteByExample(AaaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Aaa record);

    int insertSelective(Aaa record);

    List<Aaa> selectByExample(PageBounds pageBounds,AaaExample example);

    Aaa selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Aaa record, @Param("example") AaaExample example);

    int updateByExample(@Param("record") Aaa record, @Param("example") AaaExample example);

    int updateByPrimaryKeySelective(Aaa record);

    int updateByPrimaryKey(Aaa record);
    
    List testSelect(PageBounds pageBounds,Map map);

}