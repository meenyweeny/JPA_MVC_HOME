package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.service.house.HouseService;
import com.ssafy.service.house.HouseServiceImpl;

public class HouseController {
	HouseService houseService;
	public HouseController() {
		houseService = new HouseServiceImpl();
	}
	
	public void apart(HttpServletRequest request, HttpServletResponse response) {
		String aptNo = request.getParameter("artNo");
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

	
}
