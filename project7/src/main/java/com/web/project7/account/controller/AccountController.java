package com.web.project7.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
		
		// service 생성
		AccountService service = new AccountService();
		
		// service에 가입 요청(데이터는 DTO에 담아서 잔달)
		AccountDTO dto = new AccountDTO();
		dto.setUsername(account.getUsername());
		dto.setPassword(account.getPassword()[0]);
		dto.setEmail(account.getEmail());
		
		
		// 처리 결과에 따라서 다음의 로직 수행
		boolean result = false;
		
		if(result) {
			// 성공: 메인 페이지 또는 로그인 페이지로 리다이렉트
			return "redirect:/account/login";
		} else {
			// 실패: 다시 회원가입 페이지 양식 전달(기존에 입력한값으로 초기화하여 전달)
			return "account/join";
		}
	}
	
	
}