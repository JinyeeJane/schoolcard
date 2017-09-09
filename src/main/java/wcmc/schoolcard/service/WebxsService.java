package wcmc.schoolcard.service;

import java.util.List;


import wcmc.schoolcard.dto.Webxs;


public interface WebxsService {

	int deleteByPrimaryKey(String id);

	int insert(Webxs record);

	int insertSelective(Webxs record);

	Webxs selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Webxs record);

	int updateByPrimaryKey(Webxs record);

	List<Webxs> selectAllUser();
	
  
}
