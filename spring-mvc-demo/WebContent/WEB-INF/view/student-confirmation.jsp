<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Confirmation Form</title>
</head>
<body>
The Student is confirmed: ${student.firstName} ${student.lastName}
<br></br>

Country: ${student.country}
<br></br>
Nationality: ${student.nationality}
<br></br>
Preferred Language: ${student.favouriteLanguage}
<br></br>
Preferred Coding Language: ${student.favouriteCodingLanguage}
<br></br>
Preferred OS
<ul>
<c:forEach var="temp" items="${student.preferredOS}">
 <li>${temp}</li>
</c:forEach>
</ul>
</body>
</html>