package wcmc.schoolcard.service;

import wcmc.schoolcard.dto.Webbookinfo;

import java.util.List;

/**
 * Created by Channings on 17/9/9.
 */
public interface WebBookInfoService {

    int deleteByPrimaryKey(String bookid);

    Webbookinfo selectByPrimaryKey(String bookid);

    List<Webbookinfo> selectByBookIds(List<String> bookids);
}
