<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body onload="fun()">
	<script>
		function fun() {
			var d = new Date();
			document.getElementById("dt").disabled = true;
			document.getElementById("dt").value = d.getDate() + "/"
					+ d.getMonth() + "/" + d.getFullYear();
		}

		function getdate() {
			document.getElementById("dt").disabled = false;
		}
	</script>

	<fieldset style="width: 300px">
		<form action="addsub">
			<table>
				<tr>
					<td>Customer Subscription Id</td>
					<td><input type="text" name="subscriber_id"
						required="required"></td>
				</tr>
				<tr>
					<td>Channels</td>
					<td><select name="channel_name">
							<c:forEach var="c" items="${clist}">
								<option value="${c}">${c}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Date of Subscription</td>
					<td><input type="text" name="subscription_date" id="dt"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Subscribe" onclick="getdate()"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>