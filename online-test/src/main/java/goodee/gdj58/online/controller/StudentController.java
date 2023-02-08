package goodee.gdj58.online.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.service.StudentService;
import goodee.gdj58.online.service.TeacherService;
import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Student;
import goodee.gdj58.online.vo.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StudentController {
	@Autowired StudentService studentService;
	@Autowired TeacherService teacherService;
	@Autowired IdService idService;
	// 시험문제별 상세보기
	@GetMapping("/student/takeQuestion")
	public String questionOne(Model model, int questionNo, String questionTitle) {

		List<Student> list = studentService.getQuestionOne(questionNo, questionTitle);
		model.addAttribute("list", list);
		model.addAttribute("questionNo", questionNo);
		model.addAttribute("questionTitle", questionTitle);
		log.debug("\u001B[31m"+list+"<--questionlist");
		log.debug("\u001B[31m"+questionNo+"<--questionNo");
		return "student/takeQuestion";
	}
	// 시험 리스트
	@GetMapping("/student/testListByStudent")
	public String testList(Model model) {

		List<Test> list = teacherService.getTestList();
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