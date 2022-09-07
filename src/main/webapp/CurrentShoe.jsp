<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "com.example.demo.*" %>
    <%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h2> List of Current Shoe Products in Store</h2>
<%List<Shoe> s = (List<Shoe>)request.getAttribute("list"); %>
<table border = "1">
<tr><th>Name</th><th>Price</th><th>Brand</th><th>Size</th><th>Quantity</th><th>Edit</th><th>Delete</th></tr>
<%for(Shoe ss:s){ %>
<tr><td><%=ss.getName() %></td>
<td><%=ss.getPrice()%></td>
<td><%=ss.getBrand()  %></td>
<td><%=ss.getSize()  %></td>
<td><%=ss.getQuantity() %></td>
<td><a href="./edit.jsp">edit</a></td>
<td><a href="./delete.jsp">delete</a></td>
</tr>
<%} %>
</table>
</div>
<div> 
<h3>Find Shoes By Brand </h3>
<form action="getBrand">
Brand <input type="text" name="Brand"><br>
<input type="submit">
</form>
<br>
<br>
<form action="AdminMain">
<input type="submit" value="Return To Main menu">
</form>
</div>
</body>
</html>