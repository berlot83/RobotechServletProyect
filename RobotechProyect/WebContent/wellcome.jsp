<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<script>
	function back() {
		var frm = document.frmLiveSession;
		frm.submit();
	}
</script>
<body>

	<%
		String user = (String) session.getAttribute("user");
		request.setAttribute("user", user);
	%>

	<h2>
		Hello
		<%
		out.print(user);
	%>
		you are wellcome back today
	</h2>
	<form action="ServletLiveSession" method="get" name="frmLiveSession">
		please go to the main page to continue... <a href="index.jsp">GoBack</a>

	</form>
	<img alt="Back"
		src="images\webResourcesImages\marginalButtons/icon0007.gif" id="back"
		onclick="back()">
</body>
</html>