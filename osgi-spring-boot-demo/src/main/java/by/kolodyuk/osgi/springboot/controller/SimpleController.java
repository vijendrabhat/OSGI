package by.kolodyuk.osgi.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.baeldung.osgi.sample.service.definition.Greeter;
import com.baeldung.osgi.sample.service.implementation.GreeterImpl;
import com.baeldung2.osgi.sample.service.definition2.Greeter2;
import com.baeldung2.osgi.sample.service.implementation2.GreeterImpl2;

@RestController
public class SimpleController {

	 // Logger logger = LoggerFactory.getLogger(SimpleController.class);
	
    @GetMapping("/echo")
    public String echo() {
    	
    	 Greeter gr = new GreeterImpl();
    	 System.out.println(gr.sayHiTo("Vijendra111111"));
    	 
    	 Greeter2 gr2 = new GreeterImpl2();
    	 System.out.println(gr2.sayHiTo("Vijendra222222"));
    	 
        return "echo";
 
        
    }

}
