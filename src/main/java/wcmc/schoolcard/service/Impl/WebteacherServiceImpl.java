package wcmc.schoolcard.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wcmc.schoolcard.dao.WebteacherMapper;
import wcmc.schoolcard.dto.Webteacher;
import wcmc.schoolcard.service.WebteacherService;

@Service
public class WebteacherServiceImpl implements WebteacherService{
	
	@Autowired
	private WebteacherMapper webteacherMapper;

	@Override
	public Webteacher selectByIdAndPass(String id, String password) {
		// TODO Auto-generated method stub
		return webteacherMapper.selectByIdAndPass(id, password);
	}

}
