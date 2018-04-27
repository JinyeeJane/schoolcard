package wcmc.schoolcard.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcmc.schoolcard.dao.WebselfztcMapper;
import wcmc.schoolcard.dao.WebztcMapper;
import wcmc.schoolcard.dto.Webselfztc;
import wcmc.schoolcard.dto.WebselfztcKey;
import wcmc.schoolcard.dto.Webztc;
import wcmc.schoolcard.service.WebZtcService;

import java.util.List;

/**
 * Created by Channings on 18/4/25.
 */
@Service
public class WebZtcServiceImpl implements WebZtcService{
    @Autowired
    private WebztcMapper webztcMapper;
    @Autowired
    private WebselfztcMapper webselfztcMapper;

    @Override
    public List<Webztc> selectAll(){
        return webztcMapper.selectAll();
    };

    @Override
    public List<String> selectZtcByReaderId(String readerid){
        return  webselfztcMapper.selectZtcByReaderId(readerid);
    };
    public List<String> selectZtcidByReaderId(String readerid){
        return  webselfztcMapper.selectZtcidByReaderId(readerid);
    };
    @Override
    public int deleteByPrimaryKey(WebselfztcKey key){
        return webselfztcMapper.deleteByPrimaryKey(key);
    };
    @Override
    public int insert(Webselfztc record){
        return webselfztcMapper.insert(record);
    };
}
