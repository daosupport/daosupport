package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.support.database.IDaoSupport;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private IDaoSupport daoSupport;
	
	@GetMapping()
	public List<Map<String,Object>> getTestList(){
		String sql="select * from c_buddhist_sangha";
		return this.daoSupport.queryForList(sql);
	}
}
