package goodee.gdj58.online.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import goodee.gdj58.online.service.EmployeeService;
import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.service.StudentService;
import goodee.gdj58.online.service.TeacherService;
import goodee.gdj58.online.vo.Employee;
import goodee.gdj58.online.vo.Student;
import goodee.gdj58.online.vo.Teacher;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	@Autowired EmployeeService employeeService;
	@Autowired TeacherService teacherService;
	@Autowired StudentService studentService;
	@Autowired IdService idService;
	
	// 로그인
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String loginTeacher(HttpSession session, Employee emp, Teacher teacher, Student student) {
		Employee resultEmp = employeeService.login(emp);
		Teacher resultTeacher = teacherService.login(teacher);
		Student resultStudent = studentService.login(student);
		if(resultEmp != null) {
			session.setAttribute("loginEmp", resultEmp);
			log.debug("\u001B[31m"+resultEmp+"<--loginEmp");
			return "redirect:/employee/empList";
		} else if(resultTeacher != null) {
			session.setAttribute("loginTeacher", resultTeacher);
			log.debug("\u001B[31m"+resultTeacher+"<--loginTeacher");
			return "redirect:/teacher/test/testListByTeacher";
		} else if(resultStudent != null) {
			session.setAttribute("loginStudent", resultStudent);
			log.debug("\u001B[31m"+resultStudent+"<--loginStudent");
			return "redirect:/student/testListByStudent";
		}
		return "redirect:/student/studentList";	// sendRedirect, CM -> C
	}
}
