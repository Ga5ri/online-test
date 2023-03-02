package goodee.gdj58.online.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.controller.PaperController;
import goodee.gdj58.online.mapper.PaperMapper;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@Transactional
public class PaperService {
	@Autowired PaperMapper paperMapper;
	@Autowired QuestionService questionService;
	// 시험 채점 결과 - 점수 출력
	public double getPaperScore(int testNo, int studentNo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("testNo", testNo);
		paramMap.put("studentNo", studentNo);
		
		int perfectScore = 100;
		int cntQuestion = questionService.countQuestion(testNo);
		double quePerScore = perfectScore/cntQuestion;		
		
		double sdScore = 0;
		List<Map<String, Object>> list = paperMapper.paperScore(paramMap);
		for(Map<String, Object> m : list) {
			String exampleOx = (String)m.get("exampleOx");
			if(exampleOx.equals("정답")) {
				sdScore = sdScore + quePerScore;
			} 
		}
		log.debug("\u001B[31m"+sdScore+"<--studentScore");
		return sdScore;
	}
	
	// 시험 채점 결과 - 답안 출력
	public List<Map<String, Object>> getPaperOne(int testNo) {
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
