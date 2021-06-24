package penta.core.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BbsController {
	@Autowired
	BbsDAO bbsDAO;

	@RequestMapping(value = "/dbtest", method = RequestMethod.GET)
	public String userlistPage(Model model) {
		model.addAttribute("users",bbsDAO.list());
		return "dbtest";
	}
}
