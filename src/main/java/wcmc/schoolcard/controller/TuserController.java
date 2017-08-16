package wcmc.schoolcard.controller;

import java.math.BigDecimal;
import java.util.List;  

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
import wcmc.schoolcard.dto.Tuser;  
import wcmc.schoolcard.service.TuserService;
  
@Controller  
@RequestMapping("/tuser")  
public class TuserController {  
    @Autowired  
    private TuserService tuserService;  
      
    @RequestMapping("/tuserList")  
    public String TuserList(HttpServletRequest request,Model model){  
        List<Tuser> tuList = tuserService.selectAllUser();  
        model.addAttribute("tuList", tuList);  
        return "tuserList";  
    }  
      
    @RequestMapping("/showTuser")  
    public String showTuser(HttpServletRequest request,Model model){  
        BigDecimal userId = new BigDecimal(request.getParameter("id"));  
        Tuser tuser = tuserService.selectByPrimaryKey(userId);  
        model.addAttribute("tuser", tuser);  
        return "showTuser";  
    }  
      
    @RequestMapping("/addTuserUI")  
    public String addTuserUI(){  
        return "addTuser";  
    }  
      
    @RequestMapping("/addTuser")  
    public String addTuser(HttpServletRequest request,Model model){  
    	Tuser tuser = new Tuser(); 
    	tuser.setId(new BigDecimal(request.getParameter("id")));
    	tuser.setName(String.valueOf(request.getParameter("name")));  
    	tuser.setPassword(String.valueOf(request.getParameter("password")));  
    	tuser.setAge(new BigDecimal(request.getParameter("age")));  
        tuserService.insert(tuser);  
        return "redirect:/tuser/tuserList";  
    }  
}  
