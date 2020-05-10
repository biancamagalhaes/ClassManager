<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Cadastrar Turma</title>
</head>
<body>


	<h2>Basta preencher os campos abaixo para cadastrar uma nova turma:</h2>
	<br>

	<form action="register" method="post">

		<table>

			<tr>
				<td>Sala:</td>
				<td><input name="place" size="30" required="required" /></td>
			</tr>

			<tr>
				<td>Professor:</td>
				<td><select disabled><option value="1">Desabilitado</option></select></td>
			</tr>
			
			<tr>
				<td>Disciplina:</td>
				<td><select disabled><option value="1">Desabilitado</option></select></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Cadastrar" /></td>
			</tr>

		</table>

	</form>

</body>
</html>