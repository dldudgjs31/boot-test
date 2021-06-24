package penta.core;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	
	
	@RequestMapping("/test")
	public String penta() {
		return "Hello, applicaiton is running on JBOSS EAP/crontab real test!!";
	}

}
