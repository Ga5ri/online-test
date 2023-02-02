package goodee.gdj58.online.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.service.TeacherService;
import goodee.gdj58.online.vo.Teacher;

@Controller
public class TeacherController {
	@Autowired TeacherService teacherService;
	@Autowired IdService idService;
	
	// 삭제
	@GetMapping("/employee/teacher/removeTeacher")
	public String removeTeacher(int teacherNo) {
		teacherService.removeTeacher(teacherNo);
		return "redirect:/employee/teacher/teacherList";
	}
	
	// 등록
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
		
		int row = teacherService.addTeacher(teacher);
		if(row == 0) {
			model.addAttribute("errorMsg", "시스템 에러로 등록 실패");
			return "employee/teacher/addTeacher";
		}
		return "redirect:/employee/teacher/teacherList";
	}
	
	// 리스트
	@GetMapping("/employee/teacher/teacherList")
	public String teacherList(Model model
							, @RequestParam(value="currentPage", defaultValue="1") int currentPage
							, @RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage
							, @RequestParam(value="searchWord", defaultValue="") String searchWord) {
		int cnt = teacherService.countTeacher(searchWord); // student count
		int page = 10; // 페이지 목록
		int startPage = ((currentPage - 1) / page) * page + 1; // 시작 페이지 ex) 1-10 = 1, 11-20 = 11
		int endPage = startPage + page - 1; // 페이지의 마지막 ex) 1-10 = 10, 11-20 = 20
		int lastPage = (int)Math.ceil((double)cnt / (double)rowPerPage); // 마지막 페이지
		if(lastPage < endPage) {
			endPage = lastPage;
		}
		List<Teacher> list = teacherService.getTeacherList(currentPage, rowPerPage, searchWord);
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
}