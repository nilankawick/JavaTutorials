<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		
		First Name: <form:input path="firstName" />
		<br></br>
		
		Last Name: <form:input path="lastName" />
		<br></br>
		
		Country: 
		<form:select path="country">
			<form:options items="${student.countryOptions }"/>
		</form:select>
		<br></br>
		
		Nationality:
		<form:select path="nationality"> 
			 <form:options items="${theNationalityOptions}" />
		</form:select>
		<br></br>
		
		Language preference:
		<br></br>
		English <form:radiobutton path="favouriteLanguage" value ="English"/>
		Sinhala <form:radiobutton path="favouriteLanguage" value ="Sinhala"/>
		Tamil <form:radiobutton path="favouriteLanguage" value ="Tamil"/>
		French <form:radiobutton path="favouriteLanguage" value ="French"/>
		Japanese <form:radiobutton path="favouriteLanguage" value ="Japanese"/>
		<br></br>
		
		Favorite Language:
		<br></br>
        <form:radiobuttons path="favouriteCodingLanguage" items="${student.favouriteCodingLanguageOptions}"  />
		<br></br>
		
		Preferred OS:
		<br></br>
		Linux <form:checkbox path="preferredOS" value="Linux"/>
		Windows <form:checkbox path="preferredOS" value="Windows"/>
		Mac <form:checkbox path="preferredOS" value="OSX"/>
		Sun<form:checkbox path="preferredOS" value="SunOS"/>
		<br></br>
		
		
		<input type="submit" value="Submit">
	</form:form>

</body>
</html>