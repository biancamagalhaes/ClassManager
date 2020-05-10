<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="home.css">
<title>Manager Class</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<center>
		<h1>DASHBOARD</h1>
		<div class="buttons">
			<a href="${contextPath}/student/add" id="button"><input
				type="button" value="Aluno"></a><br />
			<br>
			<br> <a href="${contextPath}/teacher/add" id="button"><input type="button"
				value="Docente"></a><br />
			<br>
			<br> <a href="${contextPath}/event/add" id="button"><input
				type="button" value="Evento"></a><br />
			<br>
			<br> <a href="${contextPath}/matter/add" id="button"><input
				type="button" value="Materia"></a><br />
			<br>
			<br> <a href="${contextPath}/discipline/add" id="button"><input
				type="button" value="Disciplina"></a><br />
			<br>
			<br> <a href="${contextPath}/class/add" id="button"><input
				type="button" value="Turma"></a><br />
			<br>
			<br>
		</div>

	</center>
</body>
</html>