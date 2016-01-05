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
			<div class="row">
				<h2>Valvet</h2>
				<img src="/i/valv.jpg" height="200" alt="valvet" />
				<p>För att kunna ta dig in i valvet beöver du följa
					instruktionerna nedan</p>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<h2>Vägen till valvet</h2>
					<div class="bg-info">
						<p>${info}</p>
					</div>
					<div class="bg-danger">
						<p>${error}</p>
					</div>
					<form:form id="valvetForm" method="POST" action="/oppnaValvet"
						modelAttribute="valvetBean">
						<form:label path="expectedText" id="expextedtextlabel" >${valvetBean.expectedText}</form:label>
						<form:input path="textboxValue" name="expectedtextinput" class="form-control input-lg"
							placeholder="Kopiera in texten från labeln ovan hit" />
						<br>
						<form:label path="expectedRadio">Välj radioknappen med texten nedan</form:label>
						<br>
						<form:label path="expectedRadio" class="radiolabel" >${valvetBean.expectedRadio}</form:label>
						<br>
						<form:radiobuttons path="chosenRadio" element="li"
							items="${valvetBean.radioList}" />
						<br>
						<form:label path="expectedSelect">Välj valet med texten i knappen nedan</form:label>
						<br>
						<form:input path="expectedSelect" name="expectedSelectLabel" type="button"
							value="${valvetBean.expectedSelect}"></form:input>
						<br>
						<form:select path="chosenSelect" class="form-control input-lg">
							<form:options items="${valvetBean.selectList}" />
						</form:select>
						<br>
						<form:label path="expectedCheckbox" >Välj valet med texten i knappen nedan</form:label>
						<br>
						<span id="checkboxspan">${valvetBean.expectedCheckbox}</span>
						<br>
						<form:checkboxes path="chosenCheckbox"
							class="form-control" element="div class='checkbox'" items="${valvetBean.checkboxList}" />
						<br>
						
						<form:label path="expectedForbiddenCheckbox">Checka ur alla checkboxar nedan</form:label>
						<br>
						<form:checkboxes path="chosenForbiddenCheckbox"
							class="checkbox" element="div class='checkbox'" items="${valvetBean.forbiddenCheckboxList}" />
						<br>
						
						<input type="submit" value="Öppna skåpet"
							class="btn btn-success input-lg" />

						<form:input type="hidden" path="expectedText" class="form-control input-lg" />
						<form:input type="hidden" path="expectedSelect" class="form-control input-lg" />
						<form:input type="hidden" path="expectedCheckbox" class="form-control input-lg" />
						<form:input type="hidden" path="expectedRadio" class="form-control input-lg" />
						<form:input type="hidden" path="expectedForbiddenCheckbox" class="form-control input-lg" />

					</form:form>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</div>
</body>



</html>