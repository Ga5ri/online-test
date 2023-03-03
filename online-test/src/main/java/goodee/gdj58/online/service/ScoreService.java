package goodee.gdj58.online.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.ScoreMapper;
import goodee.gdj58.online.vo.Score;

@Service
@Transactional
public class ScoreService {
	@Autowired ScoreMapper scoreMapper;
	// 점수 출력
	public List<Score> getScore(int testNo, int studentNo) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("testNo", testNo);
		paramMap.put("studentNo", studentNo);
		return scoreMapper.selectScore(paramMap);
	}
	
	// 등록
	public int addScore(Score score) {
		return scoreMapper.insertScore(score);
	}
}
