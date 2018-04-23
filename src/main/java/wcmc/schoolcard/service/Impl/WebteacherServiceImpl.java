package wcmc.schoolcard.service.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wcmc.schoolcard.dao.WebgradeMapper;
import wcmc.schoolcard.dao.WebteacherMapper;
import wcmc.schoolcard.dao.WebxsMapper;
import wcmc.schoolcard.dto.Webgrade;
import wcmc.schoolcard.dto.Webteacher;
import wcmc.schoolcard.dto.Webxs;
import wcmc.schoolcard.service.WebteacherService;

@Service
public class WebteacherServiceImpl implements WebteacherService{
	
	@Autowired
	private WebteacherMapper webteacherMapper;
	@Autowired
	private WebgradeMapper webgradeMapper;
	@Autowired 
	private WebxsMapper webxsMapper;

	@Override
	public Webteacher selectByIdAndPass(String id, String password) {
		// TODO Auto-generated method stub
		return webteacherMapper.selectByIdAndPass(id, password);
	}

	@Override
	public Map<String, String> getGradeByTeacher(String yxshmc) {
		// TODO Auto-generated method stub
//		List<Webxs> xsList = webxsMapper.selectXsByYxshmc(yxshmc);
//		List<Webgrade> gradeList = new ArrayList<>();
//		for (Webxs xs : xsList) {
//			gradeList.addAll(webgradeMapper.getGradeById(xs.getXsId()));
//		}
		List<Map<String, Object>> gradeList = webgradeMapper.getGradeByXy(yxshmc);
		Map<String, String> result = new HashMap<String, String>();
		for (Map<String, Object> map : gradeList){
			String key = null;
			String value = null;
			for (Map.Entry<String,Object>  entry:map.entrySet()){
				if ("KCMC".equals(entry.getKey())) {
	                key =  entry.getValue().toString();
	            }else if ("AVGFS".equals(entry.getKey())) {
	                value = (((BigDecimal) entry.getValue()).setScale(2,BigDecimal.ROUND_HALF_UP)).toString();
	            }
			}
			result.put(key, value);
		}
		return result;
	}

}
