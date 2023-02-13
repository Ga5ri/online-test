package goodee.gdj58.online.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.ExampleMapper;
import goodee.gdj58.online.vo.Example;
@Service
@Transactional
public class ExampleService {
	@Autowired ExampleMapper exampleMapper;
	// 보기 추가
	public int addExample(Example example) {
		return exampleMapper.addExample(example);
	}
	
	// 보기 수정
	public int modifyExample(Example example) {
		return exampleMapper.updateExample(example);
	}
	public Example exList(int exampleNo) {
		return exampleMapper.exList(exampleNo);
	}
	
	// 보기 삭제
	public int deleteQuestion(int exampleNo) {
		return exampleMapper.deleteExample(exampleNo);
	}
	// 시험회차별 보기 상세보기
	public List<Example> getExampleOne(int questionNo) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("questionNo", questionNo);
		return exampleMapper.questionOne(paramMap);
	}
	
}
