package kr.spring.onclass.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.spring.onclass.service.OnclassService;
import kr.spring.onclass.vo.OnclassVO;

@Controller
public class OnclassController {
	@Autowired
	private OnclassService onclassService;
	
	@ModelAttribute
	public OnclassVO initCommand() {
		return new OnclassVO();
	}
	//온라인 클래스 목록
	@GetMapping("/onclass/onclassList.do")
	public String form() {
		return "onclassList";
	}
	
	
	@GetMapping("/onclass/onclassInsert.do")
	public String insertForm() {
		return "onclassInsert";
	}
	
	@PostMapping("/onclass/onclassInsert.do")
	public String insert(OnclassVO onclassVO,HttpSession session) {
		Integer user_num = (Integer)session.getAttribute("user_num");
		onclassVO.setUser_num(user_num);
		onclassService.insertOnclass(onclassVO);
		
		return "onclassList";
	}
}
