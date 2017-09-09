package wcmc.schoolcard.service;

import wcmc.schoolcard.dto.WebRecomtop15;

/**
 * Created by Channings on 17/9/8.
 */
public interface WebRecomTop15Service {
    int deleteByPrimaryKey(String readerid);

    WebRecomtop15 selectByPrimaryKey(String readerid);
}
