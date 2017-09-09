package wcmc.schoolcard.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wcmc.schoolcard.dao.WebxsMapper;
import wcmc.schoolcard.dto.Webxs;
import wcmc.schoolcard.service.WebxsService;

@Service
public class WebxsServiceImpl implements WebxsService{
	
	@Autowired
	private WebxsMapper webxsMapper;

	@Override
	public int deleteByPrimaryKey(String xh) {
		// TODO Auto-generated method stub
		return webxsMapper.deleteByPrimaryKey(xh);
	}

	@Override
	public int insert(Webxs record) {
		// TODO Auto-generated method stub
		return webxsMapper.insert(record);
	}

	@Override
	public int insertSelective(Webxs record) {
		// TODO Auto-generated method stub
		return webxsMapper.insertSelective(record);
	}

	@Override
	public Webxs selectByPrimaryKey(String xh) {
		// TODO Auto-generated method stub
		return webxsMapper.selectByPrimaryKey(xh);
	}

	@Override
	public int updateByPrimaryKeySelective(Webxs record) {
		// TODO Auto-generated method stub
		return webxsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Webxs record) {
		// TODO Auto-generated method stub
		return webxsMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Webxs> selectAllUser() {
		// TODO Auto-generated method stub
		return webxsMapper.selectAllUser();
	}


}
