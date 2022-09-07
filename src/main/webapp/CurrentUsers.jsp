<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import = "com.example.demo.*" %>
    <%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> List of Current Users</h2>
<%List<User> u = (List<User>)request.getAttribute("list"); %>
<table border = "1">
<tr><th>User name</th><th>password</th><th>email</th><th>User type</th><th>Edit</th><th>Delete</th></tr>
<%for(User uu:u){ %>
<tr><td><%=uu.getUsername() %></td>
<td><%=uu.getPassword()%></td>
<td><%=uu.getEmail()  %></td>
<td><%=uu.getUserType()  %></td>
<td><a href="./EditUser.jsp">edit</a></td>
<td><a href="./deleteUser.jsp">delete</a></td>
</tr>
<%} %>
</table>
</body>
</html>