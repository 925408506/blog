import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class configuration {
    @Test
    public  void config(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-config.xml");
        String[] names=applicationContext.getBeanDefinitionNames();
        for(String name:names)
        {
            System.out.println(name.toString());
        }
    }
}
