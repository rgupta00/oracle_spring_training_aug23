package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	public HelloServlet() {
		System.out.println("it is the ctr of servlet");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init is called");
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget method");
		PrintWriter out=response.getWriter();
		out.print("hello to servlet"+ LocalDateTime.now().toString());
	}


	@Override
	public void destroy() {
	
		System.out.println("Destroy method is called");
	}



}














