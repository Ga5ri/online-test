package goodee.gdj58.online.controller;



import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.service.StudentService;
import goodee.gdj58.online.service.TestService;
import goodee.gdj58.online.vo.Example;
import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StudentController {
	@Autowired StudentService studentService;
	@Autowired TestService testService;
	@Autowired IdService idService;
	
	// 시험 응시(문제,보기 출력)
	@GetMapping("/student/takeQuestion")
	public String questionOne(Model model
								, @RequestParam(value="testNo") int testNo
								, @RequestParam(value="testTitle") String testTitle) {

		List<Question> qList = studentService.qList(testNo);
		List<Example> exList = studentService.exList(testNo);
		
		model.addAttribute("qList", qList);
		model.addAttribute("exList", exList);
		model.addAttribute("testNo", testNo);
		model.addAttribute("testTitle", testTitle);
		log.debug("\u001B[31m"+qList+"<--qList");
		log.debug("\u001B[31m"+exList+"<--exList");
		log.debug("\u001B[31m"+testTitle+"<--testTitle");
		return "student/takeQuestion";
	}
	
	@PostMapping("/student/takeQuestion")
	public String questionOne(Model model, HttpServletRequest request) {
		String[] answer = request.getParameterValues("answer");
		log.debug("\u001B[31m"+answer[0]+"<--exampleIdx");

		return "student/testListByStudent";
	}
	
	// 시험 리스트
	@GetMapping("/student/testListByStudent")
	public String testList(Model model) {

		List<Test> list = testService.getTestList();
		model.addAttribute("list", list);

		return "student/testListByStudent";
	}
	
	// 로그아웃
	@GetMapping("/student/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/employee/login";
	}
}