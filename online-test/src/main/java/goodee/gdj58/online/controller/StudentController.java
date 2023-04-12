package goodee.gdj58.online.controller;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.service.PaperService;
import goodee.gdj58.online.service.ScoreService;
import goodee.gdj58.online.service.StudentService;
import goodee.gdj58.online.service.TestService;
import goodee.gdj58.online.vo.Example;
import goodee.gdj58.online.vo.Paper;
import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Score;
import goodee.gdj58.online.vo.Student;
import goodee.gdj58.online.vo.Teacher;
import goodee.gdj58.online.vo.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StudentController {
	@Autowired StudentService studentService;
	@Autowired TestService testService;
	@Autowired PaperService paperService;
	@Autowired ScoreService scoreService;
	@Autowired IdService idService;
	
	// 시험 응시(문제,보기 출력)
	@GetMapping("/student/takeQuestion")
	public String questionOne(Model model
								, @RequestParam(value="testNo") int testNo
								, @RequestParam(value="testTitle") String testTitle
								, @RequestParam(value="studentNo") int studentNo) {
		
		List<Question> qList = studentService.qList(testNo);
		List<Example> exList = studentService.exList(testNo);
		
		model.addAttribute("qList", qList);
		model.addAttribute("exList", exList);
		model.addAttribute("testNo", testNo);
		model.addAttribute("testTitle", testTitle);
		model.addAttribute("studentNo", studentNo);
		log.debug("\u001B[31m"+qList+"<--qList");
		log.debug("\u001B[31m"+exList+"<--exList");
		log.debug("\u001B[31m"+testTitle+"<--testTitle");
		log.debug("\u001B[31m"+studentNo+"<--studentNo");
		return "student/takeQuestion";
	}
	
	@PostMapping("/student/addPaper")
	public String addPaper(Model model
							, @RequestParam(value="testNo") int testNo
							, @RequestParam(value="studentNo") int studentNo
							, @RequestParam(value="questionNo") int[] questionNo
							, @RequestParam(value="answer") int[] answer) {

	
		log.debug(studentNo+" <-studentNo");
		log.debug(questionNo[0]+" <-questionNo");
		log.debug(answer[0]+" <-answer");	
		
		// 시험지 입력
		paperService.addPaper(studentNo, questionNo, answer);
		
		// 시험 점수 계산
		double sdScore = paperService.getPaperScore(testNo, studentNo);
		
		Score score = new Score();
		score.setTestNo(testNo);
		score.setStudentNo(studentNo);
		score.setScore(sdScore);
		
		// 시험 점수 입력
		scoreService.addScore(score);
		
		log.debug("\u001B[31m"+score+"<--testScore");
		return "redirect:/student/testListByStudent";
		}
	
	// 학생 pw 수정
	@GetMapping("/student/modifyStudentPw")
	public String modifyStudentPw(HttpSession session) {
		// 로그인 안된 상태라면 로그인 폼으로
		Student loginStudent = (Student)session.getAttribute("loginStudent");
		if(loginStudent == null) { 
			return "redirect:/employee/login";
		}
		return "student/modifyStudentPw";
	}
	
	@PostMapping("/student/modifyStudentPw")
	public String modifyStudentPw(HttpSession session, @RequestParam("oldPw") String oldPw, @RequestParam("newPw") String newPw) {
		Student loginStudent = (Student)session.getAttribute("loginStudent");
		studentService.updateStudentPw(loginStudent.getStudentNo(), oldPw, newPw);
		log.debug("\u001B[31m"+oldPw+"<--oldPw");
		log.debug("\u001B[31m"+newPw+"<--newPw");
		return "redirect:/student/testListByStudent";
	}
	
	// 시험 리스트
	@GetMapping("/student/testListByStudent")
	public String testList(Model model, HttpSession session) {
		Student loginStudent = (Student)session.getAttribute("loginStudent");
		if(loginStudent == null) { 
			return "redirect:/employee/login";
		}
		String studentName = loginStudent.getStudentName();
		
		List<Map<String,Object>> list = studentService.getTestList(loginStudent.getStudentNo());
		log.debug("\u001B[31m"+list+"<--list");
		
		model.addAttribute("list", list);
		model.addAttribute("studentName", studentName);
		return "student/testListByStudent";
	}
	
	// 로그아웃
	@GetMapping("/student/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/employee/login";
	}
}