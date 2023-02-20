package goodee.gdj58.online.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.PaperMapper;
import goodee.gdj58.online.vo.Paper;

@Service
@Transactional
public class PaperService {
	@Autowired PaperMapper paperMapper;
	
	// 시험 채점 결과
	public List<Map<String, Object>> getPaperOne(int testNo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("testNo", testNo);
		
		return paperMapper.paperOne(paramMap);
	}	
	
	// 시험 결과 입력
	public void addPaper(int studentNo, int[] questionNo, int[] answer) {
		
		for(int i=0; i<questionNo.length; i++) {
			Map<String,Object> paper = new HashMap<String,Object>();
			paper.put("studentNo", studentNo);
			paper.put("questionNo", questionNo[i]);
			paper.put("answer", answer[i]);
			
			paperMapper.insertPaper(paper);
		}
	}
}
