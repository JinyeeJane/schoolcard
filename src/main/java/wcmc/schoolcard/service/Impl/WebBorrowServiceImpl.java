package wcmc.schoolcard.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wcmc.schoolcard.dao.WebborrowMapper;
import wcmc.schoolcard.dto.Webborrow;

import wcmc.schoolcard.service.WebBorrowService;

import java.util.List;

@Service
public class WebBorrowServiceImpl implements WebBorrowService {
    @Autowired
    private WebborrowMapper webborrowMapper;
    
    @Override
    public List<Webborrow> selectByReaderId(String readerid){
        return webborrowMapper.selectByReaderId(readerid);
    };

}
