package wcmc.schoolcard.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcmc.schoolcard.dao.WebrecomstatisticsMapper;
import wcmc.schoolcard.dto.Webrecomstatistics;
import wcmc.schoolcard.service.WebRecomStatisticsService;

/**
 * Created by Channings on 17/9/8.
 */
@Service
public class WebRecomStatisticsServiceImpl implements WebRecomStatisticsService {
    @Autowired
    private WebrecomstatisticsMapper webrecomstatisticsMapper;
    @Override
    public int insert(Webrecomstatistics record){
        return webrecomstatisticsMapper.insert(record);
    }
    @Override
    public Webrecomstatistics selectByType(String type){
        return webrecomstatisticsMapper.selectByType(type);
    }
    @Override
    public int insertSelective(Webrecomstatistics record){
        return webrecomstatisticsMapper.insertSelective(record);
    }
}
