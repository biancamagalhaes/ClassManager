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


	<h2>Basta preencher o nome da disciplina para cadastra-la:</h2>
	<br>

	<form action="register" method="post">

		<table>

			<tr>
				<td>Nome da disciplina:</td>
				<td><input name="name" size="30" required="required" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Cadastrar" /></td>
			</tr>

		</table>

	</form>

</body>
</html>