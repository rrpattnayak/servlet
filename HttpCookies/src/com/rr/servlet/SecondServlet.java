package com.rr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/surl")
public class SecondServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter object
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		//get values submitted by the form2
		String income=req.getParameter("income");
		String tax=req.getParameter("tax");
		
		//read form1/req1 data from cookies
		Cookie ck[]=req.getCookies();
		String pname=null,fname=null,gender=null;
		if(ck!=null) {
			pname=ck[0].getValue();
			fname=ck[1].getValue();
			gender=ck[2].getValue();
		}//if
		
		//use jdbc code to store form1/req1 data and form2/re2 values in db table
		try {
			//register jdbc driver and establish the connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create prepared statement object pointing to sql query
			PreparedStatement ps=con.prepareStatement("insert into tax_tab values(?,?,?,?)");
			//set values to query params
			ps.setString(1, "pname");
			ps.setString(2, "fname");
			ps.setString(3, "income");
			ps.setString(4, "tax");
			
			//execute the query
			int result=ps.executeUpdate();
			if(result==1)
				pw.println("<br>Record is inserted");
			else
				pw.println("<br>Record is not inserted");
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//display both form1/form2 data
		pw.println("form1 data "+pname+"....."+fname+"....."+gender+"<br>");
		pw.println("form1 data "+income+"....."+tax);
		
		//close streams
		pw.close();
	}//doGet

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
