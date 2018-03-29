package com.crud;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class delete extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	
	String url = "jdbc:mysql://localhost:3306/struts";
	String user = "root";
	String pass = "root";
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	public HttpServletRequest getServletRequest()
	{
        return request;
	}

	public String execute()
	{
		String sid = request.getParameter("tid");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		    java.sql.Connection con =DriverManager.getConnection(url, user, pass);
		    
		    String s = "delete from details where sno=?";
			PreparedStatement ps=con.prepareStatement(s);
			ps.setInt(1, Integer.parseInt(sid));
			ps.executeUpdate();
			con.commit();
			
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			
		}
		
		System.out.println("id : "+ sid);
		return SUCCESS;
	}
}
