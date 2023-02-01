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
import goodee.gdj58.online.vo.Employee;

@Controller
public class EmployeeController {
	@Autowired 
	EmployeeService employeeService;
	@Autowired IdService idService;
	
	// 로그인
	@GetMapping("/employee/loginEmp")
	public String loginEmp(HttpSession session) {
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp != null) { 
			return "redirect:/employee/empList";
		}
		return "employee/loginEmp";
	}
	@PostMapping("/employee/loginEmp")
	public String loginEmp(HttpSession session, Employee emp) {
		Employee resultEmp = employeeService.login(emp);
		if(resultEmp == null) {	// 로그인 실패
			return "redirect:/employee/loginEmp";
		}
		session.setAttribute("loginEmp", resultEmp);
		return "redirect:/employee/empList";	// sendRedirect, CM -> C
	}
	
	// 로그아웃
	@GetMapping("/employee/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/employee/loginEmp";
	}
	
	// 로그인 후에 사용가능
	
	// pw 수정
	@GetMapping("/employee/modifyEmpPw")
	public String modifyEmpPw(HttpSession session) {
		// 로그인 안된 상태라면 로그인 폼으로
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { 
			return "redirect:/employee/loginEmp";
		}
		return "employee/modifyEmpPw";
	}
	@PostMapping("/employee/modifyEmpPw")
	public String modifyEmpPw(HttpSession session, @RequestParam("oldPw") String oldPw, @RequestParam("newPw") String newPw) {
		// 로그인 안된 상태라면 로그인 폼으로
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { 
			return "redirect:/employee/loginEmp";
		}
		employeeService.updateEmployeePw(loginEmp.getEmpNo(), oldPw, newPw);
		return "redirect:/employee/loginEmp";
	}
	
	// 삭제
	@GetMapping("/employee/removeEmp")
	public String removeEmp(HttpSession session, @RequestParam("empNo") int empNo) {
		// 로그인 안된 상태라면 로그인 폼으로
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { 
			return "redirect:/employee/loginEmp";
		}
		employeeService.removeEmployee(empNo);
		return "redirect:/employee/empList";
	}
	
	// 등록
	@GetMapping("/employee/addEmp")
	public String addEmp(HttpSession session) {
		// 로그인 안된 상태라면 로그인 폼으로
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { 
			return "redirect:/employee/loginEmp";
		}
		return "employee/addEmp";
	}
	@PostMapping("/employee/addEmp")
	public String addEmp(HttpSession session, Model model, Employee employee) {
		// 로그인 안된 상태라면 로그인 폼으로
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { 
			return "redirect:/employee/loginEmp";
		}
		
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
	
	// 리스트
	@GetMapping("/employee/empList")
	public String empList(HttpSession session, Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage) {					
		// 로그인 안된 상태라면 로그인 폼으로
		Employee loginEmp = (Employee)session.getAttribute("loginEmp");
		if(loginEmp == null) { 
			return "redirect:/employee/loginEmp";
		}
		List<Employee> list = employeeService.getEmployeeList(currentPage, rowPerPage);
		// request.setAttribute("list", list);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		return "employee/empList";
	}
}