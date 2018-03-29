package com.crud;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

public class pageValue implements ServletRequestAware{

	HttpServletRequest request;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	public HttpServletRequest getServletRequest() {
        return request;
	}
	
	public String getPage()
	{
		String page = request.getParameter("val");
		System.out.println(page);
		return "success";
	}
}
