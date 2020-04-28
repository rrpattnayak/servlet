package com.rr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/furl")
public class Servlet1 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter object
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		//read from1/req1 data
		String name=req.getParameter("pname");
		String age=req.getParameter("page");
		String mstatus=req.getParameter("ms");
		
		
		//get second form dynamically form here
		if(mstatus.equals("married")) {
			pw.println("<form action='surl' method='post'>");
			pw.println("<b> Spouce Name </b><input type='text' name='st1'><br>");
			pw.println("<b> No of Children </b><input type='text' name='st2'><br>");
			//add form1/req1 data to dynamic form page as hidden box values
			pw.println("<input type='hidden' name='hname' value="+name+">");
			pw.println("<input type='hidden' name='hage' value="+age+">");
			pw.println("<input type='hidden' name='hmstatus' value="+mstatus+">");			
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");
		}//if
		else {
			pw.println("<form action='surl' method='post'>");
			pw.println("<b> When you want to marry</b><input type='text' name='st1'><br>");
			pw.println("<b> Why do you want to marry </b><input type='text' name='st2'><br>");
			//add form1/req1 data to dynamic form page as hidden box values
			pw.println("<input type='hidden' name='hname' value="+name+">");
			pw.println("<input type='hidden' name='hage' value="+age+">");
			pw.println("<input type='hidden' name='hmstatus' value="+mstatus+">");			
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");
		}//else
		pw.close();
	}//doGet

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost
}//class
