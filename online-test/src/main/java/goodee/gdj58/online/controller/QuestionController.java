package goodee.gdj58.online.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.service.QuestionService;
import goodee.gdj58.online.vo.Question;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class QuestionController {
	@Autowired QuestionService questionService;
	@Autowired IdService idService;
	
	// 시험 문제 추가
	@GetMapping("/teacher/addQuestion")
	public String addQuestion(Model model, @RequestParam(value="testNo") int testNo) {		
		model.addAttribute("testNo", testNo);
		log.debug("\u001B[31m"+testNo+"<--testNoByQuestion");
		return "teacher/addQuestion";
	}
	
	@PostMapping("/teacher/addQuestion")
	public String addQuestion(Question question, @RequestParam(value="testNo") int testNo) {	
		questionService.addQuestion(question);
	
		return "redirect:/teacher/testOne?testNo="+testNo;	// sendRedirect, CM -> C
	}
}
