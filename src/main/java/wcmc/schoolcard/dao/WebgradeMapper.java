package wcmc.schoolcard.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import wcmc.schoolcard.dto.Webgrade;

public interface WebgradeMapper {
	
	List<Webgrade> getGradeById(String id); 
	
	List<Map<String, Object>> getGradeByXy(String yxshmc);
	
}