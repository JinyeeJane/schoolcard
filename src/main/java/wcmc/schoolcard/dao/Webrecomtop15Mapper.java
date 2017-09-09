package wcmc.schoolcard.dao;

import wcmc.schoolcard.dto.WebRecomtop15;

public interface Webrecomtop15Mapper {
    int deleteByPrimaryKey(String readerid);

    WebRecomtop15 selectByPrimaryKey(String readerid);
}