package com.crud;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class display extends ActionSupport implements ServletRequestAware{

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
		try{
			Class.forName("com.mysql.jdbc.Driver");
		    java.sql.Connection con =DriverManager.getConnection(url, user, pass);
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery("select * from details limit "+0+","+7);
		 
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
