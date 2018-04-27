package wcmc.schoolcard.service;

import wcmc.schoolcard.dto.Webselfztc;
import wcmc.schoolcard.dto.WebselfztcKey;
import wcmc.schoolcard.dto.Webztc;
import java.util.List;

public interface WebZtcService {
    List<Webztc> selectAll();
    List<String> selectZtcByReaderId(String readerid);
    List<String> selectZtcidByReaderId(String readerid);
    int deleteByPrimaryKey(WebselfztcKey key);
    int insert(Webselfztc record);
}
