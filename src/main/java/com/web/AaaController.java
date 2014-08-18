package com.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mybatis.model.Aaa;
import com.service.TestService;
//import com.util.ResponseUtils;
import com.util.PageUtils;

@Controller
@RequestMapping("/mae")
public class AaaController {
	@Autowired
	private TestService service;
	
	@RequestMapping(value="/list")
	public @ResponseBody List dataList(){
		PageBounds pageBounds = PageUtils.getPageBounds();
		return service.test(pageBounds);
	}
	
	@RequestMapping(value = "/search/{id}",method=RequestMethod.POST)
	//当{param}与参数中的param命名不一致时，使用@PathVariable("paramName")
    public @ResponseBody List getData(@PathVariable("id") Integer id){
		PageBounds pageBounds = PageUtils.getPageBounds();
		return service.test(pageBounds,id);
	}
	
	@RequestMapping(value="/add")
	public String add(){
		return "add";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(Aaa record){
		int id = (int) (Math.random()*100+5);
		record.setId(id);
		service.insert(record);
		
		return "success";
	}
	
	@RequestMapping(value="/upd")
	public String upd(Integer id,Model model){
		Aaa record = service.selectAaaById(id);
		model.addAttribute("Aaa",record);
		return "update";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Aaa record){
		service.update(record);
		
		return "success";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id){
		service.delete(id);
		return "maeList";
	}
	
	@RequestMapping(value="/xchart")
	public @ResponseBody List xData(){

		List lst = new ArrayList();
		for (int i = 0; i < 6; i++) {		
			int ran1 = (int) (Math.random()*60+20);
			int ran2 = (int) (Math.random()*60+40);
			
			Map m = new HashMap();
			m.put("value1", ran1);
			m.put("value2", ran2);
			lst.add(m);
		}
			
		return lst;
	}
	
	@RequestMapping(value="/chart")
	public @ResponseBody List chartData(){
		
		char c = 'A';
		
		List lst = new ArrayList();
		for (int i = 0; i < 6; i++) {		
			char ch = (char) (c+i);
			int ran1 = (int) (Math.random()*90+5);
			int ran2 = (int) (Math.random()*120+2);
			
			Map m = new HashMap();
			m.put("date1", ch);
			m.put("value1", ran1);
			
			m.put("date2", ch);
			m.put("value2", ran2);
			lst.add(m);
		}
			
		return lst;
	}
	
	@RequestMapping(value="/chart1")
	public @ResponseBody List chartData1(){

		List lst = new ArrayList();
		for (int i = 0; i < 7; i++) {		
			int ran1 = (int) (Math.random()*80+20);
			int ran2 = (int) (Math.random()*80+20);
			
			Map m = new HashMap();
			m.put("data1", i+1);
			m.put("value1", ran1);
			
			m.put("data2", i+1);
			m.put("value2", ran2);
			lst.add(m);
		}
			
		return lst;
	}
	
	@RequestMapping(value="/piechart")
	public @ResponseBody List pieChartData(){
		
		List lst = new ArrayList();
		for (int i = 0; i < 7; i++) {		
			Map m = new HashMap();
			m.put("name", "test"+i);
			int ran = (int) (Math.random()*50);
			m.put("value", i+ran);
			lst.add(m);
		}
			
		return lst;
	}
	
	@RequestMapping(value="/margin")
	public @ResponseBody List marginChartData(){
		
		List lst = new ArrayList();

		for (int i = 0; i < 70; i+=10) {
			int val1 = (int) (Math.random()*100+12);
			int val2 = (int) (Math.random()*80+23);
			int val3 = (int) (Math.random()*50+5);
			Map m = new HashMap();
			m.put("key1", i+10);
			m.put("value1", val1);
			
			m.put("key2", i+10);
			m.put("value2", val2);
			
			m.put("key3", i+10);
			m.put("value3", val3);
			
			lst.add(m);
		}
			
		return lst;
	}
	
}
