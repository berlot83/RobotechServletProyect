<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<script type="text/javascript">
	function backTo() {
		var back = document.getElementById("back");
		back.onclick = function() {
			window.location.href = "index.jsp";
		}
	}
</script>

<body>

	<h2>Forgot your password?</h2>
	<label>please provide us your email</label>
	<br>
	<input type="email" placeholder="Email" />
	<br>
	<br>
	<img src="images\webResourcesImages\marginalButtons/icon0007.gif"
		alt="" id="back" onclick="backTo()">
</body>
</html>