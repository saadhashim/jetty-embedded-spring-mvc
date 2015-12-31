<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row text-center">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h1>Välkommen till JSTA-Banken</h1>
				<div class="bg-danger">
					<p>${message}</p>
				</div>
				<form:form id="loginForm" method="POST" action="/login"
					modelAttribute="loginBean">
					<div class="form-group">
						<form:input path="username" class="form-control input-lg"
							placeholder="Användarnamn" />
						<br>
					</div>
					<div class="form-group">
						<form:password path="password" class="form-control input-lg"
							placeholder="Lösenord" />
						<br>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-success input-lg"
							value="Logga in" />
					</div>
				</form:form>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>



</html>