package wcmc.schoolcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wcmc.schoolcard.dto.*;
import wcmc.schoolcard.service.*;
import com.google.gson.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import wcmc.schoolcard.dto.Webxs;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bookrecom")
public class RecomController {
    @Autowired
    private WebRecomStatisticsService webRecomStatisticsService;
    @Autowired
    private WebRecomTop15Service webRecomTop15Service;
    @Autowired
    private WebBookInfoService webBookInfoService;
    @Autowired
    private WebBorrowService webBorrowService;

    @Autowired
    private WebReaderinfoService webReaderinfoService;

    @RequestMapping("/")
    public String BookRecom(HttpServletRequest request, Model model){
//        String type = new String(request.getParameter("type"));
//        Webrecomstatistics Webrecomstatistics = webRecomStatisticsService.selectByType(type);
//        model.addAttribute("RecomStatistics", Webrecomstatistics);

        HttpSession session = request.getSession();

        Webxs xs = (Webxs)session.getAttribute("xs");

        WebReaderinfo webReaderinfo= webReaderinfoService.selectByXh(xs.getXh());

        String readerid = webReaderinfo.getReaderid();

        //借阅历史

        List<Webborrow> listOfBrorrow;

        List<Webbookinfo> listOfBroBookInfo = new ArrayList<>();

        listOfBrorrow = webBorrowService.selectByReaderId(readerid);

        Webbookinfo webbookinfo;

        for(int i=0;i<listOfBrorrow.size();i++) {
            webbookinfo = webBookInfoService.selectByPrimaryKey(listOfBrorrow.get(i).getBookid());
            listOfBroBookInfo.add(webbookinfo);
        }

        model.addAttribute("listOfBroBookInfo", listOfBroBookInfo);

        //个性化推荐

        WebRecomtop15 webRecomtop15 = webRecomTop15Service.selectByPrimaryKey(readerid);

        List<Webbookinfo> listOfRecBooks = new ArrayList<>();

        Class rectop15Class =  webRecomtop15.getClass();

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

        return "bookrecom/bookRecom";
    }

    @RequestMapping("/search")
    public String SearchBook(HttpServletRequest request, Model model){
        //根据书籍名字或作者名字查询书籍
        String query = request.getParameter("query");
        List<Webbookinfo> result4query = webBookInfoService.selectByBookOrAuthorName('%'+query+'%');
//        Gson gson = new Gson();
//
//        String jsonResult4query =  gson.toJson(result4query);
//        model.addAttribute("jsonResult4query", jsonResult4query);
        model.addAttribute("result4query", result4query);
//        System.out.println(jsonResult4query);
        System.out.println(result4query.size());
        return "bookrecom/ajax/search";
    }

    @RequestMapping("/hotbook")
    public String RecomStatistics(HttpServletRequest request, Model model){
        //热门书籍查询
        String type = request.getParameter("type");
        Webrecomstatistics hotbook = webRecomStatisticsService.selectByType(type);
        model.addAttribute("hotbook", hotbook);
        return "bookrecom/ajax/hotBook";
    }
}
