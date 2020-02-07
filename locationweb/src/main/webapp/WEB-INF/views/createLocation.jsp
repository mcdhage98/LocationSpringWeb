<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Location</title>
</head>
<body>
<center>s
<h2>CREATE LOCATION</h2>
<form action="saveloc" method="post">
Id:<input type="text" name="id"><br>
Code:<input type="text" name="code"><br>
Name:<input type="text" name="name"><br>
Type:Urban<input type="radio" name="type" value="Urban"><br>
     Rural<input type="radio" name="type" value="Rural"><br>
<input type="submit" value="submit">

</form>
${msg}

<a href="displayLocations">View all</a>
</center>

</body>
</html>