package wcmc.schoolcard.dao;

import wcmc.schoolcard.dto.Webcanteen;

public interface WebcanteenMapper {
	
	Webcanteen getWebcanteenByXH(String xh);
	
}