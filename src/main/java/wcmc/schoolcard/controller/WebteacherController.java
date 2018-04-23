package wcmc.schoolcard.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

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
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		if (id == null) {
			return "redirect:http://localhost:8080/schoolcard/teacherLogin.jsp";
		}
		Webteacher webteacher = webteacherService.selectByIdAndPass(id, password);
		if (webteacher != null) {
			Map<String, String> map = webteacherService.getGradeByTeacher(webteacher.getSCHOOL());
			HttpSession session = request.getSession();
			session.setAttribute("teacher", webteacher);
			Gson gson = new Gson();
			String grade = gson.toJson(map);
			session.setAttribute("grade", grade);
			return "teacher/FirstPage";
		} else {
			return "redirect:http://localhost:8080/schoolcard/teacherLogin.jsp";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("teacher");
		return "redirect:http://localhost:8080/schoolcard/teacherLogin.jsp";
	}
	
	@RequestMapping("/firstPage")
	public String firstPage(HttpServletRequest request)
	{
		return "teacher/FirstPage";
	}

}
