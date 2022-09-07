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
<h2> List of Current Shoe Products in Store</h2>
<%List<Shoe> s = (List<Shoe>)request.getAttribute("list"); %>

<table border = "1">

<tr>
	<th>Name</th>
	<th>Price</th>
	<th>Brand</th>
	<th>Size</th>
	<th>Quantity</th>
</tr>

<%for(Shoe ss:s){ %>
<tr>
	<td><%=ss.getName() %></td>
	<td><%=ss.getPrice()%></td>
	<td><%=ss.getBrand()  %></td>
	<td><%=ss.getSize()  %></td>
	<td><%=ss.getQuantity() %></td>
</tr>
<%} %>

</table>

<h3> Finished looking?</h3>
<h2> Input Your UserName and ShoeName to buy the Shoe</h2>
<form action = "buy"> 
User name <input type = "text" name = "user">
Shoe Name<input type = "text" name = "shoe">
<input type="submit" value="buy">
</form>
<div>

<h3> Looking for a Specific Brand?</h3>
<form action="userShoeBrand">
What Brand?<input type="text" name="Brand">
<input type="submit">
</form>

</div>
</body>
</html>