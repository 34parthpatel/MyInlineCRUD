package com.crud;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

import com.opensymphony.xwork2.ActionSupport;

public class displayTag extends ActionSupport implements ServletRequestAware, PaginatedList{

	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	
	private int fullListSize;
	private int objectsPerPage;
	private int pageNumber;
	private String searchId;
	private String sortCriterion;
	private SortOrderEnum sortDirection;
	private List list;
	
	int start = 0;
	int page = 0;
	String temp = "7";
	
	public String getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = "7";
	}

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
		getData(start, getObjectsPerPage());
		return SUCCESS;
	}

	public String dis()
	{
		String sortField = request.getParameter((new ParamEncoder("table1").
			    encodeParameterName(TableTagParameters.PARAMETER_SORT)));
			 
			String sortOrder = request.getParameter((new ParamEncoder("table1").
			    encodeParameterName(TableTagParameters.PARAMETER_ORDER)));
		
		System.out.println("sortfield : "+sortField);
		System.out.println("sortorder : "+sortOrder);
		
		
		page = Integer.parseInt(request.getParameter((new ParamEncoder("table1").encodeParameterName(TableTagParameters.PARAMETER_PAGE))));
		System.out.println("page : "+ page);
		if(page != 0)
		{
			start = (page - 1) * getObjectsPerPage();
		}
		System.out.println("start : "+ start);
		
		getData(start, getObjectsPerPage());
		
		return SUCCESS;
	}
	
	void getData(int start, int total)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		    java.sql.Connection con =DriverManager.getConnection(url, user, pass);
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery("select * from details limit "+start+","+total);
			int count = 0;
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
			    count++;
			}
			setFullListSize(count);
			request.setAttribute("list1", li);
	 
			rs.close();
	 		st.close();
			con.close();
	 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
			
	@Override
	public int getFullListSize() {
		// TODO Auto-generated method stub
		return fullListSize;
	}

	@Override
	public List getList() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public int getObjectsPerPage() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getPageNumber() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getSearchId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSortCriterion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortOrderEnum getSortDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFullListSize(int fullListSize) {
		this.fullListSize = fullListSize;
	}

	public void setObjectsPerPage(int objectsPerPage) {
		this.objectsPerPage = 10;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public void setSortCriterion(String sortCriterion) {
		this.sortCriterion = sortCriterion;
	}

	public void setSortDirection(SortOrderEnum sortDirection) {
		this.sortDirection = sortDirection;
	}

	public void setList(List list) {
		this.list = list;
	}


}
