package com.common;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.miemiedev.mybatis.paginator.domain.PageList; 

/**
 * 按照统一的grid分页机制，根据定制的json数据。封装提交到页面的json数据。
 * @author Tony.Zhou
 *
 */
public class PageListJsonMapper extends ObjectMapper {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PageListJsonMapper() {
	        SimpleModule module = new SimpleModule("PageListJSONModule", new Version(1, 0, 0, null, null, null));
	        module.addSerializer(PageList.class, new PageListJsonSerializer());
	        registerModule(module);
	    }
}
