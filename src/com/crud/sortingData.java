package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class sortingData extends ActionSupport implements ServletRequestAware,SessionAware{

	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	private SessionMap<String, Object> session;
	Connection con;
	Statement st;
	ResultSet rs;
	static int i=0, j=0, k=0;
	
	String url = "jdbc:mysql://localhost:3306/struts";
	String user = "root";
	String pass = "root";
	
	public sortingData() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection(url, user, pass);
			st=con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("const sorting data : " + e);
			e.printStackTrace();
		}
	}
	

	@Override
	public void setSession(Map<java.lang.String, java.lang.Object> session1) {
		// TODO Auto-generated method stub
		System.out.println("in session.");
		session1.put("sort", "sno");
		this.session = (SessionMap<String, Object>) session1;
	}
	
	public Map<String, Object> getSession()
	{
		return session;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	public HttpServletRequest getServletRequest() {
        return request;
	}
	
	public String Name()
	{
		System.out.println("sort name." + i);
		session.put("sort", "sname");
		i++;
		String query;
		if(i%2!=0)
		{
			query = "select * from details order by sname limit "+0+","+7;
			session.put("value", "odd");
		}
		else
		{
			query = "select * from details order by sname desc limit "+0+","+7;
			session.put("value", "even");
		}
		try{
			
			rs = st.executeQuery(query);
		 
		    	List li = null;
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
		 
				request.setAttribute("disp", li);
		 
				rs.close();
		 		st.close();
				con.close();
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String RollNo()
	{
		System.out.println("sort rollno." + j);
		session.put("sort", "sno");
		j++;
		String query;
		if(j%2!=0)
		{
			query = "select * from details order by sno limit "+0+","+7;
			session.put("value", "odd");
		}
		else
		{
			query = "select * from details order by sno desc limit "+0+","+7;
			session.put("value", "even");
		}
		try{
			
			rs = st.executeQuery(query);
		 
		    	List li = null;
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
		 
				request.setAttribute("disp", li);
		 
				rs.close();
		 		st.close();
				con.close();
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String Country()
	{
		System.out.println("sort country." + k);
		session.put("sort", "scountry");
		k++;
		String query;
		if(k%2!=0)
		{
			query = "select * from details order by scountry limit "+0+","+7;
			session.put("value", "odd");
		}
		else
		{
			query = "select * from details order by scountry desc limit "+0+","+7;
			session.put("value", "even");
		}
		try{
			
			rs = st.executeQuery(query);
		 
		    	List li = null;
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
		 
				request.setAttribute("disp", li);
		 
				rs.close();
		 		st.close();
				con.close();
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
