package com.rr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("error servlet do get");
		//general setting
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//display error page
		pw.println("<br><h1><center>Internal DB problem</center></h1>");
		pw.println("<a href='input.html'>try again</a>");
		pw.close();
	}//doGet
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
