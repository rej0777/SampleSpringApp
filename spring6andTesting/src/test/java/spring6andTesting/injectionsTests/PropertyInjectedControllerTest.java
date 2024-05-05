package spring6andTesting.injectionsTests;

import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import spring6andTesting.injectionsTests.GreetingServiceImpl;
import spring6andTesting.injectionsTests.PropertyInjectedController;

@SpringBootTest
class PropertyInjectedControllerTest {

	/*

	PropertyInjectedController propertyInjectedController;
	
	@BeforeEach
	void setUP() {
		propertyInjectedController =new PropertyInjectedController();
		propertyInjectedController.greetingService = new GreetingServiceImpl();
	}
	
	@Test
	void test() {
		System.out.print(propertyInjectedController.sayHello());
	}	*/
	
	   @Autowired
	    PropertyInjectedController propertyInjectedController;

	    @Test
	    void sayHello() {
	        System.out.println(propertyInjectedController.sayHello());

	    }

}
