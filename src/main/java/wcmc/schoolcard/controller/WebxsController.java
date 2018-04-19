package wcmc.schoolcard.controller;

import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import oracle.net.aso.e;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import wcmc.schoolcard.dto.WebReaderinfo;
import wcmc.schoolcard.dto.Webrecomstatistics;
import wcmc.schoolcard.dto.Webxs;
import wcmc.schoolcard.dto.Webyktls;
import wcmc.schoolcard.service.WebReaderinfoService;
import wcmc.schoolcard.service.WebRecomStatisticsService;
import wcmc.schoolcard.service.WebxsService;
import wcmc.schoolcard.service.WebyktlsService;


@Controller
@RequestMapping("/stuLogin")
public class WebxsController {
	
	@Autowired
	private WebxsService webxsService;
	@Autowired
	private WebyktlsService webyktlsService; 
//	@Autowired
//	private WebReaderinfoService webReaderinfoService;
//	@Autowired
//	private WebRecomStatisticsService webRecomStatisticsService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Model model)
	{
		Webxs webxs = webxsService.selectByPrimaryKey(request.getParameter("stuXH"));
		String xh = request.getParameter("stuXH");
		String psw = request.getParameter("stuPsw");
		if (webxs != null && webxs.getPass().equals(psw))
		{
			HttpSession session = request.getSession();
			session.setAttribute("xs", webxs);
//			WebReaderinfo webReaderinfo = webReaderinfoService.selectByXh(xh);
			
			//学生画像
			session.setAttribute("personalGraph", webxsService.getPersonalInfo(xh));
			
//			model.addAttribute("webReaderinfo", webReaderinfo);
//			String imgId = webReaderinfo.getReaderid()+".jpg";
//			session.setAttribute("imgId",imgId);
//			String type = "MOSTBorrow";
//			Webrecomstatistics webrecomstatistics = webRecomStatisticsService.selectByType(type);
//			model.addAttribute("webrecomstatistics", webrecomstatistics);
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
//		request.getSession().removeAttribute("imgId");
		
		return "redirect:http://localhost:8080/schoolcard/";
	}
	
	@RequestMapping("/cost")
	public void cost(HttpServletRequest request, Model model){
		Webxs xs = (Webxs) request.getSession().getAttribute("xs");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
//		System.out.println(start+"-"+ end);
		TreeMap<String, Double> map = webyktlsService.getYktlsByStartAndEnd(xs.getXh(), start, end);
		System.out.println(map.size());
		for (String s : map.keySet()) {
			System.out.println(s+":"+map.get(s));
		}
		request.getSession().setAttribute("cost", map);
		
//		System.out.println(xs.getXh()+":"+start+":"+end);
		
//		return "student/FirstPage";
	}
	
//	@RequestMapping("/test")
//	public String test(HttpServletRequest request){
//		return "student/FirstPage";
//	}
	
//	@RequestMapping("/bookRec")
//	public String bookRec(HttpServletRequest request)
//	{
//		System.out.println("bookRec");
//		return "BookRec";
//	}
	
}
