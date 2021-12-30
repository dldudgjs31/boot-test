package penta.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	/**
	 * 메인화면 리턴 시키는 mapping입니니다.
	 * @return : 메인 페이지 이동...
	 */
	@RequestMapping("/main")
	public String penta() {
		return "main/main";
	}
	@RequestMapping("/upload-test")
	public String uploadtest() {
		return "upload";
	}
}
