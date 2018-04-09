package wcmc.schoolcard.service;

import wcmc.schoolcard.dto.Webteacher;

public interface WebteacherService {

	Webteacher selectByIdAndPass(String id, String password);

}
