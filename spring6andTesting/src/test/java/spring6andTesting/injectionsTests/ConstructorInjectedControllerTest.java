package spring6andTesting.injectionsTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import spring6andTesting.injectionsTests.ConstructorInjectedController;
import spring6andTesting.injectionsTests.GreetingServiceImpl;

@SpringBootTest
class ConstructorInjectedControllerTest {

	@Autowired
    ConstructorInjectedController controller;

	/*
	
    @BeforeEach
    void setUp() {
        //controller = new ConstructorInjectedController(new GreetingServiceImpl());     
    	 ConstructorInjectedController controller;
    }
*/
    @Test
    void sayHello() {
        System.out.println(controller.sayHello());

    }
}