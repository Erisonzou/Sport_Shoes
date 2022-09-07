<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "com.example.demo.*" %>
    <%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
h1 {text-align: center;}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>HELLO ADMIN</h1><br>

<div style = "text-align:center;">

<form action="get">
view current Shoes <input type="submit">
</form>

</div>
<div style = "text-align:center;">

<form action="newShoe">
Insert new Shoes <input type="submit">
</form>

<form action="CurrentUsers">
view current Users <input type="submit">
</form>

<form action="UserHistory">
view User Purchase History <input type="submit">
</form>

</div>
</body>
</html>