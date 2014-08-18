package com.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.service.TestService;
import com.util.PageUtils;
import com.util.ResponseUtils;

@Controller
public class TestController {
	
	@Autowired
    protected TestService testService;

	@RequestMapping(value = "/getData")
	public @ResponseBody List getData(){
		PageBounds pageBounds = PageUtils.getPageBounds();
		return testService.test(pageBounds);
	}
	
	@RequestMapping(value = "/getData2")
	public void getData2(HttpServletRequest request,HttpServletResponse response){
		int page = Integer.valueOf(request.getParameter("page"));
		int rows = Integer.valueOf(request.getParameter("rows"));
		PageBounds pageBounds = new PageBounds(page,rows);
		List pageList = testService.test(pageBounds);
		PageList pl = (PageList)pageList;
		Map m = new HashMap();
		m.put("rows", pl);
		m.put("total", pl.getPaginator().getTotalCount());
		ResponseUtils.renderJson(response, m);
	}
}
