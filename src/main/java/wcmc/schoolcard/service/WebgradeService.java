package wcmc.schoolcard.service;

import java.util.List;

import wcmc.schoolcard.dto.Webgrade;

public interface WebgradeService {

	List<Webgrade> getGradeById(String id);
	List<Webgrade> getBadGradeById(String id);
	
}
