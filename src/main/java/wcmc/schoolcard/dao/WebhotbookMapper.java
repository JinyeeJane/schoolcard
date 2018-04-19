package wcmc.schoolcard.dao;

import org.apache.ibatis.annotations.Param;
import wcmc.schoolcard.dto.Result4Hotbook;

import java.sql.ResultSet;
import java.util.List;

public interface WebhotbookMapper {
    public List<Result4Hotbook> selectbyTimeandFaculty(@Param("begintime")String begintime, @Param("endtime")String endtime, @Param("faculty")String faculty);
}