package goodee.gdj58.online.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.service.TestService;
import goodee.gdj58.online.vo.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {
	@Autowired TestService testService;
	@Autowired IdService idService;
	
	// 시험회차별 상세보기
	@GetMapping("/teacher/testOne")
	public String testOne(Model model, @RequestParam(value="testNo") int testNo) {

		List<Test> list = testService.getTestOne(testNo);
		model.addAttribute("list", list);
		model.addAttribute("testNo", testNo);
		log.debug("\u001B[31m"+list+"<--testlist");
		return "teacher/testOne";
	}
	
	// 시험 등록
	@GetMapping("/teacher/addTest")
	public String addTest() {
		return "teacher/addTest";
	}
	
	@PostMapping("/teacher/addTest")
	public String addTest(Test test) {	
		int row = testService.addTest(test);
		if(row == 1) {
			log.debug("등록성공");
		}
		return "redirect:/teacher/testListByTeacher";	// sendRedirect, CM -> C
	}
	
	// 시험 수정
	@GetMapping("/teacher/modifyTest")
	public String modifyTest(Model model, @RequestParam(value="testNo") int testNo) {
		model.addAttribute("testNo", testNo);
		return "teacher/modifyTest";
	}
	@PostMapping("/teacher/modifyTest")
	public String modifyTest(Test test) {	
		int row = testService.modifyTest(test);
		if(row == 1) {
			log.debug("수정성공");
		}
		return "redirect:/teacher/testListByTeacher";	// sendRedirect, CM -> C
	}
	
	// 시험 삭제
	@GetMapping("/teacher/removeTest")
	public String removeTest(@RequestParam("testNo") int testNo) {
		int row = testService.removeTest(testNo);
		if(row == 1) {
			log.debug("삭제성공");
		}
		return "redirect:/teacher/testListByTeacher";
	}
	
	// 시험 리스트
	@GetMapping("/teacher/testListByTeacher")
	public String testList(Model model) {

		List<Test> list = testService.getTestList();
		model.addAttribute("list", list);

		return "teacher/testListByTeacher";
	}
}
