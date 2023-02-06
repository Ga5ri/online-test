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
import goodee.gdj58.online.vo.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StudentController {
	@Autowired StudentService studentService;
	@Autowired IdService idService;
	
	// 로그아웃
	@GetMapping("/student/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/employee/login";
	}
	// 학생 리스트(검색 추가)
	@GetMapping("/student/studentList")
	public String studentList(Model model
							, @RequestParam(value="currentPage", defaultValue="1") int currentPage
							, @RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage
							, @RequestParam(value="searchWord", defaultValue="") String searchWord) {
		int cnt = studentService.countSd(searchWord); // student count
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
		List<Student> list = studentService.getStudList(currentPage, rowPerPage, searchWord);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("cnt", cnt);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("searchWord", searchWord);
		return "student/studentList";
	}
}