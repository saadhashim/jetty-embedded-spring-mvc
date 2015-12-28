<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1>Alla kunder</h1>
    <div class="info">${message}</div>
    <table>
    <c:forEach var="customer" items="${customers}">
    	<tr>
        	<td><label>Namn</label></td>
        	<td><label>"${customer.name}"</label></td>
    	</tr>
    	<tr>
        	<td><label>Saldo</label></td>
        	<td><label>"${customer.balance}"</label></td>
    	</tr>
</c:forEach>
</table>  
  </body>
  
 
  
</html>