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
import goodee.gdj58.online.vo.Student;
import goodee.gdj58.online.vo.Teacher;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class TeacherController {
	@Autowired TeacherService teacherService;
	@Autowired IdService idService;	

	// 강사 pw 수정
	@GetMapping("/teacher/modifyTeacherPw")
	public String modifyTeacherPw(HttpSession session) {
		// 로그인 안된 상태라면 로그인 폼으로
		Teacher loginTeacher = (Teacher)session.getAttribute("loginTeacher");
		if(loginTeacher == null) { 
			return "redirect:/employee/login";
		}
		return "teacher/modifyTeacherPw";
	}
	
	@PostMapping("/teacher/modifyTeacherPw")
	public String modifyTeacherPw(HttpSession session, @RequestParam("oldPw") String oldPw, @RequestParam("newPw") String newPw) {
		Teacher loginTeacher = (Teacher)session.getAttribute("loginTeacher");
		teacherService.updateTeacherPw(loginTeacher.getTeacherNo(), oldPw, newPw);
		log.debug("\u001B[31m"+oldPw+"<--oldPw");
		log.debug("\u001B[31m"+newPw+"<--newPw");
		return "redirect:/teacher/test/testListByTeacher";
	}
	
	// 로그아웃
	@GetMapping("/teacher/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/employee/login";
	}
}