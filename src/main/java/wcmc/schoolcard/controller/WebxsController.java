package wcmc.schoolcard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import wcmc.schoolcard.dto.WebReaderinfo;
import wcmc.schoolcard.dto.Webrecomstatistics;
import wcmc.schoolcard.dto.Webxs;
import wcmc.schoolcard.service.WebReaderinfoService;
import wcmc.schoolcard.service.WebRecomStatisticsService;
import wcmc.schoolcard.service.WebxsService;


@Controller
@RequestMapping("/stuLogin")
public class WebxsController {
	
	@Autowired
	private WebxsService webxsService;
	@Autowired
	private WebReaderinfoService webReaderinfoService;
	@Autowired
	private WebRecomStatisticsService webRecomStatisticsService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Model model)
	{
		Webxs webxs = webxsService.selectByPrimaryKey(request.getParameter("stuXH"));
		String xh = request.getParameter("stuXH");
		System.out.println("xh:"+xh);
		String psw = request.getParameter("stuPsw");
		System.out.println("psw:"+psw);
		if (webxs != null && webxs.getPass().equals(psw))
		{
			HttpSession session = request.getSession();
			session.setAttribute("xs", webxs);
			WebReaderinfo webReaderinfo = webReaderinfoService.selectByXh(xh);
			
			//�û���������
			session.setAttribute("personalGraph", webxsService.getPersonalInfo(xh));
			
			model.addAttribute("webReaderinfo", webReaderinfo);
			String imgId = webReaderinfo.getReaderid()+".jpg";
			session.setAttribute("imgId",imgId);
			String type = "MOSTBorrow";
			Webrecomstatistics webrecomstatistics = webRecomStatisticsService.selectByType(type);
			model.addAttribute("webrecomstatistics", webrecomstatistics);
			return "student/FirstPage";
		}
		else
			return "redirect:http://localhost:8080/schoolcard/";
	}
	
	@RequestMapping("/firstPage")
	public String firstPage(HttpServletRequest request, Model model)
	{
		return "student/FirstPage";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		request.getSession().removeAttribute("xs");
		request.getSession().removeAttribute("imgId");
		
		return "redirect:http://localhost:8080/schoolcard/";
	}
	
	@RequestMapping("/bookRec")
	public String bookRec(HttpServletRequest request)
	{
		System.out.println("bookRec");
		return "BookRec";
	}
	
}
