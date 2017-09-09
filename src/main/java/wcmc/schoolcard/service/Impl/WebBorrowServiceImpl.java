package wcmc.schoolcard.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcmc.schoolcard.dao.WebborrowMapper;
import wcmc.schoolcard.dto.Webborrow;
import wcmc.schoolcard.service.WebBorrowService;

import java.util.List;

/**
 * Created by Channings on 17/9/8.
 */
@Service
public class WebBorrowServiceImpl implements WebBorrowService {
    @Autowired
    private WebborrowMapper webborrowMapper;

    @Override
    public int insert(Webborrow record){
        return webborrowMapper.insert(record);
    }
    @Override
    public List<Webborrow> selectByReaderId(String readerid){
        return webborrowMapper.selectByReaderId(readerid);
    }
    public int insertSelective(Webborrow record){
        return webborrowMapper.insertSelective(record);
    }



}
