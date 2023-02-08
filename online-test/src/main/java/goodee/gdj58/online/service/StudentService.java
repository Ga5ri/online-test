package goodee.gdj58.online.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.StudentMapper;
import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Student;
import goodee.gdj58.online.vo.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class StudentService {
	@Autowired StudentMapper studentMapper;
	// 시험회차별 상세보기
	public List<Student> getQuestionOne(int questionNo, String questionTitle) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("questionNo", questionNo);
		paramMap.put("questionTitle", questionTitle);
		log.debug("\u001B[31m"+questionNo+"<--questionNoService");
		return studentMapper.selectQuestionByStudent(paramMap);
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
