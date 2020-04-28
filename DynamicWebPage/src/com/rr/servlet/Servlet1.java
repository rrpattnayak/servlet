package com.rr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s1url")
public class Servlet1 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//read from1/req1 data
		String name=req.getParameter("pname");
		String age=req.getParameter("page");
		String mstatus=req.getParameter("ms");
		if(mstatus==null) {
			mstatus="single";
		}//if
		//get printwriter object
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		//get second form dynamically form here
		if(mstatus.equals("married")) {
			pw.println("<form action='s1url' method='post'>");
			pw.println("<b> Spouce Name </b><input type='text' name='st1'><br>");
			pw.println("<b> No of Children </b><input type='text' name='st2'><br>");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");
		}//if
		else {
			pw.println("<form action='s2url' method='post'>");
			pw.println("<b> When you want to marry</b><input type='text' name='st1'><br>");
			pw.println("<b> Why do you want to marry </b><input type='text' name='st2'><br>");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");
		}//else
		pw.close();
	}//doGet

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost
}//class
