package com.crud;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class addField extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	
	public String execute()
	{
		System.out.println("hi.");
		String txt[] = request.getParameterValues("name");
		for(int i=0;i<txt.length;i++)
		{
			System.out.println(txt[i]);
		}
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	public HttpServletRequest getServletRequest()
	{
		return request;
	}
}
