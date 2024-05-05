package spring6andTesting.injectionsTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import spring6andTesting.injectionsTests.MyController;

@SpringBootTest
public class Spring6DiApplicationTests {

	   @Autowired
	    ApplicationContext applicationContext;

	    @Autowired
	    MyController myController;

	    @Test
	    void testAutowireOfController() {
	        System.out.println(myController.sayHello());
	    }

	    @Test
	    void testGetControllerFromCtx() {
	        MyController myController = applicationContext.getBean(MyController.class);

	        System.out.println(myController.sayHello());
	    }

	    @Test
	    void contextLoads() {
	    }
	
}
