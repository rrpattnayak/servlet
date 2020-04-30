package com.rr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		int value=Integer.parseInt(req.getParameter("t1"));
		//calc square values
		int square=value*value;
		pw.println("<br>First Servlet Square"+square);
		//include the response of second servlet component
		//get servlet context obj of cuurent application
		ServletContext sc1=getServletContext();
		//get servlet context obj of Watwo web application
		ServletContext sc2=sc1.getContext("/WATwo");
		//get request dispatcher obj pointing to seconnd servlet
		RequestDispatcher rd=sc2.getRequestDispatcher("/s2url");
		rd.include(req, res);
		//close stream
		pw.close();
	}//doGet
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
