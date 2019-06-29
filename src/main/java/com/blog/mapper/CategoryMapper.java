package com.blog.mapper;
 
import java.util.List;

import com.blog.pojo.Category;
import org.springframework.stereotype.Component;


public interface CategoryMapper {
 
      
    public int add(Category category);  
       
      
    public void delete(int id);  
       
      
    public Category get(int id);  
     
      
    public int update(Category category);   
       
      
    public List<Category> list();
      
}