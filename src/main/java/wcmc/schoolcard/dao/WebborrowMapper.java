package wcmc.schoolcard.dao;



import wcmc.schoolcard.dto.Webborrow;

import java.util.List;

public interface WebborrowMapper {
    List<Webborrow> selectByReaderId(String readerid);

}