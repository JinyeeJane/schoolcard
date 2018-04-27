package wcmc.schoolcard.service;

import wcmc.schoolcard.dto.WebRecomtop15;
import wcmc.schoolcard.dto.Webbookinfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Channings on 17/9/8.
 */
public interface WebRecomService {
    int deleteByPrimaryKey(String readerid);

    WebRecomtop15 selectByPrimaryKey(String readerid);

    String recom(String readerid);
}
