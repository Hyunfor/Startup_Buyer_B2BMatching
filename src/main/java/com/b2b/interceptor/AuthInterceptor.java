package com.b2b.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	private static final Logger Logger = LoggerFactory.getLogger(AuthInterceptor.class);

	private void saveDest(HttpServletRequest request) {

		String uri = request.getRequestURI();
		String query = request.getQueryString();

		if (query == null || query.equals("null")) {
			query = "";
		}else {
			query = "?" + query;
		}

		if (request.getMethod().equals("GET")) {
			Logger.info("dest: " + (uri + query));
			
			request.getSession().setAttribute("dest", uri + query);	
			
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();

		if (session.getAttribute("login") == null) {
			Logger.info("current user is not logined");

			// ���� ȭ��(URL) session ��ü ����
			saveDest(request);

			response.sendRedirect("home");
			return false;

		}

		return true;

	}

}
