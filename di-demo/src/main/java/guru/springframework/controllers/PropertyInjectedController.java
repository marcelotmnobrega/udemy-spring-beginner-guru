package guru.springframework.controllers;

import guru.springframework.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


/**
 * Created by jt on 5/24/17.
 */
@Controller
public class PropertyInjectedController {

    @Autowired
    //This time we're using the field as the implementation name (bean name)
    //But after we created the @Primary, the Primary is being used.
    public GreetingService greetingServiceImpl;

    public String sayHello(){
        return greetingServiceImpl.sayGreeting();
    }

}
