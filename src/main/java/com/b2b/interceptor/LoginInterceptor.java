package com.b2b.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private static final Logger Logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		HttpSession session = request.getSession();

		ModelMap modelMap = modelAndView.getModelMap();
		Object startUpUserVO = modelMap.get("startUpUserVO");
		Object buyerUserVO = modelMap.get("buyerUserVO");
		
		// UserController 에서 Model 객체에 담긴 UserVO 확인
		if (startUpUserVO != null) {

			// Session 객체에 UserVO 정보 담기
			Logger.info("new startUpUserVO login success");
			session.setAttribute(LOGIN, startUpUserVO);

			// 로그인 전 보고 있었던 화면(url) 확인
			Object dest = session.getAttribute("dest");

			// 로그인 전 보고 있었던 화면(url)으로 이동
			response.sendRedirect(dest != null ? (String) dest : "/startup/list"); // 조건 ? true : false

		}
		
		if (buyerUserVO != null) {

			// Session 객체에 UserVO 정보 담기
			Logger.info("new buyerUserVO login success");
			session.setAttribute(LOGIN, buyerUserVO);

			// 로그인 전 보고 있었던 화면(url) 확인
			Object dest = session.getAttribute("dest");

			// 로그인 전 보고 있었던 화면(url)으로 이동
			response.sendRedirect(dest != null ? (String) dest : "/buyer/adminList"); // 조건 ? true : false

		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// postHandle() 메서드 실행 전처리
		HttpSession session = request.getSession();

		if (session.getAttribute(LOGIN) != null) {
			Logger.info("clear login data before");
			session.removeAttribute(LOGIN);
		}

		return true;

	}

}
