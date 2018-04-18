package wcmc.schoolcard.service.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wcmc.schoolcard.dao.WebborrowtimesMapper;
import wcmc.schoolcard.dao.WebcanteenMapper;
import wcmc.schoolcard.dao.WebgradeMapper;
import wcmc.schoolcard.dao.WebxsMapper;
import wcmc.schoolcard.dto.Webborrowtimes;
import wcmc.schoolcard.dto.Webcanteen;
import wcmc.schoolcard.dto.Webgrade;
import wcmc.schoolcard.dto.Webxs;
import wcmc.schoolcard.service.WebxsService;

@Service
public class WebxsServiceImpl implements WebxsService{
	
	@Autowired
	private WebxsMapper webxsMapper;
	@Autowired
	private WebcanteenMapper webcanteenMapper;
	@Autowired
	private WebgradeMapper webgradeMapper;
	@Autowired
	private WebborrowtimesMapper webborrowtimesMapper;

	@Override
	public int deleteByPrimaryKey(String xh) {
		// TODO Auto-generated method stub
		return webxsMapper.deleteByPrimaryKey(xh);
	}

	@Override
	public int insert(Webxs record) {
		// TODO Auto-generated method stub
		return webxsMapper.insert(record);
	}

	@Override
	public int insertSelective(Webxs record) {
		// TODO Auto-generated method stub
		return webxsMapper.insertSelective(record);
	}

	@Override
	public Webxs selectByPrimaryKey(String xh) {
		// TODO Auto-generated method stub
		return webxsMapper.selectByPrimaryKey(xh);
	}

	@Override
	public int updateByPrimaryKeySelective(Webxs record) {
		// TODO Auto-generated method stub
		return webxsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Webxs record) {
		// TODO Auto-generated method stub
		return webxsMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Webxs> selectAllUser() {
		// TODO Auto-generated method stub
		return webxsMapper.selectAllUser();
	}

	@Override
	public List<String> getPersonalInfo(String xh) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<String>();
		Webxs webxs = webxsMapper.selectByPrimaryKey(xh);
		String id = webxs.getXsId();
		float year = (float) (2016 - Integer.parseInt(webxs.getSznj()) + 0.5);
		if (year > 4) {
			year = 4;
		}
		//餐均消费
		BigDecimal averageCanteen;
		BigDecimal frequentCanteen;
		Webcanteen webcanteen = webcanteenMapper.getWebcanteenByXH(xh);
		if (webcanteen == null) {
			averageCanteen = new BigDecimal(0);
			frequentCanteen = new BigDecimal(0);
		} else {
			averageCanteen = webcanteen.getCanteenSum().multiply(new BigDecimal(-1)).divide(webcanteen.getCanteenTimes(), 2, BigDecimal.ROUND_HALF_UP);
			//餐饮频次
			frequentCanteen = webcanteen.getCanteenTimes().divide(new BigDecimal(year), 2, BigDecimal.ROUND_HALF_UP);
		}
		//平均成绩及挂科频次, m用于表示挂科频次
		List<Webgrade> grades = webgradeMapper.getGradeById(id);
		double averageGrade = 0;
		int m = 0;
		if (grades.size() > 0) {
			double total = 0;
			int n = 0;
			m = 0;
			for (Webgrade grade : grades) {
				String fs = grade.getFslkxcj();
				if (fs == null || fs.trim().equals("")) {
					m += 1;
				}
				try {
					double score = Double.parseDouble(fs);
					if (score < 60) {
						m += 1;
					}
					total += score;
					n += 1;
				} catch (Exception e) {
					// TODO: handle exception
					if (fs.equals("不合格") || fs.equals("不通过") || fs.equals("不及格")) {
						m += 1;
					}
				}
			}
			averageGrade = total / n;
		}
		//借书频次
		BigDecimal frequentBorrow = new BigDecimal(0);
		if (webborrowtimesMapper.getWebborrowtimesByXH(xh) != null) {
			frequentBorrow = webborrowtimesMapper.getWebborrowtimesByXH(xh).getBorrowTimes().divide(new BigDecimal(year), 2, BigDecimal.ROUND_HALF_UP);
		}
		result.add(averageCanteen.toString());
		result.add(frequentCanteen.toString());
		result.add(averageGrade+"");
		result.add(m+"");
		result.add(frequentBorrow.toString());
		
		return result;
	}


}
