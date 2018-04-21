package wcmc.schoolcard.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import wcmc.schoolcard.dto.WebReaderinfo;
import wcmc.schoolcard.dto.Webgrade;
import wcmc.schoolcard.dto.Webrecomstatistics;
import wcmc.schoolcard.dto.Webxs;
import wcmc.schoolcard.dto.Webyktls;
import wcmc.schoolcard.service.WebReaderinfoService;
import wcmc.schoolcard.service.WebRecomStatisticsService;
import wcmc.schoolcard.service.WebgradeService;
import wcmc.schoolcard.service.WebxsService;
import wcmc.schoolcard.service.WebyktlsService;


@Controller
@RequestMapping("/stuLogin")
public class WebxsController {
	
	@Autowired
	private WebxsService webxsService;
	@Autowired
	private WebyktlsService webyktlsService; 
	@Autowired
	private WebgradeService webgradeService;
	
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
	
	@RequestMapping(value="/cost", produces="application/json;charset=UTF-8;")
	public @ResponseBody String cost(HttpServletRequest request, Model model){
		Webxs xs = (Webxs) request.getSession().getAttribute("xs");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
//		System.out.println(start+"-"+ end);
		TreeMap<String, Double> map = webyktlsService.getYktlsByStartAndEnd(xs.getXh(), start, end);
		Gson gson = new Gson();
        String cost= gson.toJson(map);
		return cost;
		
	}
	
	@RequestMapping(value="/bad", produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String bad(HttpServletRequest request, Model model){
		Webxs webxs = (Webxs) request.getSession().getAttribute("xs");
		List<Webgrade> list = webgradeService.getBadGradeById(webxs.getXsId());
		List<String> slist = new ArrayList<String>();
		for (Webgrade webgrade : list) {
			slist.add(webgrade.getKcmc());
		}
		Gson gson = new Gson();
        String bad= gson.toJson(slist);
		return bad;
	}
	
}
