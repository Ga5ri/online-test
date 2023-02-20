package goodee.gdj58.online.service;



import java.util.HashMap;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.StudentMapper;
import goodee.gdj58.online.vo.Example;
import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class StudentService {
	@Autowired StudentMapper studentMapper;
	
	// 점수 확인용 시험지출력(문제번호, 문제명)
	public List<Map<String, Object>> scoreQuestionList(int testNo, int studentNo) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("testNo", testNo);
		paramMap.put("studentNo", studentNo);
		return studentMapper.scoreQuestionList(paramMap);
	}
	
	
	// 시험지출력(보기번호,보기)
	public List<Example> exList(int testNo) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("testNo", testNo);
		
		return studentMapper.exList(testNo);
	}
	
	// 시험지출력(문제번호, 문제명)
	public List<Question> qList(int testNo) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("testNo", testNo);
		log.debug("testNo-->"+testNo);
		return studentMapper.qList(paramMap);
	}
	
	// 리스트
	public List<Student> getStudList(int currentPage, int rowPerPage, String searchWord) {
		int beginRow = (currentPage - 1) * rowPerPage;
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		paramMap.put("searchWord", searchWord);
		return studentMapper.selectStudList(paramMap);
	}
	
	// 카운트
	public int countSd(String searchWord) {
		return studentMapper.countSd(searchWord);
	}
	// 로그인
	public Student login(Student student) {
		return studentMapper.loginSd(student);
	}

}
