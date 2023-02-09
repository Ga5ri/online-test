package goodee.gdj58.online.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.TestMapper;
import goodee.gdj58.online.vo.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class TestService {
	@Autowired TestMapper testMapper;
	// 시험회차별 상세보기
	public List<Test> getTestOne(int testNo, String testTitle) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("testNo", testNo);
		paramMap.put("testTitle", testTitle);
		log.debug("\u001B[31m"+testTitle+"<--testTitleService");
		return testMapper.testOne(paramMap);
	}
	
	// 시험 등록
	public int addTest(Test test) {
		return testMapper.insertTest(test);
	}
	
	// 리스트
	public List<Test> getTestList() {
		Map<String, Object> paramMap = new HashMap<>();
		return testMapper.testList(paramMap);
	}
}
