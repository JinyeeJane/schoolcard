package wcmc.schoolcard.service;

import wcmc.schoolcard.dto.Webbookinfo;

import java.util.List;

public interface WebBookInfoService {

    int deleteByPrimaryKey(String bookid);

    Webbookinfo selectByPrimaryKey(String bookid);

    List<Webbookinfo> selectByBookIds(List<String> bookids);

    List<Webbookinfo> selectByBookOrAuthorName(String query);

    List<Webbookinfo> selectByZtc(List<String> ztcs);
}
