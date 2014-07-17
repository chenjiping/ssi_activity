package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.mapper.AaaMapper;
import com.mybatis.model.Aaa;

@Service
public class TestService {

	@Autowired
	private AaaMapper aaaMapper;

	@Transactional
	public void test() {
		List<Aaa> list = aaaMapper.selectByExample(null);
	}
}
