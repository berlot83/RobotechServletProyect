<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="taglib"%>
<title>Ingreso</title>
</head>

<script type="text/javascript">
	//LLamada a imagen
	$(document).ready(function() {

		var fieldId = document.getElementById("fieldId");
		var name = document.getElementById("name");
		var lastname = document.getElementById("lastname");

		$('#botonImagen').click(function() {
			$.post("Index", {
				fieldId : fieldId.value,
				name : name.value,
				lastname : lastname.value
			}, function(responseText) {
				alert(responseText);
			});
		});
	});

	function login() {
		var frm = document.frmLogin;
		frm.submit();
	}

	function exit() {
		var frm = document.frmExit;
		frm.submit();
	}
</script>

<%
	if (session != null) {
		out.write("Hello " + session.getAttribute("user"));
	} else {
		session = null;
	}
%>


<form action="ServletExit" method="get" name="frmExit"></form>

<img alt="Exit now"
	src="images\webResourcesImages\marginalButtons/icon0002.gif"
	onclick="exit()">

<body>

	<%
	/* Si la session es nula que muestre ése mensaje */
		if (session.getAttribute("user") == null) {
			out.print("<p align='center'>activar Xampp, importar la DB que esta en la carpeta DataBase y usar el usuario y contraseña, (rick, 159)</p>");
		}
	%>
	
	<h3 align="center">Ingrese su usuario para poder ver el contenido:</h3>

	<form action="ServletLogin" method="post" name="frmLogin">
		<table align="center">
			<tr>
				<td>User:</td>
				<td><input type="text" placeholder="User" name="user" />
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" placeholder="password"
					name="password"></td>
			</tr>
			<tr>
				<td><img alt="Login"
					src="images\webResourcesImages\marginalButtons\icon0001.gif"
					onclick="login()"></td>
				<td><a href="forgotPassword.jsp">I forgot my pass</a></td>
			</tr>
		</table>
	</form>

	<%
	/* Setteamos el atributo antes ya que en este jsp solo usamos un getAttribute */
		if (session.getAttribute("user") != null) {
			out.print("<br>Esta dentro de un sessión, siga el siguiente link para ver cómo se persisten los datos <a href='persistedData.jsp'>Persisted data</a>");
		}
	%>
	

	<br>
	<br>
	<br>

	<%
		String disabled = null;
		String display = null;

		if (session.getAttribute("user") == null) {
			disabled = "disabled";
			display = "display:none;";
		} else {
			disabled = "";
		}
	%>

	<div style=<%out.print(display);%>>

		<h3 align="center">Ingresar Veritech:</h3>
		<table id="entrada" align="center">
			<tr>
				<td>Legajo</td>
				<td><input type="number" id="fieldId" <%out.print(disabled);%> /></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input type="text" id="name" <%out.print(disabled);%> /></td>
			</tr>
			<tr>
				<td>Apellido</td>
				<td><input type="text" id="lastname" <%out.print(disabled);%>></td>
			</tr>
			<tr>
				<td><img alt="botonImagen" id="botonImagen"
					src="images\webResourcesImages\marginalButtons\icon0001.gif"></td>
			</tr>
		</table>

		<h3 align="center">
			Ver resultados: <a href="ServletResults"> Acá</a>
		</h3>

	</div>

</body>
</html>