package com.rr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		PrintWriter pw=null;
		String name=null,tage=null,vstatus=null;
		int age=0;
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data from the form components of form page
		name=req.getParameter("pname");
		tage=req.getParameter("page");
		
		vstatus=req.getParameter("vflag");//get client side validation status
		if(vstatus.equals("no")) {//if client side validations are not done
			//server form validation logic
			if(name.equals("")||name==null||name.length()==0) {//required rule
				pw.println("<font color=red> person name is mandatory</font>");
				return;
			}
			if(tage.equals("")||tage==null||tage.length()==0) {//required rule
				pw.println("<font color=red> person age is mandatory</font>");
				return;
			}
			else {//to check whether age is numeric value or not
				try {
					age=Integer.parseInt(tage);
				}
				catch(NumberFormatException ne) {
					pw.println("<font color=red>age must be numeric value</font>");
					return;
				}
			}//else
			System.out.println("server side validation completed");
		}//if
		else {//when client side validations are done
			age=Integer.parseInt(tage);
		}
		//write request processing logic
		if(age>=18)
			pw.println("<h1><font color='green'>"+name+" you are eligible to vote</font></h1>");
		else
			pw.println("<h1><font color='red'>"+name+" you are not eligible to vote</font></h1>");
		//close stream
		pw.close();
	}//doget
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("voter servlet:doPost()");
		super.doGet(req, res);
	}

}
