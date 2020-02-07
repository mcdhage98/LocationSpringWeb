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

<h2>UPDATE LOCATION</h2>
<form action="updateLoc" method="post">
Id:<input type="text" name="id" value=${location.id } readonly><br>
Code:<input type="text" name="code" value=${location.name }><br>
Name:<input type="text" name="name" value=${location.id }><br>
Type:Urban<input type="radio" name="type" value="Urban" ${location.type=='Urban'?'Checked':''}><br>
     Rural<input type="radio" name="type" value="Rural" ${location.type=='Rural'?'Checked':''}><br>
<input type="submit" value="save">

</form>

</body>
</html>