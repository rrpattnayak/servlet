package com.rr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		int value=Integer.parseInt(req.getParameter("t1"));
		//cal cube value
		int cube=value*value*value;
		//display
		pw.println("<br>Second servlet : cube value"+cube);
	}//doGet

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost
}//class
