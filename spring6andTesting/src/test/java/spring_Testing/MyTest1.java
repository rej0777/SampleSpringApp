package spring_Testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring6andTesting.SampleSimpleApplication;
import spring6andTesting.webExample.controllers.AuthorController;


@SpringBootTest(classes = SampleSimpleApplication.class )
public class MyTest1 {

	@Autowired
	ApplicationContext applicationContext;
	
	@Test
	 void testGetcontrollerfromContext() {
		AuthorController authorController = applicationContext.getBean(AuthorController.class);
		
		System.out.print(authorController.sayHello());
		
	}

	
}

 