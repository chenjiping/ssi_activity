package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mybatis.mapper.AaaMapper;
import com.mybatis.model.Aaa;
import com.mybatis.model.AaaExample;

@Service
public class TestService {

	@Autowired
	private AaaMapper aaaMapper;

	@Transactional
	public List test(PageBounds pageBounds) {
		AaaExample example = new AaaExample();
		List list = aaaMapper.selectByExample(pageBounds,example);
		return list;
	}

	@Transactional
	public void delete(Integer id) {
		aaaMapper.deleteByPrimaryKey(id);
	}

	@Transactional
	public void insert(Aaa record) {
		aaaMapper.insert(record);
	}

	@Transactional
	public void update(Aaa record) {
		aaaMapper.updateByPrimaryKey(record);
	}
	
	public Aaa selectAaaById(Integer id){
		return aaaMapper.selectByPrimaryKey(id);
	}

	@Transactional
	public List test(PageBounds pageBounds,Integer id) {
		AaaExample example = new AaaExample();
		//example.createCriteria().andIdEqualTo(id);
		
		example.createCriteria().andIdBetween(id, id+5);
		
		List list = aaaMapper.selectByExample(pageBounds,example);
		return list;
	}
}
