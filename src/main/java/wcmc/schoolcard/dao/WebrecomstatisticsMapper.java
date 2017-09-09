package wcmc.schoolcard.dao;

import wcmc.schoolcard.dto.Webrecomstatistics;


public interface WebrecomstatisticsMapper {
    int insert(Webrecomstatistics record);

    Webrecomstatistics selectByType(String type);

    int insertSelective(Webrecomstatistics record);
}