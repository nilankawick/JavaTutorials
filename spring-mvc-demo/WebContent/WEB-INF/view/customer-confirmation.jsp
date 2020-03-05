<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Customer Confirmation Page</title>
</head>

<body>
<h3>Customer Registration Confirmation</h3>
<hr></hr>
The Customer is confirmed : ${customer.firstName} ${customer.lastName}
<br></br>
Number of Free Pass: ${customer.freePasses}
<br></br>
Postal Code: ${customer.postalCode}
<br></br>
Course Code: ${customer.courseCode}

</body>
</html>
