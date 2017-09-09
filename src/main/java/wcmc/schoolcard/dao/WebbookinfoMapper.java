package wcmc.schoolcard.dao;

import wcmc.schoolcard.dto.Webbookinfo;

import java.util.List;

public interface WebbookinfoMapper {
    int deleteByPrimaryKey(String bookid);

    Webbookinfo selectByPrimaryKey(String bookid);

    List<Webbookinfo> selectByBookIds(List<String> bookids);

}