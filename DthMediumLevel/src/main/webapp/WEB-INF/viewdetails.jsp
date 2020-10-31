<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="user" items="${lists.userdetails}">
		<p>Subscription ID: ${user.subscriber_id}</p>
		<p>Customer Name: ${user.first_name} ${user.last_name} </p><br>
	</c:forEach>
		<p>Total Subscription Cost: ${totalcost}</p><br>
	<table border="2" width="30%" cellpadding="2">
		<tr>
			<th>Channel Name</th>
			<th>Cost_Per_Month</th>
		</tr>
		<c:forEach var="emp" items="${lists.subdetails}">
			<tr>
				<td>${emp.channel_name}</td>
				<td>${emp.cost_per_month}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/DthMediumLevel/">Home</a>
</body>
</html>