package wcmc.schoolcard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import wcmc.schoolcard.dto.Webyktls;

public interface WebyktlsMapper {
	
	List<Webyktls> getYktlsByStartAndEnd(@Param("xh")String xh, @Param("start")Integer start, @Param("end")Integer end);
	List<Webyktls> selectByXH(String xh);
//	List<Webyktls> selectByXy(String xy);
	List<Map<String, Object>> selectByDay(String xy);
	List<Map<String, Object>> selectByMonth(String xy);
}