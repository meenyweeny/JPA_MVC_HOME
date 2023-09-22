package com.ssafy.controller;

import java.io.Console;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class FrontController extends HttpServlet {
    
	HouseController hcon;
	
    public FrontController() {
    	hcon = new HouseController();
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
    	System.out.println(request.getContextPath());
    	request.setCharacterEncoding("utf-8");
    	String reqString = request.getServletPath();
    	if (reqString.equals("/apart")) {
    		hcon.apart(request, response);
    	} else if (reqString.equals("/apartTransaction")) {
    		hcon.apartTransaction(request, response);
    	} else if (reqString.equals("/dong")) {
    		hcon.apartTransaction(request, response);
    	} else if (reqString.equals("/dongTransaction")) {
    		hcon.dongTransaction(request, response);
    	} else if (reqString.equals("/")) {
    		hcon.apartTransaction(request, response);
    	} else if (reqString.equals("/")) {
    		hcon.apartTransaction(request, response);
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
