package penta.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/main")
	public @ResponseBody String penta() {
		return "Hello, applicaiton is running on JBOSS EAP/crontab real test!!";
	}

}
