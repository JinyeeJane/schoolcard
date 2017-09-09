package wcmc.schoolcard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import wcmc.schoolcard.dto.Webxs;
import wcmc.schoolcard.service.WebxsService;

@Controller
@RequestMapping("/stuLogin")
public class WebxsController {
	
	@Autowired
	private WebxsService webxsService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request)
	{
		Webxs webxs = webxsService.selectByPrimaryKey(request.getParameter("stuXH"));
		System.out.println(request.getParameter("stuXH"));
		String psw = request.getParameter("stuPsw");
		System.out.println("psw:"+psw);
		if (webxs != null && webxs.getPass().equals(psw))
		{
			System.out.println("true");
			HttpSession session = request.getSession();
			session.setAttribute("xs", webxs);
			return "FirstPage";
		}
		else
			return "redirect:http://localhost:8080/schoolcard/";
	}
	
	
}
