package wcmc.schoolcard.dao;

import java.math.BigDecimal;
import java.util.List;

import wcmc.schoolcard.dto.Webgrade;

public interface WebgradeMapper {
	
	List<Webgrade> getGradeById(String id); 
	
}