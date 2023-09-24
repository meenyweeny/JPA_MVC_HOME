package com.ssafy.controller;

import java.io.Console;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.mvc")
public class FrontController extends HttpServlet {
	HouseController hcon;
    public FrontController() {
    	hcon = new HouseController();
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	System.out.println(request.getContextPath());
    	request.setCharacterEncoding("utf-8");
    	String reqString = request.getServletPath();
    	System.out.println(reqString);
    	if (reqString.equals("/apart.mvc")) {
    		hcon.apart(request, response);
    	} else if (reqString.equals("/apartTransaction.mvc")) {
    		hcon.apartTransaction(request, response);
    	} else if (reqString.equals("/dongTransaction.mvc")) {
    		hcon.dongTransaction(request, response);
    	} else if (reqString.equals("/sido.mvc")) {
    		hcon.sido(request, response);
    	} else if (reqString.equals("/dYear.mvc")) {
    		hcon.dYear(request, response);
    	} else if (reqString.equals("/gugun.mvc")) {
    		hcon.gugun(request, response);
    	} else if (reqString.equals("/dong.mvc")) {
    		hcon.dong(request, response);
    	} else if (reqString.equals("/searchDeal.mvc")) {
    		hcon.SearchByDYM(request, response);
    	} 
    	
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
