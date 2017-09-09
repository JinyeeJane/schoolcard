package wcmc.schoolcard.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcmc.schoolcard.dao.WebbookinfoMapper;
import wcmc.schoolcard.dto.Webbookinfo;
import wcmc.schoolcard.service.WebBookInfoService;

import java.util.List;

/**
 * Created by Channings on 17/9/9.
 */
@Service
public class WebBookInfoServiceImpl implements WebBookInfoService{
    @Autowired
    private WebbookinfoMapper webbookinfoMapper;

    @Override
    public int deleteByPrimaryKey(String bookid){
        return webbookinfoMapper.deleteByPrimaryKey(bookid);
    }
    @Override
    public Webbookinfo selectByPrimaryKey(String bookid){
        return webbookinfoMapper.selectByPrimaryKey(bookid);
    }
    @Override
    public List<Webbookinfo> selectByBookIds(List<String> bookids){
        return webbookinfoMapper.selectByBookIds(bookids);
    }
}
