package kr.spring.user.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.spring.user.service.UserService;
import kr.spring.user.vo.UserVO;
import kr.spring.util.AuthBlockException;
import kr.spring.util.AuthCheckException;

@Controller
public class UserController {
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@ModelAttribute
	public UserVO initCommand() {
		return new UserVO();
	}

	//회원 등록 폼 호출 
	@GetMapping("/user/registerUser.do")
	public String form() {
		return "userRegister";
	}

	//회원등록 처리
	@PostMapping("/user/registerUser.do")
	public String submit(@Valid UserVO userVO,BindingResult result) {

		logger.info("<<회원 가입>> :"+userVO);

		if(result.hasErrors()) {
			return form();
		}

		userService.insertUser(userVO);

		return "redirect:/main/main.do";
	}
	//로그인 폼 
	@GetMapping("/user/login.do")
	public String formLogin() {
		return "userLogin";
	}
	//로그인 폼에서 전송된 데이터 처리
	@PostMapping("/user/login.do")
	public String submitLogin(@Valid UserVO userVO,BindingResult result,HttpSession session) {

		logger.info("<<회원 로그인>> : "+userVO);

		//id와 password 필드만 체크 
		if(result.hasFieldErrors("id")|| result.hasFieldErrors("passwd")) {
			return formLogin();
		}

		//로그인 체크(id,비밀번호 일치 여부 체크)
		try {
			UserVO user = userService.selectCheckUser(userVO.getId());

			boolean check  =false;
			if(user!=null) {
				//비밀번호 일치 여부 체크				//사용자가 입력한 비밀번호
				check = user.isCheckedPassword(userVO.getPasswd());
			}
			if(user.getAuth()==0) { //정지회원의 경우
				throw new Exception();
			}else if(user.getAuth()==1) {
				throw new AuthBlockException();
			}else {
				if(check) {
					//인증 성공, 로그인 처리
					session.setAttribute("user_num", user.getUser_num());
					session.setAttribute("user_name", user.getName());
					session.setAttribute("user_auth", user.getAuth());
					session.setAttribute("user_photo", user.getPhoto());

					return "redirect:/main/main.do";
				}
			}

			throw new AuthCheckException();
		}catch(AuthBlockException e) {
			result.reject("blockAccount");

			return formLogin();
		}catch(AuthCheckException e) {
			//인증 실패로 로그인 폼을 호출
			result.reject("invalidIdOrPassword");
			//인증 실패로 로그인 폼 호출 
			return formLogin();
		}catch(Exception e) {
			result.reject("WithdrawlAccount");
			
			return formLogin();
		}
	}
	//회원 로그아웃 
	@RequestMapping("/user/logout.do")
	public String processLogout(HttpSession session) {
		
		//로그아웃
		session.invalidate();
		
		return "redirect:/main/main.do";
	}
	
	//마이페이지
	@RequestMapping("/user/myPage.do")
	public String process(HttpSession session, Model model) {
		
		Integer user_num = (Integer)session.getAttribute("user_num");
		UserVO user = userService.selectUser(user_num);
		
		logger.info("<<회원 상세 정보>> : " + user);
		
		model.addAttribute("user",user);
		
		return "userView";
	}
	
	//수정폼
	@GetMapping("/user/update.do")
	public String formUpdate(HttpSession session, Model model) {
		Integer user_num = (Integer)session.getAttribute("user_num");
		
		UserVO userVO = userService.selectUser(user_num);
		
		model.addAttribute("userVO", userVO);
		
		return "userModify";
	}
	//수정폼에서 전송된 데이터 처리
	@PostMapping("/user/user.do")
	public String submitUpdate(@Valid UserVO userVO,
								BindingResult result,
								HttpSession session) {
		logger.info("<<회원 정보 수정>> : " + userVO);
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "userModify";
		}
		
		Integer user_num = (Integer)session.getAttribute("user_num");
		userVO.setUser_num(user_num);
		
		//회원정보수정
		userService.updateUser(userVO);
		
		return "redirect:/user/myPage.do";
	}
}
