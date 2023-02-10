package goodee.gdj58.online.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.TestMapper;
import goodee.gdj58.online.vo.Test;

@Service
@Transactional
public class TestService {
	@Autowired TestMapper testMapper;
	// 시험 등록
	public int addTest(Test test) {
		return testMapper.insertTest(test);
	}
	
	// 시험 수정
	public int modifyTest(Test test) {
		return testMapper.updateTest(test);
	}
	
	// 시험 삭제
	public int removeTest(int testNo) {
		return testMapper.deleteTest(testNo);
	}
	
	// 리스트
	public List<Test> getTestList() {
		Map<String, Object> paramMap = new HashMap<>();
		return testMapper.testList(paramMap);
	}
}
