<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<ul class="nav nav-tabs">
				<li role="presentation"><a href="/loggedin">Startsida</a></li>
				<li role="presentation"><a href="/createcustomer">Skapa ny
						kund</a></li>
				<li role="presentation"><a href="/checkbalance">Kolla saldo</a></li>
				<li role="presentation" ><a href="/transaction">Transaktioner</a></li>
				<li role="presentation" class="active"><a href="/allcustomers">Alla kunder</a></li>
			</ul>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<h1>Alla kunder</h1>
					<div class="info">${message}</div>
					<table class="table">
						<tr>
							<th>Namn</th>
							<th>Saldo</th>
						</tr>
						<c:forEach var="customer" items="${customers}">
							<tr>
								<td><label>${customer.name}</label></td>
								<td><label>${customer.balance}</label></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</div>
</body>



</html>