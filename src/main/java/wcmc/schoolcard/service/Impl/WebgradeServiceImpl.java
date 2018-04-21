package wcmc.schoolcard.service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wcmc.schoolcard.dao.WebgradeMapper;
import wcmc.schoolcard.dto.Webgrade;
import wcmc.schoolcard.service.WebgradeService;

@Service
public class WebgradeServiceImpl implements WebgradeService{

	@Autowired
	private WebgradeMapper webgradeMapper;
	
	@Override
	public List<Webgrade> getGradeById(String id) {
		// TODO Auto-generated method stub
		return webgradeMapper.getGradeById(id);
	}

	@Override
	public List<Webgrade> getBadGradeById(String id) {
		// TODO Auto-generated method stub
		List<Webgrade> list = webgradeMapper.getGradeById(id);
		List<Webgrade> result = new ArrayList<>();
		for (Webgrade webgrade : list) {
			String fs = webgrade.getFslkxcj();
			if (fs == null || fs.trim().equals("")) {
				result.add(webgrade);
			}
			try {
				double score = Double.parseDouble(fs);
				if (score < 60) {
					result.add(webgrade);
				}
			} catch (Exception e) {
				// TODO: handle exception
				if (fs.equals("不合格") || fs.equals("不通过") || fs.equals("不及格")) {
					result.add(webgrade);
				}
			}
		}
		return result;
	}
	
	

}
