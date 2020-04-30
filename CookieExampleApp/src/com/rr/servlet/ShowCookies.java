package com.rr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test2")
public class ShowCookies extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter object
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String title="active cookies";
		pw.println("<table border=1 align='center'>");
		pw.println("<tr><td>Cookie Name</td>");
		pw.println("<td>Cookie Value</td></tr>");
		
		Cookie[] ck=req.getCookies();
		if(ck!=null) {
			for(Cookie cks:ck) {
				pw.println("<tr><td>"+cks.getName()+"</td>"+"<td>"+cks.getValue()+"</td></tr>");
			}//for
			pw.println("</table>");
		}//if
		else {
			System.out.println("NO cookies present");
			pw.println("<br><b>no cookies present</b>");
		}//esle
	}//doGet
}//class
