<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<html>
	<head>
		<title>Info</title>
	</head>
	<body>
		<table width="100%" border="2" bordercolor="#0000FF" cellspacing="10" cellpadding="10">
			<tr>
				<th>Titulo</th>
				<th>Director</th>
				<th>Fecha</th>
			</tr>
			<c:forEach var="pelicula" items="${peliculas}">
			<tr align="middle">
				<td>${pelicula.titulo }</td>
				<td>${pelicula.director }</td>
				<td>${pelicula.fecha }</td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<button type="button" name="back" onClick="history.back()">Volver</button>
	</body>
</html>