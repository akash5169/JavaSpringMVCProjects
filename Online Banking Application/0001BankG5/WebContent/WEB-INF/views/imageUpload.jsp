<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url var="myaction" value="/saveImage"></c:url>
<form:form method="post" action="${myaction}" commandName="images" enctype="multipart/form-data">
	<form:errors path="*" cssClass="error"/>
	<table class="table">
	
	<tr>
		<td><form:label path="">Profile Image:</form:label></td>
		<td><input type="file" name="proImage"></input></td>
	</tr>
	<tr>
		<td><form:label path="">Signature Photocopy:</form:label></td>
		<td><input type="file" name="signImage"></input></td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="Save"/>
		</td>
		<td><a href="customerhome" class="btn btn-primary">Cancel</a></td>
	</tr>
</table>	
</form:form>

</body>
</html>