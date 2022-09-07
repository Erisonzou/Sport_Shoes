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

<h2> Purchase list</h2>
<%List<Purchase> s = (List<Purchase>)request.getAttribute("Purchases"); %>
<table border = "1">
<tr><th>id</th><th>User</th><th>Shoe Brand</th><th>Shoe Name</th><th>Shoe Price</th><th>Shoe Size</th><th>Time</th></tr>
<%for(Purchase ss:s){ %>
<tr><td><%=ss.getId() %></td>
<td><%=ss.getUser()%></td>
<td><%=ss.getShoeBrand()  %></td>
<td><%=ss.getShoeName()  %></td>
<td><%=ss.getShoePrice() %></td>
<td><%=ss.getShoeSize() %></td>
<td><%=ss.getTime() %></td>
</tr>
<%} %>
</table>

</body>
</html>