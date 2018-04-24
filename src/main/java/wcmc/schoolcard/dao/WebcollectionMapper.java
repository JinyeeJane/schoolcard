package wcmc.schoolcard.dao;

import wcmc.schoolcard.dto.Webcollection;
import wcmc.schoolcard.dto.WebcollectionKey;

import java.util.List;

public interface WebcollectionMapper {
    int deleteByPrimaryKey(WebcollectionKey key);

    Webcollection selectByPrimaryKey(WebcollectionKey key);

    List<Webcollection> selectByReaderId(String readerid);

    int insert(Webcollection conllection);

    List<String> selectBookidByReaderId(String readerid);
}