<%@page import="in.co.rays.bean.UserBean"%>
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
<body style="background-color: lightpink">

<form action="UserListCtl.do" method="post">
<%@ include file="Header.jsp"%>

		<%
			List list = (List) request.getAttribute("list");
			int pageNo = (int) request.getAttribute("pageNo");
			int nextListSize = (int) request.getAttribute("nextListSize");
			int index = ((pageNo - 1) * 5) + 1;

			Iterator it = list.iterator();
		%>
		
		<table>
			<tr>
				<td><input type="text" name="firstName"></td>
				<td><input type="submit" name="operation" value="search"></td>
			</tr>
		</table>
		
<table border="1" cellpadding="10px"  style="border-collapse:collapse; text-align:center; width:50%; height:50%" >
<tr>
	<th>Select</th>
	<th>Id</th>
	<th>FirstName</th>
	<th>LastName</th>
	<th>LoginId</th>
	<th>Password</th>
	<th>Dob</th>
	<th>Address</th>
	<th>Edit</th>
</tr>
<%

	while(it.hasNext()){
	bean = (UserBean) it.next();
	
	%>
	
	<tr>
		<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
		<td><%=index++%></td>
		<td><%=bean.getFirst_name()%></td>
		<td><%=bean.getLast_name()%></td>
		<td><%=bean.getLogin_id()%></td>
		<td><%=bean.getPassword()%></td>
		<td><%=bean.getDob()%></td>
		<td><%=bean.getAddress()%></td>
		<td><a href="UserCtl?id=<%=bean.getId()%>">edit</a></td>
	
	</tr>
	<%
		}
	%>


</table>

<table>
			<tr>
				<td><input type="hidden" name="pageNo" value="<%=pageNo%>">
				<td><input type="submit" name="operation" value="previous"
					<%=(pageNo != 1) ? "" : "disabled"%>>
				<td><input type="submit" name="operation" value="next"
					<%=(nextListSize != 0) ? "" : "disabled"%>></td>
				<td><input type="submit" name="operation" value="delete">
			</tr>
		</table>

</form>
</body>
</html>
