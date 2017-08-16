package wcmc.schoolcard.service.Impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wcmc.schoolcard.dao.TuserMapper;
import wcmc.schoolcard.dto.Tuser;
import wcmc.schoolcard.service.TuserService;

@Service
public class TuserServiceImpl implements TuserService{
	
	@Autowired
	private TuserMapper tuserMapper;

	@Override
	public int deleteByPrimaryKey(BigDecimal id) {
		// TODO Auto-generated method stub
		return tuserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Tuser record) {
		// TODO Auto-generated method stub
		return tuserMapper.insert(record);
	}

	@Override
	public int insertSelective(Tuser record) {
		// TODO Auto-generated method stub
		return tuserMapper.insertSelective(record);
	}

	@Override
	public Tuser selectByPrimaryKey(BigDecimal id) {
		// TODO Auto-generated method stub
		return tuserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Tuser record) {
		// TODO Auto-generated method stub
		return tuserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Tuser record) {
		// TODO Auto-generated method stub
		return tuserMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Tuser> selectAllUser() {
		// TODO Auto-generated method stub
		return tuserMapper.selectAllUser();
	}

}
