<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset style="width: 400px">
		<form action="editaction">
			<table>
				<tr>
					<td>Customer Subscription Id</td>
					<td><input type="text" name="subscriber_id"></td>
				</tr>
				<tr>
					<td>Channels</td>
					<td><select name="channelname">
							<c:forEach var="c" items="${clist}">
								<option value="${c}">${c}</option>
							</c:forEach>
					</select></td>
				</tr>

				
				<tr>
					<td></td>
					<td><input type="submit" value="Unsubscribe"></td>
				</tr>
				
				<tr>
					<!-- <td></td> -->
					<td><a href="/DthMediumLevel/">Home</a></td>
				</tr>
			</table>
		</form>



	</fieldset>
</body>
</html>