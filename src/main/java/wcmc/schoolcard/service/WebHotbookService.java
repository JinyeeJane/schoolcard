package wcmc.schoolcard.service;

import wcmc.schoolcard.dto.Result4Hotbook;

import java.util.List;

/**
 * Created by Channings on 18/4/18.
 */
public interface WebHotbookService {
    public List<Result4Hotbook> selectbyTimeandFaculty(String begintime, String endtime, String faculty);
}
