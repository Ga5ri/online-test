package goodee.gdj58.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.ExampleService;
import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.vo.Question;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExampleController {
	@Autowired ExampleService exampleService;
	@Autowired IdService idService;
	
	// 시험문제별 상세보기
	@GetMapping("/teacher/exampleOne")
	public String exampleOne(Model model
								, @RequestParam("questionNo") int questionNo
								, @RequestParam("questionTitle") String questionTitle) {

		List<Question> list = exampleService.getExampleOne(questionNo, questionTitle);
		model.addAttribute("list", list);
		model.addAttribute("questionNo", questionNo);
		model.addAttribute("questionTitle", questionTitle);
		log.debug("\u001B[31m"+list+"<--questionlist");
		log.debug("\u001B[31m"+questionNo+"<--questionNo");
		return "teacher/exampleOne";
	}
}
