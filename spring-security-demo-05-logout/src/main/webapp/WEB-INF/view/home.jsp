<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Love2Code Company Home Page</title>
</head>

<body>
	<h2>Company Home Page --- Yo!!!!!Silly</h2>
	<hr>
	Welocome!!!
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="Logout">
	</form:form>
</body>

</html>