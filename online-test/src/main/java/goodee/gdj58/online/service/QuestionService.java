package goodee.gdj58.online.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.QuestionMapper;
import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Test;


@Service
@Transactional
public class QuestionService {
	@Autowired QuestionMapper questionMapper;
	
	// 시험 문항 수 카운트
	public int countQuestion(int testNo) {
		return questionMapper.countQuestion(testNo);
	}
	
	// 시험 문제 추가
	public int addQuestion(Question question) {
		return questionMapper.insertQuestion(question);
	}
	
	// 문제 수정
	public int modifyQuestion(int questionNo, String questionTitle) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("questionNo", questionNo);
		paramMap.put("questionTitle", questionTitle);
		
		return questionMapper.updateQuestion(paramMap);
	}
	
	// 문제 삭제
	public int deleteQuestion(int questionNo) {
		return questionMapper.deleteQuestion(questionNo);
	}
	
	// 시험회차별 상세보기
	public List<Question> getQuestionOne(int testNo) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("testNo", testNo);
		return questionMapper.questionOne(paramMap);
	}
}
