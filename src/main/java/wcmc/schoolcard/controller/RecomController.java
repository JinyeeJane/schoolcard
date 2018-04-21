package wcmc.schoolcard.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wcmc.schoolcard.dto.*;
import wcmc.schoolcard.service.*;
import com.google.gson.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import wcmc.schoolcard.dto.Webxs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bookrecom")
public class RecomController {
    @Autowired
    private WebRecomTop15Service webRecomTop15Service;
    @Autowired
    private WebBookInfoService webBookInfoService;
    @Autowired
    private WebBorrowService webBorrowService;
    @Autowired
    private WebReaderinfoService webReaderinfoService;
    @Autowired
    private WebHotbookService webHotbookService;

    @RequestMapping("/")
    public String BookRecom(HttpServletRequest request, Model model){

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

        //热门书籍查询
        String begintime = "20000000";
        String endtime = "20100000";
        String faculty = "信息科学与工程学院";
        List<Result4Hotbook> hotbook = webHotbookService.selectbyTimeandFaculty(begintime,endtime,faculty);
        Gson gson = new Gson();
        String hotbookGson= gson.toJson(hotbook);
        model.addAttribute("hotbook", hotbookGson);

        return "bookrecom/bookRecom";

    }

    @RequestMapping("/search")
    public String SearchBook(HttpServletRequest request, Model model){
        //根据书籍名字或作者名字查询书籍
        String query = request.getParameter("query");
        List<Webbookinfo> result4query = webBookInfoService.selectByBookOrAuthorName('%'+query+'%');
        model.addAttribute("result4query", result4query);
        System.out.println(result4query.size());
        return "bookrecom/ajax/search";
    }
    @RequestMapping("/search2")
    public String SearchBook2(HttpServletRequest request, Model model){
        //根据书籍名字或作者名字查询书籍
        String query = request.getParameter("query");
        System.out.println(query);
        List<Webbookinfo> result4query = webBookInfoService.selectByBookOrAuthorName('%'+query+'%');
        Gson gson = new Gson();
        String result4queryGson= gson.toJson(result4query);
        model.addAttribute("result4queryGson", result4queryGson);

        System.out.println(result4query.size());

        return "bookrecom/ajax/search2";
    }

    @RequestMapping("/tagcloud")
    public String tag(HttpServletRequest request, Model model){
        //根据书籍名字或作者名字查询书籍
//        Gson gson = new Gson();
//        String dir = request.getSession().getServletContext()
//                .getRealPath("/resources/js/tagcloud/tags.json");
//        try{
//            FileInputStream fileInputStream = new FileInputStream(dir);
//            Reader reader = new InputStreamReader(fileInputStream, "UTF-8");
//            gson.
//        }catch (IOException e){
//            e.printStackTrace();
//        }

        return "bookrecom/ajax/tagcloud";
    }

    @RequestMapping(value = "/hotbook", produces="application/json;charset=UTF-8;")
    public @ResponseBody String RecomStatistics(HttpServletRequest request){
        //热门书籍查询
        String begintime = null;
        String endtime = null;
        String faculty = null;

        if (request.getParameter("begintime")==null){
            begintime = "20080000";
            endtime= "20120000";
            faculty = "信息科学与工程学院";

        }
        else {
             begintime = request.getParameter("begintime");
             endtime = request.getParameter("endtime");
             faculty = request.getParameter("faculty");
            System.out.println(begintime+faculty+endtime);
        }

        List<Result4Hotbook> hotbook = webHotbookService.selectbyTimeandFaculty(begintime,endtime,faculty);
        Gson Gson = new Gson();
        String hotbookGson= Gson.toJson(hotbook);
        System.out.println(hotbook.size());
        return hotbookGson;
    }

    @RequestMapping(value = "/history", produces="application/json;charset=UTF-8;")
    public  @ResponseBody String BrorrowHistory(HttpServletRequest request){

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
        Gson Gson = new Gson();
        String listOfBroBookInfoGson= Gson.toJson(listOfBroBookInfo);
        System.out.println(listOfBroBookInfo.size());
        return listOfBroBookInfoGson;

    }

    @RequestMapping("/newbookrecom")
    public String test(HttpServletRequest request, Model model){

        HttpSession session = request.getSession();
        Webxs xs = (Webxs)session.getAttribute("xs");
        WebReaderinfo webReaderinfo= webReaderinfoService.selectByXh(xs.getXh());
        String readerid = webReaderinfo.getReaderid();
        WebRecomtop15 webRecomtop15 = webRecomTop15Service.selectByPrimaryKey(readerid);
        System.out.println(webRecomtop15.getBookid1());
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
        Gson gson = new Gson();
        String listOfRecBooksGson= gson.toJson(listOfRecBooks);
        model.addAttribute("listOfRecBooks", listOfRecBooksGson);


        return "bookrecom/newBookRecom";
    }
}
