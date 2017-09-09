package wcmc.schoolcard.service;

import wcmc.schoolcard.dto.Webborrow;

import java.util.List;

/**
 * Created by Channings on 17/9/8.
 */
public interface WebBorrowService {
    int insert(Webborrow record);
    List<Webborrow> selectByReaderId(String readerid);
    int insertSelective(Webborrow record);
}
