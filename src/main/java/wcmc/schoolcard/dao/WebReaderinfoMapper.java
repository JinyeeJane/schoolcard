package wcmc.schoolcard.dao;

import wcmc.schoolcard.dto.WebReaderinfo;

public interface WebReaderinfoMapper {
    int deleteByPrimaryKey(String readerid);

    int insert(WebReaderinfo record);

    int insertSelective(WebReaderinfo record);

    WebReaderinfo selectByPrimaryKey(String readerid);

    int updateByPrimaryKeySelective(WebReaderinfo record);

    int updateByPrimaryKey(WebReaderinfo record);
    
    WebReaderinfo selectByXh(String xh);
}