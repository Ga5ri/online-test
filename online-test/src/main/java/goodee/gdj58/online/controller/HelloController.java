package goodee.gdj58.online.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	/*
	// 뷰를 맵핑하는 3가지 방법(@GetMapping, @GetMapping-void타입, ModelAndView 사용)
	@GetMapping("hello")
	public String hello() {
		return "hello";
		// /WEB-INF/view/hello.jsp 포워딩함
	}
	
	@GetMapping("/test")
	public String test() {
		System.out.println("test...");
		return "test";
		// /WEB-INF/view/test.jsp 포워딩함
	}
	
	@RequestMapping(value="/test2", method=RequestMethod.GET)
	public String test2() {
		System.out.println("test2...");
		return "hello";
		// /WEB-INF/view/hello.jsp
	}
	
	@GetMapping("/test")
	public void test() {
		System.out.println("test...");
		// 리턴 타입이 void면 메서드 이름이 뷰가 된다
	}
	*/
	
	@GetMapping("/test")
	public ModelAndView test() {
		System.out.println("ModelAndView test...");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello"); // 뷰이름 설정
		return mv;
	}
	
}
