<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Sign Up Form</title>
</head>
<body>


	<h2>Basta preencher os campos abaixo para inserir um evento:</h2>
	<br>

	<form action="register" method="post">

		<table>

			<tr>
				<td>Nome do Evento:</td>
				<td><input name="name" size="30" required="required" /></td>
			</tr>

			<tr>
				<td>Descrição do Evento:</td>
				<td><textArea name="description" rows=5 cols=30 required="required"></textArea></td>
			</tr>
			
			<tr>
				<td>Tipo do Evento:</td>
				<td><select id="type" name="type"><option value="holiday">Feriado</option> <option value="other">Outros</option></select></td>
			</tr>
			
			<tr>
				<td>Inicio do Evento:</td>
				<td><input type="datetime-local" id="meeting-time"
       name="timeStart" ></td>
			</tr>

<tr>
				<td>Final do Evento:</td>
				<td><input type="datetime-local" id="meeting-time"
       name="timeEnd" ></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Cadastrar" /></td>
			</tr>

		</table>

	</form>

</body>
</html>