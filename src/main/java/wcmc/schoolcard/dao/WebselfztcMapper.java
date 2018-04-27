package wcmc.schoolcard.dao;

import wcmc.schoolcard.dto.Webselfztc;
import wcmc.schoolcard.dto.WebselfztcExample;
import wcmc.schoolcard.dto.WebselfztcKey;

import java.util.List;

public interface WebselfztcMapper {
    int deleteByExample(WebselfztcExample example);

    int deleteByPrimaryKey(WebselfztcKey key);

    int insert(Webselfztc record);

    int insertSelective(Webselfztc record);

    Webselfztc selectByPrimaryKey(WebselfztcKey key);

    List<String> selectZtcByReaderId(String readerid);

    List<String> selectZtcidByReaderId(String readerid);
}