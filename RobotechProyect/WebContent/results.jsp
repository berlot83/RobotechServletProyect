<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery-3.2.1.js"></script>
<script src="js/jquery.paginemytable.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="taglib"%>
<title>Resultados de Tabla</title>
</head>

<script type="text/javascript">
	$(document).ready(function() {
		$('#imagenResultados').click(function() {
			$.post("ServletResults", function(responseText) {
				$('#results').html(responseText);
			});
		});
	});
</script>

<body>
	<table id="tabla" align="center">
		<thead>
			<tr>
				<td>Legajo</td>
				<td>Nombre</td>
				<td>Apellido</td>
			</tr>
		</thead>
		
		<tBody id="results">

		</tBody>
	</table>
	
	


	<img alt="Ver Resultados" src="images/lupa1.png" id="imagenResultados">
	<img alt="atras" src="images/izquierda.png" id="izquierda">
	<img alt="adelante" src="images/derecha.png" id="derecha">

</body>
</html>