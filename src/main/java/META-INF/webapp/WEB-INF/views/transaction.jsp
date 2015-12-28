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
    <h1>Skapa en transaktion</h1>
    <div class="info">${message}</div>
    <form:form id="createTransactionForm" method="POST" action="/transaction" modelAttribute="transactionBean">
    <table>
    	<tr>
        	<td><form:label path="name">Namn</form:label></td>
        	<td><form:input path="name" /></td>
    	</tr>
    	    	<tr>
        	<td><form:label path="amount">Belopp</form:label></td>
        	<td><form:input path="amount" /></td>
    	</tr>
    	<tr>
    		<td><form:select path="transaction">
    		<form:options items="${transactionBean.transactionTypes}"/>
    		</form:select></td>	
    	</tr>
    	<tr>
        	<td colspan="2">
            	<input type="submit" value="Godkänn"/>
        	</td>
    </tr>
</table>  
</form:form>
  </body>
  
 
  
</html>