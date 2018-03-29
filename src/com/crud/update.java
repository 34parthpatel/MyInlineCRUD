package com.crud;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class update extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	
	String url = "jdbc:mysql://localhost:3306/struts";
	String user = "root";
	String pass = "root";
	
	public String execute()
	{
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String scountry = request.getParameter("scountry");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		    java.sql.Connection con =DriverManager.getConnection(url, user, pass);
		    
		    String s = "update details set sname=?,scountry=? where sno=?";
			PreparedStatement ps=con.prepareStatement(s);
			ps.setString(1, sname);
			ps.setString(2, scountry);
			ps.setInt(3, Integer.parseInt(sid));
		 
			ps.executeUpdate();
			con.commit();
		 
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			
		}
		
		System.out.println("in update. : " + sid + sname + scountry);
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		
	}
	
	public HttpServletRequest getServletRequest() {
        return request;
	}
		
}
