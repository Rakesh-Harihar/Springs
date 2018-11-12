<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training Details</title>
<link href="<c:url value="/css/vendor.css"/>" rel="stylesheet">
</head>
<body>
	<jsp:include page="header_menu.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-10 col-md-offset-2 col-xs-8 col-sm-8 ">
				<p class="form-title">Training Details</p>
				<br>
				<!-- Training details -->
				<div class="details">
					<div class="row">
						<div class="col-md-2">
							<b>Topic:</b>
						</div>
						<div class="col-md-3">${training.topic}</div>
						<div class="col-md-2">
							<b>Start Date:</b>
						</div>
						<div class="col-md-3">${training.startDate}</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-2">
							<b>Requested By :</b>
						</div>
						<div class="col-md-3">${training.createdBy}</div>
						<div class="col-md-2">
							<b>End Date :</b>
						</div>
						<div class="col-md-3">${training.endDate}</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-2">
							<b>Category:</b>
						</div>
						<div class="col-md-3">${training.category}</div>
						<div class="col-md-2">
							<b>People Attending:</b>
						</div>
						<div class="col-md-3">${training.numberOfPeople}</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-2">
							<b>Training Toc:</b>
						</div>
						<div class="col-md-3">
							<c:choose>
								<c:when test="${not empty training.trainingFile}">
									<a href="data:application/pdf;base64,${training.trainingFile}"
										download='${training.trainingFileName}' title='${training.trainingFileName}'>
										<button type="button" class="btn btn-default btn-sm">
											<span class="glyphicon glyphicon-download-alt"></span>
										</button>
									</a>
								</c:when>
								<c:otherwise>
									<button type="button" class="btn btn-default btn-sm" disabled>
										<span class="glyphicon glyphicon-download-alt"></span>
									</button>

								</c:otherwise>
							</c:choose>
						</div>
						<div class="col-md-2">
							<b>Ten. Start Date:</b>
						</div>
						<div class="col-md-3">${training.tentativeStartDate }</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-2">
							<b>Trainer Name:</b>
						</div>
						<div class="col-md-3">${training.trainerName}</div>
						<div class="col-md-2">
							<b>Vendor Name:</b>
						</div>
						<div class="col-md-3">${training.vendorName}</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-2">
							<b>Trainer Profile:</b>
						</div>
						<div class="col-md-3">
							<c:choose>
								<c:when test="${not empty training.trainerProfile}">
									<a href="data:application/pdf;base64,${training.trainingFile}"
										download='${training.profileFileName}' title='${training.profileFileName}'>
										<button type="button" class="btn btn-default btn-sm">
											<span class="glyphicon glyphicon-download-alt"></span>
										</button>
									</a>
								</c:when>
								<c:otherwise>
									<button type="button" class="btn btn-default btn-sm" disabled>
										<span class="glyphicon glyphicon-download-alt"></span>
									</button>
								</c:otherwise>
							</c:choose>
							
						</div>
						<div class="col-md-2">
							<b>Trainer TOC:</b>
						</div>
						<div class="col-md-3">
							<c:choose>
								<c:when test="${not empty training.trainerTableOfContent}">
									<a href="data:application/pdf;base64,${training.trainerTableOfContent}"
										download='${training.trainerTocFileName}' title='${training.trainerTocFileName}'>
										<button type="button" class="btn btn-default btn-sm">
											<span class="glyphicon glyphicon-download-alt"></span>
										</button>
									</a>
								</c:when>
								<c:otherwise>
									<button type="button" class="btn btn-default btn-sm" disabled>
										<span class="glyphicon glyphicon-download-alt"></span>
									</button>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				<br>
			</div>
			<br>
		</div>

		<br> <a href="trainingDetails">
			<button type="button" class="btn btn-warning">
				<span class="glyphicon glyphicon-chevron-left"></span> Back
			</button>
		</a>

		<hr>
		<p class="form-title">Trainee Details</p>
		<br>
		<table id="myTable">
			<tr>
				<th class="col-md-1 col-xs-1">Sl No</th>
				<th class="col-md-2 col-xs-2">Trainee Name</th>
				<th class="col-md-2 col-xs-2">Employee ID</th>
				<th class="col-md-2 col-xs-2">Project</th>

			</tr>
			<c:choose>
				<c:when test="${not empty trainees}">
					<c:forEach var="trainees" items="${trainees}" varStatus="serial">
						<tr>
							<td class="col-md-1 col-xs-1">${serial.count}</td>
							<td class="col-md-2 col-xs-2 col-sm-2">${trainees.name}</td>
							<td class="col-md-2 col-xs-2 col-sm-2">${trainees.employeeId}</td>
							<td class="col-md-2 col-xs-2 col-sm-2">${trainees.project}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<td>
						<h3>No Data Found</h3>
					</td>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</body>
</html>