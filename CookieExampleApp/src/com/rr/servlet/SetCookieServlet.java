package com.rr.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1")
public class SetCookieServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie cookie1,cookie2,cookie3,cookie4;
		
		//get printwriter object
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//2 in memory cookies applied only to current browsing session
		cookie1=new Cookie("Radhe", "nuagaon");
		cookie2=new Cookie("sawdhin","munudla");
		res.addCookie(cookie1);
		res.addCookie(cookie2);
		
		//2 persistent cookies
		cookie3=new Cookie("narayana", "burujhuri");
		cookie4=new Cookie("subu", "kodala");
		cookie3.setMaxAge(60);
		cookie4.setMaxAge(60);
		res.addCookie(cookie3);
		res.addCookie(cookie4);
		pw.println("<br>Successful in setting cookies");
	}
}
