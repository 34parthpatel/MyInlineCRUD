package com.crud;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class insert extends ActionSupport implements ServletRequestAware{

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
	
	public HttpServletRequest getServletRequest() {
        return request;
	}
	
	public String execute()
	{
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String scountry = request.getParameter("scountry");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		    java.sql.Connection con =DriverManager.getConnection(url, user, pass);
		 
			String s = "insert into details values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(s);
			ps.setInt(1, Integer.parseInt(sid));
			ps.setString(2, sname);
			ps.setString(3, scountry);
		 
			ps.executeUpdate();
			con.commit();
		 
			ps.close();
			con.close();
		 
		}
		catch(Exception e){
	 		e.printStackTrace();
	 	}
		
		System.out.println("insert : "+sid+sname+scountry);
		return SUCCESS;
	}

}
