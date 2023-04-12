package goodee.gdj58.online.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.service.TestService;
import goodee.gdj58.online.vo.Employee;
import goodee.gdj58.online.vo.Teacher;
import goodee.gdj58.online.vo.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {
	@Autowired TestService testService;
	@Autowired IdService idService;
	
	// 시험 등록
	@GetMapping("/teacher/test/addTest")
	public String addTest() {
		return "teacher/test/addTest";
	}
	
	@PostMapping("/teacher/test/addTest")
	public String addTest(Test test) {	
		int row = testService.addTest(test);
		if(row == 1) {
			log.debug("등록성공");
		}
		return "redirect:/teacher/test/testListByTeacher";	// sendRedirect, CM -> C
	}
	
	// 시험 수정
	@GetMapping("/teacher/test/modifyTest")
	public String modifyTest(Model model, Test test
								, @RequestParam(value="testNo") int testNo) {
		String testTitle = test.getTestTitle();
		log.debug("testTitle->"+testTitle);
		model.addAttribute("testNo", testNo);
		model.addAttribute("testTitle", testTitle);
		return "teacher/test/modifyTest";
	}
	@PostMapping("/teacher/test/modifyTest")
	public String modifyTest(Test test) {	
		int row = testService.modifyTest(test);
		if(row == 1) {
			log.debug("수정성공");
		}
		return "redirect:/teacher/test/testListByTeacher";	// sendRedirect, CM -> C
	}
	
	// 시험 삭제
	@GetMapping("/teacher/removeTest")
	public String removeTest(@RequestParam("testNo") int testNo) {
		int row = testService.removeTest(testNo);
		if(row == 1) {
			log.debug("삭제성공");
		}
		return "redirect:/teacher/test/testListByTeacher";
	}
	
	// 시험 리스트
	@GetMapping("/teacher/test/testListByTeacher")
	public String testList(Model model, HttpSession session) {
		Teacher loginTeacher = (Teacher)session.getAttribute("loginTeacher");
		if(loginTeacher == null) {
			return "redirect:/employee/login";
		}
		
		String teacherName = loginTeacher.getTeacherName();
		
		List<Test> list = testService.getTestList();
		
		model.addAttribute("list", list);
		model.addAttribute("teacherName", teacherName);
		return "teacher/test/testListByTeacher";
	}
}
