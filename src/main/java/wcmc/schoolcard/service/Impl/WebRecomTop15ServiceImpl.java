package wcmc.schoolcard.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcmc.schoolcard.dao.Webrecomtop15Mapper;
import wcmc.schoolcard.dto.WebRecomtop15;
import wcmc.schoolcard.service.WebRecomTop15Service;

/**
 * Created by Channings on 17/9/8.
 */
@Service
public class WebRecomTop15ServiceImpl implements WebRecomTop15Service {
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
}
