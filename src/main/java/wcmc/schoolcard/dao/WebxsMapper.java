package wcmc.schoolcard.dao;

import java.util.List;

import wcmc.schoolcard.dto.Webxs;

public interface WebxsMapper {
    int deleteByPrimaryKey(String xh);

    int insert(Webxs record);

    int insertSelective(Webxs record);

    Webxs selectByPrimaryKey(String xh);

    int updateByPrimaryKeySelective(Webxs record);

    int updateByPrimaryKey(Webxs record);
    
    List<Webxs> selectAllUser();
    
}