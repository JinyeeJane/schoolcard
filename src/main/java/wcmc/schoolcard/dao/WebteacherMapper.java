package wcmc.schoolcard.dao;

import wcmc.schoolcard.dto.Webteacher;

public interface WebteacherMapper {
    
	Webteacher selectByIdAndPass(String id, String password);
    
}