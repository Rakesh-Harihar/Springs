<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/css/header_menu.css" />" rel="stylesheet">
</head>
<body>
	<div class="row"><img class="col-md-offset-4 col-xs-offset-4"></div>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container" style="width: 100%;">
		<div class="row fnt">
			<c:set var="role" value="${role }" />
			<c:if test="${role==1}">

				<ul class="fnt">
					<li class="col-md-2 col-xs-4"><a>Vendor</a>
						<ul>
							<li><a href="vendorRegistration">Register Vendor</a></li>
							<li><a href="trainerRegistration">Register Trainer</a></li>
							<li><a href="viewVendorDetails">View Vendor</a></li>
						</ul>
					</li>
					<li class="col-md-2 col-xs-4"><a>Training</a>
						<ul>
							<li><a href="viewTrainingRequestAll">Training Request</a></li>
							<li><a href="trainingDetails">Training Details</a></li>
						</ul>
					</li>
					
					<li style="float: right;" class="col-md-2 col-xs-4"><a id="logout" href="logout">Logout</a></li>
			  </ul>
			</c:if>
			<c:if test="${role==2}">
				<ul class="fnt">

					<li class="col-md-2 col-xs-3"><a>Training</a>
						<ul>
							<li><a href="trainingDetails">Training Details</a></li>

						</ul>
					</li>
					<li class="col-md-2 col-xs-6"><a>Training Request</a>
						<ul>
							<li><a href="trainingRequest">Training Request</a></li>
							<li><a href="viewTrainingRequest">View Request</a></li>
						</ul>
					</li>
					<li style="float: right;" class="col-md-2 col-xs-3"><a id="logout" href="logout">Logout</a></li>
				</ul>
			</c:if>
			<c:if test="${role==3}">
				<ul class="fnt">
					<li class="col-md-2 col-xs-4"><a>Feedback</a>
						<ul>
							<li><a href="feedbackRegistration">Training Feedback</a></li>
						</ul>
						<li style="float: right;" class="col-md-2 col-xs-4"><a id="logout" href="logout">Logout</a></li>
					</li>
			    </ul>
			</c:if>
		</div>
	</div>
</body>
</html>