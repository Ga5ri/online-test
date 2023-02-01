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
import goodee.gdj58.online.service.TeacherService;
import goodee.gdj58.online.vo.Employee;
import goodee.gdj58.online.vo.Teacher;

@Controller
public class TeacherController {
	@Autowired TeacherService teacherService;
	@Autowired IdService idService;
	
	// 삭제
	@GetMapping("/teacher/removeTeacher")
	public String removeTeacher(HttpSession session, int teacherNo) {
		// 로그인 안된 상태라면 로그인 폼으로
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { 
			return "redirect:/employee/loginEmp";
		}
		teacherService.removeTeacher(teacherNo);
		return "redirect:/teacher/teacherList";
	}
	
	// 등록
	@GetMapping("/teacher/addTeacher")
	public String addTeacher(HttpSession session) {
		// 로그인 안된 상태라면 로그인 폼으로
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { 
			return "redirect:/employee/loginEmp";
		}
		return "teacher/addTeacher";
	}
	
	@PostMapping("/teacher/addTeacher")
	public String addTeacher(HttpSession session, Model model, Teacher teacher) {
		// 로그인 안된 상태라면 로그인 폼으로
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { 
			return "redirect:/employee/loginEmp";
		}
		
		String idCheck = idService.getIdCheck(teacher.getTeacherId());
		if(idCheck != null) {
			model.addAttribute("errorMsg", "중복 ID");
			return "teacher/addTeacher";
		}
		
		int row = teacherService.addTeacher(teacher);
		if(row == 0) {
			model.addAttribute("errorMsg", "시스템 에러로 등록 실패");
			return "teacher/addTeacher";
		}
		return "redirect:/teacher/teacherList";
	}
	
	// 리스트
	@GetMapping("/teacher/teacherList")
	public String teacherList(HttpSession session, Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage) {
		// 로그인 안된 상태라면 로그인 폼으로
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { 
			return "redirect:/employee/loginEmp";
		}
		List<Teacher> list = teacherService.getTeacherList(currentPage, rowPerPage);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		return "teacher/teacherList";
	}
}