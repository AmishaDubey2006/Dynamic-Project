<%@page import="in.co.rays.bean.MarksheetBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="">
<%@ include file="Header.jsp"%>

		<%
			List list = (List) request.getAttribute("list");

			Iterator it = list.iterator();
		%>
<table border="1" cellpadding="10px"  style="border-collapse:collapse; text-align:center; width:50%; height:50%" >
<tr>

	<th>Id</th>
	<th>Name</th>
	<th>RollNo</th>
	<th>Physics</th>
	<th>Chemistry</th>
	<th>Maths</th>
	

</tr>
<%
while(it.hasNext()){
	bean = (MarksheetBean) it.hasNext();
	%>
	<tr>
		<td><%=bean.getId()%></td>
		<td><%=bean.getName()%></td>
		<td><%=bean.getRoll_no()%></td>
		<td><%=bean.getPhysics()%></td>
		<td><%=bean.getChemistry()%></td>
		<td><%=bean.getMaths()%></td>
			</tr>
	<%
		}
	%>


</table>
</form>

</body>
</html>