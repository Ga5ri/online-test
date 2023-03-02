package goodee.gdj58.online.controller;

import java.util.List;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.PaperService;
import goodee.gdj58.online.service.ScoreService;
import goodee.gdj58.online.service.StudentService;
import goodee.gdj58.online.vo.Example;
import goodee.gdj58.online.vo.Score;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PaperController {
	@Autowired StudentService studentService;
	@Autowired PaperService paperService;
	@Autowired ScoreService scoreService;
	
	@GetMapping("/student/paperOne")
	public String questionOne(Model model
								, @RequestParam(value="testNo") int testNo
								, @RequestParam(value="testTitle") String testTitle
								, @RequestParam("studentNo") int studentNo) {
		
		List<Map<String, Object>> scoreQuestionList = studentService.scoreQuestionList(testNo, studentNo);
		List<Example> exList = studentService.exList(testNo);
		List<Score> scoreList = scoreService.getScore(testNo, studentNo);
		
		
		model.addAttribute("scoreQuestionList", scoreQuestionList);
		model.addAttribute("exList", exList);
		model.addAttribute("testNo", testNo);
		model.addAttribute("testTitle", testTitle);
		model.addAttribute("studentNo", studentNo);
		model.addAttribute("scoreList", scoreList);
		
		log.debug("\u001B[31m"+scoreQuestionList+"<--scoreQuestionList");
		log.debug("\u001B[31m"+exList+"<--exList");
		return "student/paperOne";
	}
	
}
