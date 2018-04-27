package wcmc.schoolcard.service.Impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcmc.schoolcard.dao.*;
import wcmc.schoolcard.dto.WebRecomtop15;
import wcmc.schoolcard.dto.Webbookinfo;
import wcmc.schoolcard.service.WebRecomService;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebRecomServiceImpl implements WebRecomService {

    @Autowired
    private WebselfztcMapper webselfztcMapper;
    @Autowired
    private WebbookinfoMapper webbookinfoMapper;
    @Autowired
    private Webrecomtop15Mapper webrecomtop15Mapper;

    @Override
    public int deleteByPrimaryKey(String readerid){
        return   webrecomtop15Mapper.deleteByPrimaryKey(readerid);
    }
    @Override
    public WebRecomtop15 selectByPrimaryKey(String readerid){
        return  webrecomtop15Mapper.selectByPrimaryKey(readerid);
    }
    @Override
    public String recom(String readerid){
        Gson gson = new Gson();
        List<String> selfztcList;
        List<Webbookinfo> listofRecombyZtc = new ArrayList<>();
        List<Webbookinfo> listOfRecombyCf= new ArrayList<>();
        WebRecomtop15 webRecomtop15 = webrecomtop15Mapper.selectByPrimaryKey(readerid);
        selfztcList = webselfztcMapper.selectZtcByReaderId(readerid);
        System.out.println(selfztcList);
        if(selfztcList.size()!=0){
            listofRecombyZtc = webbookinfoMapper.selectByZtc(selfztcList);
            System.out.println(listofRecombyZtc.size());
            if(webRecomtop15 != null){
                Class rectop15Class =  webRecomtop15.getClass();
                Webbookinfo webbookinfo;
                for(int i=1;i<=15;i++){
                    try{
                        Method method = rectop15Class.getMethod("getBookid"+i);
                        webbookinfo = webbookinfoMapper.selectByPrimaryKey(method.invoke(webRecomtop15).toString());
                        listOfRecombyCf.add(webbookinfo);
                    }
                    catch (NoSuchMethodException e){
                        System.out.println(e.toString());
                    }
                    catch (Exception e){
                        System.out.println(e.toString());
                    }
                }
            }
        }
        listOfRecombyCf.addAll(listofRecombyZtc);
        if(listOfRecombyCf.size() == 0){
            return "null";
        }
        else{
            return gson.toJson(listOfRecombyCf);
        }
    };
}
