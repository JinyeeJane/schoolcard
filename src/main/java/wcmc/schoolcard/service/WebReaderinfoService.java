package wcmc.schoolcard.service;

import wcmc.schoolcard.dto.WebReaderinfo;


public interface WebReaderinfoService {
	int deleteByPrimaryKey(String id);

	int insert(WebReaderinfo record);

	int insertSelective(WebReaderinfo record);

	WebReaderinfo selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(WebReaderinfo record);

	int updateByPrimaryKey(WebReaderinfo record);
	
	WebReaderinfo selectByXh(String xh);

}
