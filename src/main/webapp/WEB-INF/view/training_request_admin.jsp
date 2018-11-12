<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training Request Detail</title>
<link href="<c:url value="/css/vendor.css"/>" rel="stylesheet">
<script src="<c:url value="/js/status_validate.js"/>"></script>
</head>
<body>

	<jsp:include page="header_menu.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-12 col-xs-8 col-sm-8 ">
				<p class="form-title">Training Request</p>
				<br />
				<button id="all" class="btn btn-info col-md-2 col-md-offset-1" onclick="statusAll()">All</button>
				<button id="open" class="btn btn-info col-md-2 col-md-offset-1" onclick="statusOpen()">open</button>
				<button id="accepted" class="btn btn-info col-md-2 col-md-offset-1" onclick="statusAccepted()">Accepted</button>
				<button id="rejected" class="btn btn-info col-md-2 col-md-offset-1" onclick="statusRejected()">Rejected</button>
				<br />
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 col-xs-8 col-sm-8">
				<div class="search">
					<table id="myTable">
						<tr class="header">
							<th class="col-md-1 col-xs-2">Sl.No.</th>
							<th class="col-md-1 col-xs-2">Topic</th>
							<th class="col-md-1 col-xs-2">Category</th>
							<th class="col-md-2 col-xs-2">Requested By</th>
							<th class="col-md-1 col-xs-2">No of People</th>
							<th class="col-md-2 col-xs-2">Tentative Start Date</th>
							<th class="col-md-1 col-xs-2">TOC</th>
							<th class="col-md-1 col-xs-2">Remark</th>
							<th class="col-md-1 col-xs-2">Status</th>
							<th class="col-md-1 col-xs-2"></th>
						</tr>
						<c:choose>
							<c:when test="${not empty trainingList}">
								<c:forEach var="training" items="${trainingList}" varStatus="trainingCount">
									<tr>
										<td>${trainingCount.count}</td>
										<td>${training.topic}</td>
										<td>${training.category}</td>
										<td>${training.createdBy}</td>
										<td>${training.numberOfPeople}</td>
										<td>${training.tentativeStartDate}</td>
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
										<td><textarea disabled rows="3" cols="20">${training.remarks}</textarea></td>

										<c:if test="${training.status!='open' }">
											<td class="col-md-1 col-xs-2 col-sm-2"><c:if test="${training.status == 'Accepted' }">
													<p class="accepted">${training.status}</p>
												</c:if> <c:if test="${training.status == 'Rejected' }">
													<p class="rejected">${training.status}</p>
												</c:if></td>
										</c:if>
										<c:if test="${training.status=='open' }">
											<td class="col-md-1 col-xs-2 col-sm-2"><a
												href="assignTrainer?trainingId=${training.trainingId}">
												<button type="button" class="btn btn-outline-warning">
													<span class="glyphicon glyphicon-share"></span>&nbsp;${training.status}
												</button>
											</a></td>
										</c:if>

										<c:if test="${training.status!='Rejected' }">
											<td><a href="traineeDetails?trainingId=${training.trainingId }">
													<button type="button" class="btn btn-outline-primary">
														<span class="glyphicon glyphicon-user"></span> Add Trainee
													</button>
											</a></td>
										</c:if>
										<c:if test="${training.status=='Rejected' }">
											<td>
												<button type="button" class="btn btn-outline-primary" disabled>
													<span class="glyphicon glyphicon-user"></span> Add Trainee
												</button>
											</td>
										</c:if>
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
	</div>
</body>
</html>