package com.rr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/surl")
public class Servlet2 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter object
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read first form and second form data
		String name=req.getParameter("hname");
		String age=req.getParameter("hage");
		String ms=req.getParameter("hmstatus");
		
		//read second form request2 data
		String f2val1=req.getParameter("st1");
		String f2val2=req.getParameter("st2");
		
		//write form1/re1,form2/req2 values as database table as records
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			PreparedStatement ps=con.prepareStatement("insert into person_tab values(?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, age);
			ps.setString(3, ms);
			ps.setString(4, f2val1);
			ps.setString(5, f2val2);
			
			int result=ps.executeUpdate();
			if(result==1)
				pw.println("<br><i>Record inserted</i><br>");
			else
				pw.println("<br>Record not inserted");
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch
		
		pw.println("<br><b><h2>First Form data is</h2></b>");
		pw.println("<br><b>Name is<b> "+name);
		pw.println("<br><b>Age is<b> "+age);
		pw.println("<br><b>Marital status is<b> "+ms);
		
		pw.println("<br><br><b><h2>Second form data is </h2><b><br>");
		pw.println("<b>Spouce name is<b> "+f2val1+"<br>");
		pw.println("<b>No of children are<b> "+f2val2);		
		pw.close();
	}//doGet
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost
}//class
