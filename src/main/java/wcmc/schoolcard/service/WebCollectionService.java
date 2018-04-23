package wcmc.schoolcard.service;

import org.springframework.stereotype.Service;
import wcmc.schoolcard.dto.Webcollection;
import wcmc.schoolcard.dto.WebcollectionKey;

import java.util.List;


public interface WebCollectionService {
    int deleteByPrimaryKey(WebcollectionKey key);
    List<Webcollection> selectByReaderId(String readerid);
    int insert(Webcollection webcollection);
    List<String> selectBookidByReaderId(String readerid);
}
