package goodee.gdj58.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.ExampleService;
import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.vo.Example;
import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExampleController {
	@Autowired ExampleService exampleService;
	@Autowired IdService idService;
	// 보기 등록
	@GetMapping("/teacher/example/addExample")
	public String addExample(Model model
								, @RequestParam("questionNo") int questionNo) {
		model.addAttribute("questionNo", questionNo);
		return "teacher/example/addExample";
	}
	@PostMapping("/teacher/example/addExample")
	public String addExample(Example example
							, @RequestParam("questionNo") int questionNo) {	
		int row = exampleService.addExample(example);
		if(row == 1) {
			log.debug("등록성공");
		}
		return "redirect:/teacher/example/exampleOne?questionNo="+questionNo;	// sendRedirect, CM -> C
	}
	// 시험문제별 상세보기
	@GetMapping("/teacher/example/exampleOne")
	public String exampleOne(Model model
								, @RequestParam("questionNo") int questionNo) {

		List<Question> list = exampleService.getExampleOne(questionNo);
		model.addAttribute("list", list);
		model.addAttribute("questionNo", questionNo);
		log.debug("\u001B[31m"+list+"<--examplelist");
		log.debug("\u001B[31m"+questionNo+"<--questionNo");
		return "teacher/example/exampleOne";
	}
}
