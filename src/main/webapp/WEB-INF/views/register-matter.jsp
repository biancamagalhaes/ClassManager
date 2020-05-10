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


	<h2>Basta preencher os campos abaixo para inserir um assunto:</h2>
	<br>

	<form action="register" method="post">

		<table>

			<tr>
				<td>Titulo:</td>
				<td><input name="title" size="30" required="required" /></td>
			</tr>

			<tr>
				<td>Subtitulo:</td>
				<td><textArea name="subtitle" rows=5 cols=30 required="required"></textArea></td>
			</tr>
			
		
			<tr>
				<td colspan="2"><input type="submit" value="Cadastrar" /></td>
			</tr>

		</table>

	</form>

</body>
</html>