package wcmc.schoolcard.controller;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import wcmc.schoolcard.dto.Webteacher;
import wcmc.schoolcard.dto.Webxs;
import wcmc.schoolcard.service.WebteacherService;
import wcmc.schoolcard.service.WebxsService;
import wcmc.schoolcard.service.WebyktlsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/teacherLogin")
public class WebteacherController {
	
	@Autowired
	private WebteacherService webteacherService;
	@Autowired
	private WebyktlsService webyktlsService;
	@Autowired
	private WebxsService webxsService;
	
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
			List<Webxs> abnormalList = webxsService.getAbnormalByXy(webteacher.getSCHOOL());
			List<Webxs> poorList = webxsService.getPoorByXy(webteacher.getSCHOOL());
			Gson gson = new Gson();
			String grade = gson.toJson(map);
			String abnormal = gson.toJson(abnormalList);
			String poor = gson.toJson(poorList);
			session.setAttribute("grade", grade);
			session.setAttribute("abnormal", abnormal);
			session.setAttribute("poor", poor);
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
	
	@RequestMapping(value="/cost", produces="application/json;charset=UTF-8;")
	public @ResponseBody String cost(HttpServletRequest request, Model model){
		Webteacher teacher = (Webteacher) request.getSession().getAttribute("teacher");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
//		System.out.println(start+"-"+ end);
		TreeMap<String, Double> map = webyktlsService.getYktlsByXy(teacher.getSCHOOL(), start, end);
		Gson gson = new Gson();
        String cost= gson.toJson(map);
		return cost;
	}
	
	@RequestMapping("/goStuPage")
	public String goStuPage(HttpServletRequest request, Model model) {
		Webxs webxs = webxsService.selectByPrimaryKey(request.getParameter("xh"));
		HttpSession session = request.getSession();
		session.setAttribute("xs", webxs);
		session.setAttribute("personalGraph", webxsService.getPersonalInfo(webxs.getXh()));
		return "student/FirstPage";
	}

}
