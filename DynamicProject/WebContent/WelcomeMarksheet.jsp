<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String name = request.getParameter("name");
int rollNo = Integer.parse Int(request.getParameter("rollNo"));
int physics = Integer.parse Int(request.getParameter("physics"));
int Chemistry = Integer.parse Int(request.getParameter("chemistry"));
int maths = Integer.parse Int(request.getParameter("maths"));




MarksheetBean bean = new MarksheetBean();
bean.setName(name);
bean.setRoll_no(rollNo);
bean.setPhysics(physics);
bean.setChemistry(chemistry);
bean.setMaths(maths);

	MarksheetModel model = new MarksheetModel();
	model.add(bean);
%>

<h1><%=name %></h1>
<h1><%=rollNo %></h1>
<h1><%=physics %></h1>
<h1><%=chemistry%></h1>
<h1><%=maths %></h1>


</body>
</html>