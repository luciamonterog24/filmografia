<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<html>
	<head>
		<title>Info</title>
	</head>
	<body>
		<form action="demoServlet?action=mostrarPeliculaDirector" method="post">
		Usuario: <input type="text" id="usuario" name="director">
		Contraseña: <input type="text" id="usuario" name="director">
		<input class="boton" type="submit">
		</form>
		
		<br>
		<button type="button" name="back" onClick="history.back()">Volver</button>
	</body>
</html>