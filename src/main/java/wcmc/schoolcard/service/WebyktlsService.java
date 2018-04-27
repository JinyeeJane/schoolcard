package wcmc.schoolcard.service;

import java.util.List;
import java.util.TreeMap;

import wcmc.schoolcard.dto.Webyktls;

public interface WebyktlsService {
	TreeMap<String, Double> getYktlsByStartAndEnd(String xh, String start, String end);
	TreeMap<String, Double> getYktlsByXy(String xy, String start, String end);
}
