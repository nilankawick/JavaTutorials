<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<title>Love2Code Company Home Page</title>
</head>

<body>
	<h2>Company Home Page --- Yo!!!!!Silly</h2>
	<hr>
	Welocome!!!
	
	<!-- Display user name and role -->
	<p>
	User: <security:authentication property="principal.username"/>
	<br><br>
	Role(s): <security:authentication property="principal.authorities"/>
	</p>
	<hr>
	<!-- Role based access points  -->
	<security:authorize access="hasRole('MANAGER')">
		<p>
		<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>(Only for Management)
		</p>
		
	</security:authorize>
	<hr>
	<security:authorize access="hasRole('ADMIN')">
	<p>
	<a href="${pageContext.request.contextPath}/admin">Revolt section 3%</a>(Only for JVP)
	</p>
	</security:authorize>
	<hr>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="Logout">
	</form:form>
</body>

</html>