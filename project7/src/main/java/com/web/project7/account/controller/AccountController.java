package com.web.project7.account.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.project7.account.entity.AccountVO;
import com.web.project7.account.model.AccountDTO;
import com.web.project7.account.model.AccountService;

@Controller
@RequestMapping(value="/account")
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	AccountService service;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		/*
		 * GET 요청 주소 http://localhost/account/join 에 대해 동작한다.
		 */
		logger.info("회원가입 페이지를 요청하였습니다.");
		return "account/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(AccountVO account) {
		
//		사용자가 전달한 파라미터 값을 추출하기 위한 방법
//		1. HttpservletRequest 객체의 .getParameter("파라미터명") 을 사용
//			public String join(HttpServletRequest request) {
//				String username = request.getParameter("username");
//			}
//		2. @RequestParam("파라미터밍") 어노테이션 사용
//			public String join(@RequestParma("username") String username) {
//				System.out.println("username: "+ username);
//			}
//		3. 커맨드(Command) 객체 사용
//			public String join(AccountVO account) {
//				System.out.println("username: "+ account.username);
//			}
		logger.info("회원가입 정보를 받았습니다. {} / {} / {} / {}", 
				account.getUsername(), 
				account.getPassword()[0], account.getPassword()[1], 
				account.getEmail());
		
	
		// service에 가입 요청(데이터는 DTO에 담아서 잔달)
		AccountDTO dto = new AccountDTO();
		dto.setUsername(account.getUsername());
		dto.setPassword(account.getPassword()[0]);
		dto.setEmail(account.getEmail());
		
		
		// 처리 결과에 따라서 다음의 로직 수행
		boolean result = service.join(dto);

		// 처리 결과에 따라서 다음의 로직 수행
				if(result) {
					// 성공: 메인 페이지 또는 로그인 페이지로 리다이렉트
					return "redirect:/account/login";
				} else {
					// 실패: 다시 회원가입 페이지 양식 전달(기존에 입력한 값으로 초기화하여 전달)
					return "account/join";
				}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "account/login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String username, String password, HttpSession session, HttpServletRequest request, HttpServletResponse response) {

		Cookie[] cookies = request.getCookies();
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals("cookie_name")) {
				cookie.getValue();
			}
		}
		
		response.addCookie(new Cookie("cookie_name", "cookie_value"));
		
		AccountDTO dto = new AccountDTO();
		dto.setUsername(username);
		dto.setPassword(password);

		boolean result = service.login(dto);

		if(result) {
			session.setAttribute("logined", true);
			session.setAttribute("account", dto);
		} else {
			session.setAttribute("logined", false);
		}

		return "redirect:/";
	}
	
}