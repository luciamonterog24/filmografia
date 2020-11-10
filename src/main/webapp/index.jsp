<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h2>Peliculas</h2>
	
	<br>
	<form action="demoServlet?action=mostrarPeliculas" method="post">
		<input class="boton" type="submit" value="Info">
	</form>
	<form action="demoServlet?action=mostrarPeliculaDirector" method="post">
		Introduce el director: <input type="text" id="director" name="director">
		<input class="boton" type="submit">
	</form>
	
	<input type="button" value="Login" action="demoServlet?action=login" method="post">
	
</body>
</html>
