package wcmc.schoolcard.dao;

import java.math.BigDecimal;
import java.util.List;

import wcmc.schoolcard.dto.Webztc;

public interface WebztcMapper {
    int deleteByPrimaryKey(BigDecimal id);

    Webztc selectByPrimaryKey(BigDecimal id);

    List<Webztc> selectAll();
}