package wcmc.schoolcard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import wcmc.schoolcard.dto.Webteacher;
import wcmc.schoolcard.service.WebteacherService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/teacherLogin")
public class WebteacherController {
	
	@Autowired
	private WebteacherService webteacherService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		Webteacher webteacher = webteacherService.selectByIdAndPass(request.getParameter("id"), request.getParameter("password"));
		if (webteacher != null) {
			HttpSession session = request.getSession();
			session.setAttribute("teacher", webteacher);
			return "teacherFirstPage";
		} else {
			return "redirect:http://localhost:8080/schoolcard/teacherLogin.jsp";
		}
	}

}
