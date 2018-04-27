package wcmc.schoolcard.controller;


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


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/bookrecom")
public class RecomController {
    @Autowired
    private WebRecomService webRecomService;
    @Autowired
    private WebBookInfoService webBookInfoService;
    @Autowired
    private WebBorrowService webBorrowService;
    @Autowired
    private WebReaderinfoService webReaderinfoService;
    @Autowired
    private WebHotbookService webHotbookService;
    @Autowired
    private WebCollectionService webCollectionService;
    @Autowired
    private WebZtcService webZtcService;

    @RequestMapping("/search2")
    public String SearchBook2(HttpServletRequest request, Model model){
        //根据书籍名字或作者名字查询书籍
        HttpSession session = request.getSession();
        Webxs xs = (Webxs)session.getAttribute("xs");
        WebReaderinfo webReaderinfo= webReaderinfoService.selectByXh(xs.getXh());
        String readerid = webReaderinfo.getReaderid();

        String query = request.getParameter("query");
        System.out.println(query);
        List<Webbookinfo> result4query = webBookInfoService.selectByBookOrAuthorName('%'+query+'%');
        Gson gson = new Gson();
        String result4queryGson= gson.toJson(result4query);
        model.addAttribute("result4queryGson", result4queryGson);

        List<Webcollection> collectionList;
        collectionList = webCollectionService.selectByReaderId(readerid);
        String collectionListGson = gson.toJson(collectionList);
        model.addAttribute("collectionListGson",collectionListGson);
        System.out.println(result4query.size());

        return "bookrecom/ajax/search2";
    }

    @RequestMapping(value = "/tags", produces="application/json;charset=UTF-8;")
    public  @ResponseBody String tags(HttpServletRequest request, Model model){
        Gson gson = new Gson();
        List<Webztc> webztcList;
        webztcList = webZtcService.selectAll();
        String webztcListgson = gson.toJson(webztcList);
        return webztcListgson;
    }

    @RequestMapping(value = "/selftag", produces="application/json;charset=UTF-8;")
    public  @ResponseBody String selftag(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Webxs xs = (Webxs)session.getAttribute("xs");
        WebReaderinfo webReaderinfo= webReaderinfoService.selectByXh(xs.getXh());
        String readerid = webReaderinfo.getReaderid();
        Gson gson = new Gson();
        List<String> webselfztcList;
        webselfztcList = webZtcService.selectZtcidByReaderId(readerid);
        String webselfztcListgson  =  gson.toJson(webselfztcList);
        return webselfztcListgson;
    }

    @RequestMapping(value = "/addordeltag")
    public  @ResponseBody String addordeltag(HttpServletRequest request){
        HttpSession session = request.getSession();
        Webxs xs = (Webxs)session.getAttribute("xs");
        WebReaderinfo webReaderinfo= webReaderinfoService.selectByXh(xs.getXh());
        String readerid = webReaderinfo.getReaderid();
        String ztcid = request.getParameter("ztcid");
        String ztc = request.getParameter("ztc");
        String addordeltag = request.getParameter("addordeltag");

        if (addordeltag.equals("false")){
            WebselfztcKey key = new WebselfztcKey();
            key.setReaderid(readerid);
            key.setZtcid(ztcid);
            webZtcService.deleteByPrimaryKey(key);
        }
        else {
            Webselfztc record = new Webselfztc();
            record.setReaderid(readerid);
            record.setZtcid(ztcid);
            record.setZtc(ztc);
            webZtcService.insert(record);
        }
        return "success";
    }

    @RequestMapping(value = "/hotbook", produces="application/json;charset=UTF-8;")
    public @ResponseBody String RecomStatistics(HttpServletRequest request){
        //热门书籍查询
        String begintime ;
        String endtime ;
        String faculty ;
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

        if(hotbook.size() == 0){
            return "null";
        }
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
        if(listOfBrorrow.size() == 0){
            return "null";
        }
        else {
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
    }
    @RequestMapping(value = "/collection")
    public  @ResponseBody String collection(HttpServletRequest request){
        SimpleDateFormat  simpleDateFormat= new SimpleDateFormat("yyyyMMddHHmmss");
        String time = simpleDateFormat.format(new Date());
        System.out.println(time);
        HttpSession session = request.getSession();
        Webxs xs = (Webxs)session.getAttribute("xs");
        WebReaderinfo webReaderinfo= webReaderinfoService.selectByXh(xs.getXh());
        String readerid = webReaderinfo.getReaderid();
        String bookid = request.getParameter("bookid");
        String addordel = request.getParameter("addordel");
        if (addordel.equals("false")){
            WebcollectionKey key = new WebcollectionKey();
            key.setReaderid(readerid);
            key.setBookid(bookid);
            webCollectionService.deleteByPrimaryKey(key);
        }
        else {
            Webcollection webcollection =new Webcollection();
            webcollection.setTime(time);
            webcollection.setBookid(bookid);
            webcollection.setReaderid(readerid);
            webCollectionService.insert(webcollection);
        }
        return "success";
    }

    @RequestMapping(value = "/showcollection",produces="application/json;charset=UTF-8;")
    public  @ResponseBody String showcollection(HttpServletRequest request){
        HttpSession session = request.getSession();
        Webxs xs = (Webxs)session.getAttribute("xs");
        WebReaderinfo webReaderinfo= webReaderinfoService.selectByXh(xs.getXh());
        String readerid = webReaderinfo.getReaderid();
        List<String> collectionBookidList;
        List<Webbookinfo> webbookinfoList;
        collectionBookidList = webCollectionService.selectBookidByReaderId(readerid);
        if(collectionBookidList.size() == 0){
            return "null";
        }
        else {
            webbookinfoList = webBookInfoService.selectByBookIds(collectionBookidList);
            Gson gson =new Gson();
            String webbookinfoListGson = gson.toJson(webbookinfoList);
            return webbookinfoListGson;
        }

    }

    @RequestMapping("/newbookrecom")
    public String bookrecom(HttpServletRequest request, Model model){

        HttpSession session = request.getSession();
        Webxs xs = (Webxs)session.getAttribute("xs");
        WebReaderinfo webReaderinfo= webReaderinfoService.selectByXh(xs.getXh());
        String readerid = webReaderinfo.getReaderid();
        Gson gson = new Gson();
//        WebRecomtop15 webRecomtop15 = webRecomService.selectByPrimaryKey(readerid);

//        if(webRecomtop15 != null){
//            List<Webbookinfo> listOfRecBooks = new ArrayList<>();
//            Class rectop15Class =  webRecomtop15.getClass();
//            Webbookinfo webbookinfo;
//            for(int i=1;i<=15;i++){
//                try{
//                    Method method = rectop15Class.getMethod("getBookid"+i);
//                    webbookinfo = webBookInfoService.selectByPrimaryKey(method.invoke(webRecomtop15).toString());
//                    listOfRecBooks.add(webbookinfo);
//                }
//                catch (NoSuchMethodException e){
//                    System.out.println(e.toString());
//                }
//                catch (Exception e){
//                    System.out.println(e.toString());
//                }
//            }
//            String listOfRecBooksGson= gson.toJson(listOfRecBooks);
//            model.addAttribute("listOfRecBooks", listOfRecBooksGson);
//        }
//        else{
//            model.addAttribute("listOfRecBooks", "null");
//        }
        String listOfRecBooksGson = webRecomService.recom(readerid);
        model.addAttribute("listOfRecBooks", listOfRecBooksGson);
        List<String> collectionBookidList;
        collectionBookidList = webCollectionService.selectBookidByReaderId(readerid);
        System.out.println(collectionBookidList);
        String collectionBookidListGson = gson.toJson(collectionBookidList);
        model.addAttribute("collectionBookidList",collectionBookidListGson);
        return "bookrecom/newBookRecom";
    }
}
