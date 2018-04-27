package wcmc.schoolcard.dao;

import org.apache.ibatis.annotations.Param;
import wcmc.schoolcard.dto.Webbookinfo;

import java.util.List;

public interface WebbookinfoMapper {
    int deleteByPrimaryKey(String bookid);

    Webbookinfo selectByPrimaryKey(String bookid);

    List<Webbookinfo> selectByBookIds(@Param("bookids")List<String> bookids);

    List<Webbookinfo> selectByBookOrAuthorName(String query);

    List<Webbookinfo> selectByZtc(@Param("ztcs")List<String> ztcs);

}