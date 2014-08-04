package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mybatis.mapper.AaaMapper;
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
}
