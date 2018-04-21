package wcmc.schoolcard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import wcmc.schoolcard.dto.Webyktls;

public interface WebyktlsMapper {
	
	List<Webyktls> getYktlsByStartAndEnd(@Param("xh")String xh, @Param("start")Integer start, @Param("end")Integer end);
	List<Webyktls> selectByXH(String xh);
}