<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2> ALL LOCATIONS</h2>
<table>
<tr>
<th>ID</th>
<th>CODE</th>
<th>NAME</th>
<th>TYPE</th>

</table>

<table>
<c:forEach items="${allLocations}" var="location">

<tr>
<td>${location.id }</td>
<td>${location.code }</td>
<td>${location.name }</td>
<td>${location.type }</td>
<td><a href="deleteLocation?id=${location.id }">Delete Location</a></td>
<td><a href="updateLocation?id=${location.id }">Update Location</a></td>
</c:forEach>
</table>



<a href="showCreateLocationPage">Add location</a>
</center>

</body>
</html>