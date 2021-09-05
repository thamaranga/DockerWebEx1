<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add/Edit New Student</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>

   <div class="container container-default">
	   <h1>Add Student Page</h1>
   		<div class="well">
			<form action="StudentServlet" method="post">

				<div class="form-group row">
					<label for="firstName" class="col-2 col-form-label">First
						Name</label>
					<div class="col-10">
						<input class="form-control" type="text" name="firstName" id="firstName"
							placeholder="First Name">
					</div>
				</div>
				<div class="form-group row">
					<label for="lastName" class="col-2 col-form-label">Last Name</label>
					<div class="col-10">
						<input class="form-control" type="text" name="lastName"
							 id="lastName"
							placeholder="Last Name">
					</div>
				</div>

				<div class="form-group row">
					<label for="year" class="col-2 col-form-label">Year</label>
					<div class="col-10">
						<input class="form-control" type="text" name="year"
							value="<c:out value="${student.year}"/>" id="year"
							placeholder="Year">
					</div>
				</div>
		
				<div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
		
			</form>
		</div>
	</div>
</body>
</html>
