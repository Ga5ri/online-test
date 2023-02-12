package goodee.gdj58.online.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.ExampleMapper;
import goodee.gdj58.online.vo.Example;
import goodee.gdj58.online.vo.Question;
@Service
@Transactional
public class ExampleService {
	@Autowired ExampleMapper exampleMapper;
	// 보기 추가
	public int addExample(Example example) {
		return exampleMapper.addExample(example);
	}
	// 시험회차별 보기 상세보기
	public List<Question> getExampleOne(int questionNo) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("questionNo", questionNo);
		return exampleMapper.questionOne(paramMap);
	}
	
}
