package CategoryTest;

import com.blog.mapper.CategoryMapper;
import com.blog.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:Spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class test1 {
    @Autowired
    private  CategoryMapper categoryMapper;
    @Test
    public void testOne(){
        Category category = new Category();
        category.setId(2);
        category.setName("dog");
        categoryMapper.add(category);
    }
}
