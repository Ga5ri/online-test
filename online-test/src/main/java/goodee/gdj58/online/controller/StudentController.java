package goodee.gdj58.online.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.service.StudentService;
import goodee.gdj58.online.vo.Employee;
import goodee.gdj58.online.vo.Student;

@Controller
public class StudentController {
	@Autowired StudentService studentService;
	@Autowired IdService idService;
	
	// 삭제
	@GetMapping("/student/removeStudent")
	public String removeStudent(HttpSession session, int studentNo) {
		// 로그인 안된 상태라면 로그인 폼으로
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { 
			return "redirect:/employee/loginEmp";
		}
		studentService.removeStudent(studentNo);
		return "redirect:/student/studentList";
	}
	
	// 등록
	@GetMapping("/student/addStudent")
	public String addStudent(HttpSession session) {
		// 로그인 안된 상태라면 로그인 폼으로
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { 
			return "redirect:/employee/loginEmp";
		}
		return "student/addStudent";
	}
	@PostMapping("/student/addStudent")
	public String addStudent(HttpSession session, Model model, Student student) {
		// 로그인 안된 상태라면 로그인 폼으로
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { 
			return "redirect:/employee/loginEmp";
		}

		String idCheck = idService.getIdCheck(student.getStudentId());
		if(idCheck != null) {
			model.addAttribute("errorMsg", "중복 ID");
			return "student/addStudent";
		}
		
		int row = studentService.addStudent(student);
		if(row == 0) {
			model.addAttribute("errorMsg", "시스템 에러로 등록 실패");
			return "student/addStudent";
		}
		return "redirect:/student/studentList";
	}
	
	// 리스트
	@GetMapping("/student/studentList")
	public String studentList(HttpSession session, Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage) {
		// 로그인 안된 상태라면 로그인 폼으로
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { 
			return "redirect:/employee/loginEmp";
		}
		List<Student> list = studentService.getStudentList(currentPage, rowPerPage);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		return "student/studentList";
	}
}