package wcmc.schoolcard.service;

import java.util.List;
import java.util.Map;

import wcmc.schoolcard.dto.Webgrade;
import wcmc.schoolcard.dto.Webteacher;

public interface WebteacherService {

	Webteacher selectByIdAndPass(String id, String password);
	
	Map<String, String> getGradeByTeacher(String yxshmc);

}
