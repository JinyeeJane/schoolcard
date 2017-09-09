package wcmc.schoolcard.service;

import wcmc.schoolcard.dto.Webrecomstatistics;

/**
 * Created by Channings on 17/9/8.
 */
public interface WebRecomStatisticsService {
    int insert(Webrecomstatistics record);

    Webrecomstatistics selectByType(String type);

    int insertSelective(Webrecomstatistics record);
}
