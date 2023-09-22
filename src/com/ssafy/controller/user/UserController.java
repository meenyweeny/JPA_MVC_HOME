package com.ssafy.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.service.user.UserService;
import com.ssafy.service.user.UserServiceImpl;

public class UserController {
	
	UserService userService;
	
	public UserController() {
		userService = new UserServiceImpl();
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/index.jsp"); // TODO : path
		try {
			dispatcher.forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void loginProcess(HttpServletRequest request, HttpServletResponse response) {
		// id password 받기
		// UserService에 넘기기
		String userId = request.getParameter("userId");
		boolean flag = userService.selectUserByUserId(userId) != null;
		String url = "/JPA_MVC_HOME/index"; // 성공하면 갈 곳
		if(flag) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userId);
		} else {
			url = "/JPA_MVC_HOME/login";
		}
		
		try {
			response.sendRedirect(url);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		String url = "/JPA_MVC_HOME/index"; // 성공하면 갈 곳
		try {
			response.sendRedirect(url);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
