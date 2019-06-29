package com.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.mapper.CategoryMapper;
import com.blog.pojo.Category;
import com.blog.service.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService{
	@Autowired
	private CategoryMapper categoryMapper;
	
	
	@Override
	public List<Category> list(){
		return categoryMapper.list();
	}


}
