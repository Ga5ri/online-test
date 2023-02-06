package goodee.gdj58.online.service;

import java.util.HashMap;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.controller.TeacherController;
import goodee.gdj58.online.mapper.TeacherMapper;
import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Student;
import goodee.gdj58.online.vo.Teacher;
import goodee.gdj58.online.vo.Test;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@Transactional
public class TeacherService {
	@Autowired TeacherMapper teacherMapper;
	
	// 시험회차별 상세보기
	public List<Question> getQuestionOne(int questionNo, String questionTitle) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("questionNo", questionNo);
		paramMap.put("questionTitle", questionTitle);
		log.debug("\u001B[31m"+questionNo+"<--questionNoService");
		return teacherMapper.questionOne(paramMap);
	}
		
		
	// 시험회차별 상세보기
	public List<Test> getTestOne(int testNo, String testTitle) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("testNo", testNo);
		paramMap.put("testTitle", testTitle);
		log.debug("\u001B[31m"+testTitle+"<--testTitleService");
		return teacherMapper.testOne(paramMap);
	}
	
	// 시험 등록
	public int addTest(Test test) {
		return teacherMapper.insertTest(test);
	}
	
	// 리스트
	public List<Test> getTestList() {
		Map<String, Object> paramMap = new HashMap<>();
		return teacherMapper.testList(paramMap);
	}
	
	// 카운트
	public int countSd(String searchWord) {
		return teacherMapper.countSd(searchWord);
	}
	
	// 강사 수정
	public int updateTeacherPw(int teacherNo, String oldPw, String newPw) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("teacherNo", teacherNo);
		paramMap.put("oldPw", oldPw);
		paramMap.put("newPw", newPw);
		return teacherMapper.updateTeacherPw(paramMap);
	}
	
	// 로그인
	public Teacher login(Teacher teacher) {
		return teacherMapper.loginTc(teacher);
	}
	
	// 리스트
	public List<Student> getStudentList(int currentPage, int rowPerPage, String searchWord) {
		int beginRow = (currentPage - 1) * rowPerPage;
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		paramMap.put("searchWord", searchWord);
		return teacherMapper.selectSdList(paramMap);
	}
}