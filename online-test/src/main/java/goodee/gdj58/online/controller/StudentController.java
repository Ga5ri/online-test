package goodee.gdj58.online.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.service.StudentService;
import goodee.gdj58.online.vo.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StudentController {
	@Autowired StudentService studentService;
	@Autowired IdService idService;
	
	// 삭제
	@GetMapping("/employee/student/removeStudent")
	public String removeStudent(int studentNo) {
		studentService.removeStudent(studentNo);
		return "redirect:/employee/student/studentList";
	}
	
	// 등록
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
		
		int row = studentService.addStudent(student);
		if(row == 0) {
			model.addAttribute("errorMsg", "시스템 에러로 등록 실패");
			return "student/addStudent";
		}
		return "redirect:/employee/student/studentList";
	}
	
	// 리스트(검색 추가)
	@GetMapping("/employee/student/studentList")
	public String studentList(Model model
							, @RequestParam(value="currentPage", defaultValue="1") int currentPage
							, @RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage
							, @RequestParam(value="searchWord", defaultValue="") String searchWord) {
		int cnt = studentService.countStudent(searchWord); // student count
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
		List<Student> list = studentService.getStudentList(currentPage, rowPerPage, searchWord);
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
}