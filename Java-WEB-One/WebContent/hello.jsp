<%@page import="com.atguigu.javaweb.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>test</title>
</head>
<body>

	<%
		Person p = new Person();

		for (int i = 0; i < 10; i++) {
			System.out.println(p.getinfo(i));
		}
	%>

</body>
</html>