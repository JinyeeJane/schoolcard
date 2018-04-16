package wcmc.schoolcard.dao;

import wcmc.schoolcard.dto.Webborrowtimes;

public interface WebborrowtimesMapper {
	
	Webborrowtimes getWebborrowtimesByXH(String xh);
	
}