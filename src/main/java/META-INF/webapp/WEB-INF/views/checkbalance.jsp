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

	<div class="container-fluid">
		<div class="row text-center">
			<ul class="nav nav-tabs">
				<li role="presentation"><a href="/login">Startsida</a></li>
				<li role="presentation" ><a
					href="/createcustomer">Skapa ny kund</a></li>
				<li role="presentation" class="active"><a href="/checkbalance">Kolla saldo</a></li>
				<li role="presentation"><a href="/transaction">Transaktioner</a></li>
				<li role="presentation"><a href="/allcustomers">Alla kunder</a></li>
			</ul>
			<div class="row">
				<h2>Kolla saldo</h2>
			</div>
			<div class="bg-danger">
				<p>${error}</p>
			</div>
			<div class="bg-info">
				<p>${info}</p>
			</div>

			<div class="row">
				<form:form id="checkBalanceForm" method="POST"
					action="/checkbalance" modelAttribute="customerBean">
					<form:input path="name" class="form-control input-lg" placeholder="Namn"/>
					<input type="submit" value="Kolla saldo" class="btn btn-success input-lg" />
				</form:form>
			</div>
		</div>
	</div>
  </body>
  
 
  
</html>