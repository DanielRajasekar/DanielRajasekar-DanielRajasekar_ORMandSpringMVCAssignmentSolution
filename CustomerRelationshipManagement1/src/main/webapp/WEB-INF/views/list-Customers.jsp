<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<!--  <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">-->
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" 
	crossorigin="anonymous">

<title>Customer Relationship Management</title>
</head>

<body>

	<div class="container">

		<h3>Customer Directory</h3>
		<hr>

		<!-- Add a search form -->

		<form action="/CustomerManagement/customers/search" class="form-inline">

			<!-- Add a button -->
		<a href="/CustomerManagement/customers/showFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Book </a>
				<!--  <input
				type="search" name="name" placeholder="Name"
				class="form-control-sm ml-5 mr-2 mb-3" /> <input type="search"
				name="author" placeholder="Author" class="form-control-sm mr-2 mb-3" />

			<button type="submit" class="btn btn-success btn-sm mb-3">Search</button>-->

		</form>

		<table class="table">
			<thead class="table-dark">
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email Id</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Customers}" var="tempCustomer">
					<tr>
						<td><c:out value="${tempCustomer.firstname}" /></td>
						<td><c:out value="${tempCustomer.lastname}" /></td>
						<td><c:out value="${tempCustomer.email}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/CustomerManagement/customers/showFormForUpdate?customerId=${tempCustomer.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="/CustomerManagement/customers/delete?customerId=${tempCustomer.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>
</body>
</html>



