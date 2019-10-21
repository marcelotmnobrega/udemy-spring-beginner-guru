package guru.springframework.controllers;

import guru.springframework.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by jt on 5/24/17.
 */
public class ConstructorInjectedControllerTest {
    private ConstructorInjectedController constructorInjectedController;

    @BeforeEach
    public void setUp() throws Exception {
        this.constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImpl());
    }

    @Test
    public void testGreeting() throws Exception {
        assertEquals("Hello - Greeting Service Default", constructorInjectedController.sayHello());
    }
}