package goodee.gdj58.online.controller;

import java.util.List;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
public class EmployeeController {
	@Autowired EmployeeService employeeService;
	@Autowired TeacherService teacherService;
	@Autowired StudentService studentService;
	@Autowired IdService idService;
	
	// 학생 삭제
	@GetMapping("/employee/student/removeStudent")
	public String removeStudent(@RequestParam(value="studentNo") int studentNo) {
		employeeService.removeStudent(studentNo);
		return "redirect:/employee/student/studentList";
	}
	
	// 학생 등록
	@GetMapping("/employee/student/addStudent")
	public String addStudent() {
		return "employee/student/addStudent";
	}
	@PostMapping("/employee/student/addStudent")
	public String addStudent(Model model, Student student) {
		String idCheck = idService.getIdCheck(student.getStudentId());
		if(idCheck != null) {
			model.addAttribute("errorMsg", "중복 ID");
			return "employee/student/addStudent";
		}
		
		int row = employeeService.addStudent(student);
		if(row == 0) {
			model.addAttribute("errorMsg", "시스템 에러로 등록 실패");
			return "student/addStudent";
		}
		return "redirect:/employee/student/studentList";
	}
	
	// 학생 리스트(검색 추가)
	@GetMapping("/employee/student/studentList")
	public String studentList(Model model
							, @RequestParam(value="currentPage", defaultValue="1") int currentPage
							, @RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage
							, @RequestParam(value="searchWord", defaultValue="") String searchWord) {
		int cnt = employeeService.countStudent(searchWord); // student count
		int page = 10; // 페이지 목록
		int startPage = ((currentPage - 1) / page) * page + 1; // 시작 페이지 ex) 1-10 = 1, 11-20 = 11
		int endPage = startPage + page - 1; // 페이지의 마지막 ex) 1-10 = 10, 11-20 = 20
		int lastPage = (int)Math.ceil((double)cnt / (double)rowPerPage); // 마지막 페이지
		if(lastPage < endPage) {
			endPage = lastPage;
		}
		log.debug("\u001B[31m"+cnt+"<--cnt");
		log.debug("\u001B[31m"+rowPerPage+"<--rowPerPage");
		log.debug("\u001B[31m"+page+"<--page");
		log.debug("\u001B[31m"+startPage+"<--startPage");
		log.debug("\u001B[31m"+endPage+"<--endPage");
		log.debug("\u001B[31m"+lastPage+"<--lastPage");
		List<Student> list = employeeService.getStudentList(currentPage, rowPerPage, searchWord);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("cnt", cnt);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("searchWord", searchWord);
		return "employee/student/studentList";
	}
	
	// 강사 삭제
	@GetMapping("/employee/teacher/removeTeacher")
	public String removeTeacher(@RequestParam(value="teacherNo") int teacherNo) {
		employeeService.removeTeacher(teacherNo);
		return "redirect:/employee/teacher/teacherList";
	}
	
	// 강사 등록
	@GetMapping("/employee/teacher/addTeacher")
	public String addTeacher() {
		return "employee/teacher/addTeacher";
	}
	
	@PostMapping("/employee/teacher/addTeacher")
	public String addTeacher(Model model, Teacher teacher) {
		String idCheck = idService.getIdCheck(teacher.getTeacherId());
		if(idCheck != null) {
			model.addAttribute("errorMsg", "중복 ID");
			return "employee/teacher/addTeacher";
		}
		
		int row = employeeService.addTeacher(teacher);
		if(row == 0) {
			model.addAttribute("errorMsg", "시스템 에러로 등록 실패");
			return "employee/teacher/addTeacher";
		}
		return "redirect:/employee/teacher/teacherList";
	}
	
	// 강사 리스트
	@GetMapping("/employee/teacher/teacherList")
	public String teacherList(Model model
							, @RequestParam(value="currentPage", defaultValue="1") int currentPage
							, @RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage
							, @RequestParam(value="searchWord", defaultValue="") String searchWord) {
		int cnt = employeeService.countTeacher(searchWord); // student count
		int page = 10; // 페이지 목록
		int startPage = ((currentPage - 1) / page) * page + 1; // 시작 페이지 ex) 1-10 = 1, 11-20 = 11
		int endPage = startPage + page - 1; // 페이지의 마지막 ex) 1-10 = 10, 11-20 = 20
		int lastPage = (int)Math.ceil((double)cnt / (double)rowPerPage); // 마지막 페이지
		if(lastPage < endPage) {
			endPage = lastPage;
		}
		List<Teacher> list = employeeService.getTeacherList(currentPage, rowPerPage, searchWord);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("cnt", cnt);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("searchWord", searchWord);
		return "employee/teacher/teacherList";
	}

	// 사원 로그아웃
	@GetMapping("/employee/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/employee/login";
	}
	// 로그인 후에 사용가능
	
	// 사원 pw 수정
	@GetMapping("/employee/modifyEmpPw")
	public String modifyEmpPw(HttpSession session) {
		// 로그인 안된 상태라면 로그인 폼으로
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { 
			return "redirect:/employee/login";
		}
		return "employee/modifyEmpPw";
	}
	
	@PostMapping("/employee/modifyEmpPw")
	public String modifyEmpPw(HttpSession session, @RequestParam("oldPw") String oldPw, @RequestParam("newPw") String newPw) {
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		employeeService.updateEmployeePw(loginEmp.getEmpNo(), oldPw, newPw);
		return "redirect:/employee/empList";
	}
	
	// 사원 삭제
	@GetMapping("/employee/removeEmp")
	public String removeEmp(@RequestParam("empNo") int empNo) {
		employeeService.removeEmployee(empNo);
		return "redirect:/employee/empList";
	}
	
	// 사원 등록
	@GetMapping("/employee/addEmp")
	public String addEmp() {
		return "employee/addEmp";
	}
	@PostMapping("/employee/addEmp")
	public String addEmp(Model model, Employee employee) {		
		String idCheck = idService.getIdCheck(employee.getEmpId());
		if(idCheck != null) {
			model.addAttribute("errorMsg", "중복 ID");
			return "employee/addEmp";
		}
		
		int row = employeeService.addEmployee(employee);
		if(row == 0) {
			model.addAttribute("errorMsg", "시스템 에러로 등록 실패");
			return "employee/addEmp";
		}
		return "redirect:/employee/empList";	// sendRedirect, CM -> C
	}
	
	// 사원 리스트(검색 추가)
	@GetMapping("/employee/empList")
	public String empList(Model model
							, @RequestParam(value="currentPage", defaultValue="1") int currentPage
							, @RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage
							, @RequestParam(value="searchWord", defaultValue="") String searchWord) {	
		log.debug("\u001B[31m"+searchWord+"<--searchWord");
		
		int cnt = employeeService.countEmp(searchWord); // employee count
		int page = 10; // 페이지 목록
		int startPage = ((currentPage - 1) / page) * page + 1; // 시작 페이지 ex) 1-10 = 1, 11-20 = 11
		int endPage = startPage + page - 1; // 페이지의 마지막 ex) 1-10 = 10, 11-20 = 20
		int lastPage = (int)Math.ceil((double)cnt / (double)rowPerPage); // 마지막 페이지
		if(lastPage < endPage) {
			endPage = lastPage;
		}
		log.debug("\u001B[31m"+cnt+"<--cnt");
		log.debug("\u001B[31m"+page+"<--page");
		log.debug("\u001B[31m"+startPage+"<--startPage");
		log.debug("\u001B[31m"+endPage+"<--endPage");
		log.debug("\u001B[31m"+lastPage+"<--lastPage");
		List<Employee> list = employeeService.getEmployeeList(currentPage, rowPerPage, searchWord);
		// request.setAttribute("list", list);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("cnt", cnt);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("searchWord", searchWord);
		
		return "employee/empList";
	}
}