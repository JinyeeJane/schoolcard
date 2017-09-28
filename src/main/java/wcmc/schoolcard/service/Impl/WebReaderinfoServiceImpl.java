package wcmc.schoolcard.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wcmc.schoolcard.dao.WebReaderinfoMapper;
import wcmc.schoolcard.dto.WebReaderinfo;
import wcmc.schoolcard.service.WebReaderinfoService;

@Service
public class WebReaderinfoServiceImpl implements WebReaderinfoService {

	@Autowired
	private WebReaderinfoMapper webReaderinfoMapper;
	
	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return webReaderinfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(WebReaderinfo record) {
		// TODO Auto-generated method stub
		return webReaderinfoMapper.insert(record);
	}

	@Override
	public int insertSelective(WebReaderinfo record) {
		// TODO Auto-generated method stub
		return webReaderinfoMapper.insertSelective(record);
	}

	@Override
	public WebReaderinfo selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return webReaderinfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(WebReaderinfo record) {
		// TODO Auto-generated method stub
		return webReaderinfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(WebReaderinfo record) {
		// TODO Auto-generated method stub
		return webReaderinfoMapper.updateByPrimaryKey(record);
	}

	@Override
	public WebReaderinfo selectByXh(String xh) {
		// TODO Auto-generated method stub
		return webReaderinfoMapper.selectByXh(xh);
	}

}
