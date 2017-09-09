package wcmc.schoolcard.dao;

import wcmc.schoolcard.dto.Webborrow;

import java.util.List;


public interface WebborrowMapper {
    int insert(Webborrow record);
    List<Webborrow> selectByReaderId(String readerid);
    int insertSelective(Webborrow record);
}