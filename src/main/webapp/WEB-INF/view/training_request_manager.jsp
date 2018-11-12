<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width">
<title>Training Request Detail</title>
<link href="<c:url value="/css/vendor.css"/>" rel="stylesheet">
<script src="<c:url value="/js/request_view.js"/>"></script>
</head>
<body>
	<jsp:include page="header_menu.jsp"></jsp:include>

	<div class="container">
		<c:set var="role" value="${role }" />
		<div class="row">
		<div class="col-md-12 col-xs-8 col-sm-8 ">
		<p class="form-title">Training Request</p>
			<table id="myTable">
				<tr class="header">
					<th class="col-md-1 col-xs-2">Sl.No.</th>
					<th class="col-md-1 col-xs-2">Topic</th>
					<th class="col-md-2 col-xs-2">Category</th>
					<th class="col-md-1 col-xs-2">No of People</th>
					<th class="col-md-2 col-xs-2">Tentative start date</th>
					<th class="col-md-2 col-xs-2">Remark</th>
					<th class="col-md-1 col-xs-2">TOC</th>
					<th class="col-md-1 col-xs-2">Status</th>
					<th class="col-md-1 col-xs-2"></th>
				</tr>
				
			<c:choose>
				<c:when test="${not empty trainingDetail}">
					<c:forEach var="training" items="${trainingDetail}" varStatus="trainingCount">
						<tr>
							<td>${trainingCount.count}</td>
							<td>${training.topic}</td>
							<td>${training.category}</td>
							<td>${training.numberOfPeople}</td>
							<td>${training.tentativeStartDate}</td>
							<td><textarea disabled rows="3" cols="20">${training.remarks}</textarea></td>
							<td>
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
							</td>
							<td>
								 <c:if test="${training.status == 'Accepted' }">
									<p class="accepted">${training.status}</p>
								</c:if> 
								<c:if test="${training.status == 'Rejected' }">
									<p class="rejected">${training.status}</p>
								</c:if>
								<c:if test="${training.status == 'open' }">
									<p class="open">${training.status}</p>
								</c:if>
							</td>
							<td>
							<c:if test="${training.status != 'Rejected' }">
								<a href="traineeDetails?trainingId=${training.trainingId }">
									<button type="button" class="btn btn-outline-primary"> 
										<span class="glyphicon glyphicon-user"></span> Trainee
									</button>
								</a>
							</c:if>
							<c:if test="${training.status == 'Rejected' }">
								<button type="button" class="btn btn-outline-primary" disabled> 
									<span class="glyphicon glyphicon-user"></span> Trainee
								</button>
							</c:if>
											
							</td>
						</tr>
					 </c:forEach>
				</c:when>
					<c:otherwise>
						<h2>No Data Found in DB</h2>
					</c:otherwise>
			</c:choose>
			</table>
		</div>
		</div>
	</div>
</body>
</html>