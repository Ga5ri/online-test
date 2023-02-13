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
import goodee.gdj58.online.vo.Question;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class QuestionController {
	@Autowired QuestionService questionService;
	@Autowired IdService idService;
	
	// 시험 문제 추가
	@GetMapping("/teacher/question/addQuestion")
	public String addQuestion(Model model, @RequestParam(value="testNo") int testNo) {		
		model.addAttribute("testNo", testNo);
		log.debug("\u001B[31m"+testNo+"<--testNoByQuestion");
		return "teacher/question/addQuestion";
	}
	
	@PostMapping("/teacher/question/addQuestion")
	public String addQuestion(Question question, @RequestParam(value="testNo") int testNo) {	
		questionService.addQuestion(question);
	
		return "redirect:/teacher/question/questionOne?testNo="+testNo;	// sendRedirect, CM -> C
	}
	
	// 문제 수정
	@GetMapping("/teacher/question/modifyQuestion")
	public String modifyQuestion(Model model
									, @RequestParam(value="questionTitle") String questionTitle
									, @RequestParam(value="questionNo") int questionNo
									, @RequestParam(value="testNo") int testNo) {
		model.addAttribute("questionTitle", questionTitle);
		model.addAttribute("questionNo", questionNo);
		model.addAttribute("testNo", testNo);
		log.debug("\u001B[31m"+questionTitle+"<--questionTitleByQuestion");
		return "teacher/question/modifyQuestion";
	}
	@PostMapping("/teacher/question/modifyQuestion")
	public String modifyQuestion(@RequestParam(value="questionNo") int questionNo
									, @RequestParam(value="testNo") int testNo
									, @RequestParam(value="questionTitle") String questionTitle) {	
		int row =questionService.modifyQuestion(questionNo, questionTitle);
		if(row == 1) {
			log.debug("수정 성공");
		}
		return "redirect:/teacher/question/questionOne?testNo="+testNo;	// sendRedirect, CM -> C
	}
	
	// 문제 삭제
	@GetMapping("/teacher/question/removeQuestion")
	public String removeTest(@RequestParam(value="questionNo") int questionNo
								, @RequestParam(value="testNo") int testNo) {
		int row = questionService.deleteQuestion(questionNo);
		if(row == 1) {
			log.debug("삭제성공");
		}
		return "redirect:/teacher/question/questionOne?testNo="+testNo;
	}
	// 시험회차별 상세보기
	@GetMapping("/teacher/question/questionOne")
	public String questionOne(Model model, @RequestParam(value="testNo") int testNo) {

		List<Question> list = questionService.getQuestionOne(testNo);
		model.addAttribute("list", list);
		model.addAttribute("testNo", testNo);
		log.debug("\u001B[31m"+list+"<--testlist");
		return "teacher/question/questionOne";
	}
	
}
