<%@page import="in.co.rays.bean.MarksheetBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:rgb(93, 236, 236);">
	<%
		MarksheetBean bean = (MarksheetBean) session.getAttribute("marksheet");
	%>

	<%
		if (bean != null) {
	%>
	<h3>
		Hi,
		<%=bean.getName()%></h3>
		<a href="MarksheetListCtl" >UserList</a>
		
		<a href="LoginCtl?operation=logout" >Logout</a>
	<%
		} else {
	%>
	<h3>Hi, Guest</h3>
	<%
		}
	%>
	<hr>


</body>
</html>