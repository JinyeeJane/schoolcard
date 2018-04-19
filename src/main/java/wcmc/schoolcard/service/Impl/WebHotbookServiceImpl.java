package wcmc.schoolcard.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcmc.schoolcard.dao.WebhotbookMapper;
import wcmc.schoolcard.dto.Result4Hotbook;
import wcmc.schoolcard.service.WebHotbookService;

import java.util.List;

/**
 * Created by Channings on 18/4/18.
 */
@Service
public class WebHotbookServiceImpl implements WebHotbookService {
    @Autowired
    WebhotbookMapper webhotbookMapper;
    @Override
    public List<Result4Hotbook> selectbyTimeandFaculty(String begintime, String endtime, String faculty){
        return webhotbookMapper.selectbyTimeandFaculty(begintime,endtime,faculty);
    };
}
