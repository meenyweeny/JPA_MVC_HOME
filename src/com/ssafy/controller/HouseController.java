package com.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ssafy.dto.house.HouseInfoDto;
import com.ssafy.service.house.HouseService;
import com.ssafy.service.house.HouseServiceImpl;

public class HouseController {
	HouseService houseService;
	public HouseController() {
		houseService = new HouseServiceImpl();
	}
	
	public void apart(HttpServletRequest request, HttpServletResponse response) {
		long aptNo = Long.parseLong(request.getParameter("artNo"));
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		
		houseService.searchByAptNo(aptNo, year, month);
	}

	public void apartTransaction(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher reqDis = request.getRequestDispatcher("/views/apartTransaction.jsp");
		try {
			reqDis.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dongTransaction(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher reqDis = request.getRequestDispatcher("/views/dongTransaction.jsp");
		try {
			reqDis.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void sido(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(1);
		List<String> sido =  houseService.AllSido();
        Gson gson = new Gson();
        String json = gson.toJson(sido);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
	}

	public void dYear(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<String> dYear =  houseService.AllDYear();
        Gson gson = new Gson();
        String json = gson.toJson(dYear);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
	}

	public void gugun(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sido = request.getParameter("sido");
		List<String> gugun =  houseService.GetGugun(sido);
        Gson gson = new Gson();
        String json = gson.toJson(gugun);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        System.out.println(json);
	}
	
	public void dong(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String gugun = request.getParameter("gugun");
		List<String> dong =  houseService.GetDong(gugun);
        Gson gson = new Gson();
        String json = gson.toJson(dong);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        System.out.println(json);
	}

	public void SearchByDYM(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(1);
		String dong = request.getParameter("dong");
		String year = request.getParameter("dYear");
		String month = request.getParameter("dMonth");
		System.out.println(dong + year + month);
		List<String[]> aptList = houseService.searchByDYM(dong, year, month);
        Gson gson = new Gson();
        String json = gson.toJson(aptList);
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        System.out.println(json);
	}
	
	
	
}
