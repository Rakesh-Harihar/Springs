<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="<c:url value="/css/header_menu.css" />" rel="stylesheet">
<style>
@media screen and (max-width: 400px) {
	input {
		width: 250px;
	}
}
</style>
</head>
<body>
	<div class="container" id="container">
		<div class="row">
			<div class="col-md-4 col-xs-12">
				<img src="<c:url value="/images/valtech_logo.png"/>" width="200">
			</div>
			<div class="col-md-8 col-xs-12">
				<img id="logo"
					src="<c:url value="/images/learninganddevlopment.png" />"
					width="200">
			</div>
		</div>
	</div>
</body>
</html>