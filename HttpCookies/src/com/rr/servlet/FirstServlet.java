package com.rr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/furl")
public class FirstServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter object
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		//get values from form1
		String s1=req.getParameter("pname");
		String s2=req.getParameter("fname");
		String s3=req.getParameter("gender");
		
		//create cookies to store the form1 data
		Cookie ck1=new Cookie("pname",s1);
		Cookie ck2=new Cookie("fname",s2);
		Cookie ck3=new Cookie("gender", s3);
		
		res.addCookie(ck1);
		res.addCookie(ck2);
		res.addCookie(ck3);
		
		//generate the second form dynamically from here
		pw.println("<form action='surl' method='post'>");
		pw.println("income for this year<input type='text' name='income'><br>");
		pw.println("Tax<input type='text' name='tax'><br><br><br>");
		pw.println("<input type='submit' value='submit'>");
		pw.println("</form>");
		
		//close streams
		pw.close();
		}//doGet
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
