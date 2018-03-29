<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:directive.page import="com.crud.displayTag" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<center>
		<display:table name="list1" sort="external" size="20" pagesize="5" id="table1" export="true" requestURI="disTag" partialList="true">
			<display:column property="no" group="1" sortable="true" headerClass="sortable"></display:column>
			<display:column property="nam" group="2" sortable="true" headerClass="sortable"></display:column>
			<display:column property="ct" group="3" sortable="true" headerClass="sortable" autolink="true"></display:column>
			
			<s:url id="editUrl" action="editRecord">
				<s:param name="no" value="%{#attr.table1.no}" />
			</s:url>
			<display:column title="Edit">
				<s:a href="%{editUrl}">EDIT</s:a>
			</display:column>
			
			<display:setProperty name="export.excel.filename" value="diplayTag.xls"></display:setProperty>
			<display:setProperty name="export.pdf.filename" value="diplayTag.pdf"></display:setProperty>
			<display:setProperty name="export.csv.filename" value="diplayTag.csv"></display:setProperty>
			<display:setProperty name="export.pdf" value="true"></display:setProperty>
		</display:table>
		temp : ${com.crud.displayTag.temp}
	</center>
</body>
</html>


<%-- <display:table name="list1" sort="list" size="${list1.fullListSize}" pagesize="${list1.objectsPerPage }" id="table1" export="true" requestURI=""> --%>


<%-- <display:table name="list1" sort="list" size="5" pagesize="5" id="table1" export="true" requestURI="" partialList="true">
	<display:column property="no" group="1" sortable="true" headerClass="sortable"></display:column>
	<display:column property="nam" group="2" sortable="true" headerClass="sortable"></display:column>
	<display:column property="ct" group="3" sortable="true" headerClass="sortable" autolink="true"></display:column>
	
	<s:url id="editUrl" action="editRecord">
		<s:param name="no" value="%{#attr.table1.no}" />
	</s:url>
	<display:column title="Edit">
		<s:a href="%{editUrl}">EDIT</s:a>
	</display:column>
	
	<display:setProperty name="export.excel.filename" value="diplayTag.xls"></display:setProperty>
	<display:setProperty name="export.pdf.filename" value="diplayTag.pdf"></display:setProperty>
	<display:setProperty name="export.csv.filename" value="diplayTag.csv"></display:setProperty>
	<display:setProperty name="export.pdf" value="true"></display:setProperty>
</display:table> --%>
