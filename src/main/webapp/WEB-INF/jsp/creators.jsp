<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creators List</title>
</head>
<body>
	<h1>Creators App</h1>
	<h2>Users List</h2>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Image Path</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${creators}" var="creator">
				<tr>
					<td>${creator.idCreators }</td>
					<td>${creator.name }</td>
					<td>${creator.imagePath }</td>
				</tr>
			</c:forEach>	
		</tbody>		
	</table>
</body>
</html>