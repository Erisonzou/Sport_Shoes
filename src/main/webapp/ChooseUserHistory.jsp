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
<tr><th>User name</th></tr>
<%for(User uu:u){ %>
<tr><td><%=uu.getUsername() %></td></tr>
<%} %>
</table>
<br>
<h3> Which user's Purchase history would you like to see</h3>

<form action ="purchaseList">
User's user name <input type="text" name="user"><br>
<input type="submit" value="find user">
</form>

</body>
</html>