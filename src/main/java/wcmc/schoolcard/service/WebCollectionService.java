package wcmc.schoolcard.service;

import org.springframework.stereotype.Service;
import wcmc.schoolcard.dto.Webcollection;
import wcmc.schoolcard.dto.WebcollectionKey;

import java.util.List;

/**
 * Created by Channings on 18/4/21.
 */

public interface WebCollectionService {
    int deleteByPrimaryKey(WebcollectionKey key);
    List<Webcollection> selectByReaderId(String readerid);


}
