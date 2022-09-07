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
<h2> Shoe Brand</h2>
<%List<Shoe> shoe = (List<Shoe>)request.getAttribute("ShoeList"); %>
<table border = "1">
<tr><th>Name</th><th>Price</th><th>Brand</th><th>Size</th><th>Quantity</th></tr>
<%for(Shoe ss:shoe){ %>
<tr><td><%=ss.getName() %></td><td><%=ss.getPrice()%></td><td><%=ss.getBrand()  %></td><td><%=ss.getSize()  %></td><td><%=ss.getQuantity() %></td></tr>
<%} %>
</table>
</body>
</html>