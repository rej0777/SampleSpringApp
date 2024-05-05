package spring6andTesting.injectionsTests;

import org.junit.jupiter.api.Test;

import spring6andTesting.injectionsTests.MyController;

class MyControllerTest {

    @Test
    void sayHello() {
        MyController myController = new MyController();

        System.out.println(myController.sayHello());


    }
}
