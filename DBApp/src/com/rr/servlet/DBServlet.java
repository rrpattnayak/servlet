package com.rr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet extends HttpServlet {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	ServletContext sc;
	public void init() {
		try {
			//get access to servlet context object
			sc=getServletContext();
			//read context param values from web.xml
			String s1=sc.getInitParameter("driver");
			//System.out.println(s1);
			String s2=sc.getInitParameter("dburl");
			//System.out.println(s2);
			String s3=sc.getInitParameter("dbuser");
			String s4=sc.getInitParameter("dbpwd");
			
			//create jdbc connection object
			Class.forName(s1);
			con=DriverManager.getConnection(s2,s3,s4);
			//create jdbc prepared statement object
			ps=con.prepareStatement("SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?");
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch
	}//init
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd=null;
		try {
			//read data from form page
			int no=Integer.parseInt(req.getParameter("teno"));
			//get printwriter object
			PrintWriter pw=res.getWriter();
			//set response content type
			res.setContentType("text/html");
			//write jdbc code
			//set value to parameter of query
			ps.setInt(1, no);
			//execute the query
			rs=ps.executeQuery();
			//process the resultset object and  display the emp details
			if(rs.next()) {
				pw.println("<br><b>Emp number is: </b>"+rs.getInt(1));
				pw.println("<br><b>Emp name is: </b>"+rs.getString(2));
				pw.println("<br><b>Emp desg is: </b>"+rs.getString(3));
				pw.println("<br><b>Emp salary is: </b>"+rs.getFloat(4));				
			}//if
			//close resultset object
			rs.close();
			//close stream object
			pw.close();
		}//try
		catch(Exception e) {
			rd=req.getRequestDispatcher("/eurl");
			rd.forward(req, res);
			e.printStackTrace();
		}//catch
	}//doGet
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	public void destroy() {
		//close jdbc objects
		try {
			if(rs!=null)
				rs.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			if(ps!=null) 
				ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			if(con!=null)
				con.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}//destroy
}//class
