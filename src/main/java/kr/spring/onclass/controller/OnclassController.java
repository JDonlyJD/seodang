package kr.spring.onclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
}
