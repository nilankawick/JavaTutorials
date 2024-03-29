<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>
List Customers - Coming Soon !!!

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<input type="button" value="Add Customer" 
			onclick="window.location.href='addNewCustomer'; return false;"
			class="add-button"
			/> 
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				
				<c:forEach var="tempCustomer" items="${customers}">
				
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<!--  The update link that contains the customer id - step 1. create a variable to hold the url -->
						<c:url var="updateLink" value="/customer/updateCustomer">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
						
						<c:url var="deleteLink" value="/customer/deleteCustomer">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
						
						<!-- Display the link -->
						<td><a href="${updateLink}">Update</a> | <a href="${deleteLink}" onclick="if (!(confirm('Please confirm to delete!!'))) return false">Delete</a></td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>

</body>

</html>









