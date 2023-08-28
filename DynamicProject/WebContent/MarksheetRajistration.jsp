<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:lightslategray">

		<%
		String msg = (String) request.getAttribute("msg");
	%>
	<form action="MarksheetCtl" method="post">
	
		<table>
			<tr>
				<%
					if (msg != null) {
				%>
				<%=msg%>
				<%
					}
				%>
			</tr>
			<tr>
				<th>Name :</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>RollNo :</th>
				<td><input type="text" name="rollNo"></td>
			</tr>
			
			<tr>
				<th>Physics :</th>
				<td><input type="text" name="Physics"></td>
			</tr>
			
			<tr>
				<th>Chemistry :</th>
				<td><input type="text" name="chemistry"></td>
			</tr>
			
			<tr>
				<th>Maths :</th>
				<td><input type="text" name="maths"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="SingUp">
				<input type="submit" name="operation" value="Reset"></td>
			</tr>
	</table>
	</form>
</body>
</html>


