package wcmc.schoolcard.service.Impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wcmc.schoolcard.dao.WebyktlsMapper;
import wcmc.schoolcard.dto.Webyktls;
import wcmc.schoolcard.service.WebyktlsService;

@Service
public class WebyktlsServiceImpl implements WebyktlsService{
	
	@Autowired
	private WebyktlsMapper webyktlsMapper;

	@Override
	public TreeMap<String, Double> getYktlsByStartAndEnd(String xh, String start, String end) {
		// TODO Auto-generated method stub
		Map<String, Double> map = new TreeMap<String, Double>();
		List<Webyktls> list = webyktlsMapper.selectByXH(xh);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		long days = 0;
		try {
			days = (sf.parse(end).getTime()-sf.parse(start).getTime())/(1000*60*60*24);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (days > 31) {
			for (Webyktls webyktls : list) {
				if (Integer.parseInt(webyktls.getJysj().split(" ")[0]) > Integer.parseInt(start.replaceAll("-", "")) && Integer.parseInt(webyktls.getJysj().split(" ")[0]) < Integer.parseInt(end.replaceAll("-", ""))) {
					String key = webyktls.getJysj().substring(0,6);
					if (map.containsKey(key)) {
						map.put(key, map.get(key)+webyktls.getSjjye().doubleValue());
					} else {
						map.put(key, webyktls.getSjjye().doubleValue());
					}
				}
			}
		} else {
			for (Webyktls webyktls : list) {
				if (Integer.parseInt(webyktls.getJysj().split(" ")[0]) > Integer.parseInt(start.replaceAll("-", "")) && Integer.parseInt(webyktls.getJysj().split(" ")[0]) < Integer.parseInt(end.replaceAll("-", ""))) {
					String key = webyktls.getJysj().substring(0,8);
					if (map.containsKey(key)) {
						map.put(key, map.get(key)+webyktls.getSjjye().doubleValue());
					} else {
						map.put(key, webyktls.getSjjye().doubleValue());
					}
				}
			}
		}
		return (TreeMap<String, Double>) map;
	}

	@Override
	public TreeMap<String, Double> getYktlsByXy(String xy, String start,
			String end) {
		Map<String, Double> result = new TreeMap<String, Double>();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		long days = 0;
		try {
			days = (sf.parse(end).getTime()-sf.parse(start).getTime())/(1000*60*60*24);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		if (days > 31) {
			list = webyktlsMapper.selectByMonth(xy);
		} else {
			list = webyktlsMapper.selectByDay(xy);
		}
		for (Map<String, Object> map : list){
			String key = null;
			Double value = null;
			for (Map.Entry<String,Object>  entry : map.entrySet()){
				if ("TIME".equals(entry.getKey())) {
	                key =  entry.getValue().toString();
	            }else if ("TOTAL".equals(entry.getKey())) {
	                value = (((BigDecimal) entry.getValue()).setScale(2,BigDecimal.ROUND_HALF_UP)).doubleValue();
	            }
			}
			result.put(key, value);
		}
		return (TreeMap<String, Double>) result;
	}

}
