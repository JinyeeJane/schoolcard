package wcmc.schoolcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wcmc.schoolcard.dto.Webbookinfo;
import wcmc.schoolcard.dto.Webborrow;
import wcmc.schoolcard.dto.Webrecomstatistics;
import wcmc.schoolcard.dto.WebRecomtop15;
import wcmc.schoolcard.service.WebBorrowService;
import wcmc.schoolcard.service.WebRecomStatisticsService;
import wcmc.schoolcard.service.WebRecomTop15Service;
import wcmc.schoolcard.service.WebBookInfoService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Channings on 17/9/7.
 */
@Controller
@RequestMapping("/recom")
public class RecomController {
    @Autowired
    private WebRecomStatisticsService webRecomStatisticsService;
    @Autowired
    private WebRecomTop15Service webRecomTop15Service;
    @Autowired
    private WebBookInfoService webBookInfoService;
    @Autowired
    private WebBorrowService WebBorrowService;



    @RequestMapping("/showstat")
    public String RecomStatistics(HttpServletRequest request, Model model){
        String type = new String(request.getParameter("type"));
        Webrecomstatistics Webrecomstatistics = webRecomStatisticsService.selectByType(type);
        model.addAttribute("RecomStatistics", Webrecomstatistics);
        return "selectStatByType";
    }


    @RequestMapping("/showRecomTop15")
    public String RecomTop15(HttpServletRequest request, Model model){
        String readerid = new String(request.getParameter("readerid"));
        WebRecomtop15 webRecomtop15 = webRecomTop15Service.selectByPrimaryKey(readerid);
        List<Webbookinfo> listOfRecBooks = new ArrayList<>();
        Class rectop15Class =  webRecomtop15.getClass();
        Webbookinfo webbookinfo;
        for(int i=1;i<=15;i++){

            try{
                Method method = rectop15Class.getMethod("getBookid"+i);
                webbookinfo = webBookInfoService.selectByPrimaryKey(method.invoke(webRecomtop15).toString());
                listOfRecBooks.add(webbookinfo);
            }
            catch (NoSuchMethodException e){
                System.out.println(e.toString());
            }
            catch (Exception e){
                System.out.println(e.toString());
            }

        }
        model.addAttribute("listOfRecBooks", listOfRecBooks);
        return "showRecomTop15";
    }

    @RequestMapping("/showHisBorrow")
    public String showHisBorrow(HttpServletRequest request, Model model){
        String readerid = new String(request.getParameter("readerid"));
        List<Webborrow> listOfBrorrow;
        List<Webbookinfo> listOfBroBookInfo = new ArrayList<>();
        listOfBrorrow = WebBorrowService.selectByReaderId(readerid);
        Webbookinfo webbookinfo;
        for(int i=0;i<listOfBrorrow.size();i++) {
            webbookinfo = webBookInfoService.selectByPrimaryKey(listOfBrorrow.get(i).getBookid());
            listOfBroBookInfo.add(webbookinfo);
        }


        model.addAttribute("listOfBroBookInfo", listOfBroBookInfo);
        return "showHisBorrow";
    }
}
