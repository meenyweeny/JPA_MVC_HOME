package com.ssafy.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//FrontController : client로 부터 들어오는 요청을 받고, 받은 요청을 구분해서 controller 에게 넘김
//http://localhost:8080/mvc/list : 모든 데이터 요청 (글 목록 화면)
//http://localhost:8080/mvc/read?num=111 : 111 데이터 요청 (글 상세 화면)
@WebServlet("/")
public class UserFrontController extends HttpServlet {

	UserController con;
	
	public UserFrontController() {
		con = new UserController();
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String reqString = request.getServletPath();
		
		if(reqString.equals("/login")) {
			con.login(request, response);
		} else if(reqString.equals("/loginProcess")) {
			con.loginProcess(request, response);
		} else if(reqString.equals("/logout")) {
			con.logout(request, response);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
}
