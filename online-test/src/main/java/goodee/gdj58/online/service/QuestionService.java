package goodee.gdj58.online.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.QuestionMapper;
import goodee.gdj58.online.vo.Question;


@Service
@Transactional
public class QuestionService {
	@Autowired QuestionMapper questionMapper;
	// 시험 문제 추가
	public int addQuestion(Question question) {
		return questionMapper.insertQuestion(question);
	}
}