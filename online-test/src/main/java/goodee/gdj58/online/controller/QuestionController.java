package goodee.gdj58.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.service.QuestionService;
import goodee.gdj58.online.service.TestService;
import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class QuestionController {
	@Autowired QuestionService questionService;
	@Autowired TestService testService;
	@Autowired IdService idService;
	
	// 시험 등록
	@GetMapping("/teacher/addQuestion")
	public String addQuestion(Model model, @RequestParam(value="testNo") int testNo) {
		List<Test> list = testService.getTestList();
		model.addAttribute("list", list);
		model.addAttribute("testNo", testNo);
		log.debug("\u001B[31m"+testNo+"<--testNoByQuestion");
		return "teacher/addQuestion";
	}
	
	@PostMapping("/teacher/addQuestion")
	public String addQuestion(Question question, @RequestParam(value="testNo") int testNo) {	
		int row = questionService.addQuestion(question, testNo);
		if(row == 1) {
			log.debug("등록성공");
		}
		return "redirect:/teacher/testOne?testNo="+testNo;	// sendRedirect, CM -> C
	}
}
