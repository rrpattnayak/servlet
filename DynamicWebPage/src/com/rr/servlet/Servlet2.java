package com.rr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter object
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read first form and second form data+
		pw.println("<br>First Form data is");
		pw.println("<br><b>Name is<b>"+req.getParameter("pname"));
		pw.println("<br><b>Age is<b>"+req.getParameter("page"));
		pw.println("<br><b>Marital status is<b>"+req.getParameter("ms"));
		
		pw.println("<br><br><b>Second form data is <b>"+req.getParameter("st1")+"<br>"+req.getParameter("st2"));
		pw.close();
	}//doGet
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost
}//class
