package com.crud;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

public class pagination extends HttpServlet implements ServletResponseAware,ServletRequestAware{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request; 
	}

	public HttpServletRequest getServletRequest() {
        return request;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	
	public HttpServletResponse getServletResponse()
	{
		return response;
	}
	
	HttpServletRequest request;
	HttpServletResponse response;

	String sorting;
	String value;
	
	public String execute()
	{
		HttpSession session=ServletActionContext.getRequest().getSession(false);
		System.out.println(session);
		sorting = session.getAttribute("sort").toString();
		value = session.getAttribute("value").toString();
		
		String pageid = request.getParameter("page");
		System.out.println("page : " + pageid + sorting);
		
		int page = Integer.parseInt(pageid);
		int total = 7;
		if(page == 1){}
		else
		{
			page = page - 1;
			page = page * total +1;
		}
		List<bean> disp = getRecords(page, total);
		request.setAttribute("disp", disp);
		return "success";
	}
	
	List<bean> getRecords(int page, int total)
	{
		String query = null;
		List li = null;
		if(value.equals("odd"))
		{	query = "select * from details order by '"+sorting+"' limit "+(page-1)+","+total;	}
		else
		{	query = "select * from details order by '"+sorting+"' desc limit "+(page-1)+","+total;	}
		try
		{
			String url = "jdbc:mysql://localhost:3306/struts";
			String user = "root";
			String pass = "root";
			Class.forName("com.mysql.jdbc.Driver");
		    java.sql.Connection con =DriverManager.getConnection(url, user, pass);
		    PreparedStatement ps=con.prepareStatement(query);  
		    ResultSet rs=ps.executeQuery();
			
		    li = new ArrayList();
	    	bean mb = null;
		    
		    while(rs.next())
			{
			    mb = new bean();
 
			    mb.setNo(rs.getInt("sno"));
			    mb.setNam(rs.getString("sname"));
			    mb.setCt(rs.getString("scountry"));		  
 
			    li.add(mb);
 
			}
		    System.out.println("exedcuted");
		}
		catch(Exception e)
		{
			System.out.println("get records : " + e);
		}
		return li;
	}


}
