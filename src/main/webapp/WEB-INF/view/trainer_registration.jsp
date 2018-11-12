<%@page import="com.valtech.trainingprocess.trainer.model.Trainer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainer Details</title>

</head>
<body>
	<jsp:include page="header_menu.jsp"></jsp:include>
	<script src="js/trainer_registration_validation.js"></script>
	
	<div class="container">
		<div class="row">
			<div class=" hidden-sm hidden-xs col-md-4"></div>
			<div class="col-md-4 col-sm-12">
				<c:if test="${trainer.trainerId != 0}">
					<p class="form-title">Trainer Modification</p>
				</c:if>
				<c:if test="${trainer.trainerId == 0 }">
					<p class="form-title">Trainer Registration</p>
				</c:if>

				<c:if test="${not empty errorMessage }">
					<div class="row">
						<div class="col-md-12 col-xs-12">
							<p class="error">
								<b>${errorMessage }</b>
							</p>
						</div>
					</div>
				</c:if>
				<form:form id="trainer_registration" action="submitTrainer" modelAttribute="trainer" enctype="multipart/form-data" autocomplete="off">

					<div class="row">
						<div class="col-md-4 col-xs-12">Vendor Name</div>
						<div class="col-md-8 col-xs-12">
							<c:if test="${trainer.trainerId != 0}">
								<b>${trainer.vendorName}</b>
							</c:if>
							<c:if test="${trainer.trainerId == 0 }">
								<form:select path="vendorId">
									<c:forEach items="${vendorList}" var="vendor">
										<option value="${vendor.vendorId}">${vendor.vendorName}</option>
									</c:forEach>
								</form:select>
							</c:if>
						</div>
					</div>
					<br />
					<form:input type="hidden" path="trainerId" />
					<form:input type="hidden" path="vendorId" />

					<div class="row">
						<div class="col-md-4 col-xs-12">Trainer Name</div>
						<div class="col-md-8 col-xs-12">
							<form:input path="trainerName" id="trainerName" />
							<br />
							
						</div>
					</div>
					
					<br />
					<div class="row">
						<div class="col-md-4 col-xs-12">Phone</div>
						<div class="col-md-8 col-xs-12">
							<form:input path="phone" id="phone" />
							<br />
							<%-- <form:errors class="error" path="phone" /> --%>
					<!-- <span id="spnphone" style="color: red; text-align: center"></span> -->
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-md-4 col-xs-12">Subject</div>
						<div class="col-md-8 col-xs-12">
							<form:input path="subject" id="subject" />
							<br />
							<%-- <form:errors class="error" path="subject" /> --%>
							<!-- <span id="spnsubject" style="color: red; text-align: center"></span> -->
						</div>
					</div>
					<br />

					<div class="row">
						<div class="col-md-4 col-xs-12">address1</div>
						<div class="col-md-8 col-xs-12">
							<form:input path="address1" />
							<br />

						</div>
					</div>
					<br />

					<div class="row">
						<div class="col-md-4 col-xs-12">address2</div>
						<div class="col-md-8 col-xs-12">
							<form:input path="address2" />
							<br />

						</div>
					</div>
					<br />

					<div class="row">
						<div class="col-md-4 col-xs-12">City</div>
						<div class="col-md-8 col-xs-12">
							<form:input path="city" />

						</div>
					</div>
					<br />

					<div class="row">
						<div class="col-md-4 col-xs-12">State</div>
						<div class="col-md-8 col-xs-12">
							<form:input path="state" />

						</div>
					</div>
					<br />

					<div class="row">
						<div class="col-md-4 col-xs-12">Pincode</div>
						<div class="col-md-8 col-xs-12">
							<form:input path="pincode" id="pincode" />
							<br />
							<%-- 		<form:errors class="error" path="pincode" /> --%>
						</div>
					</div>
					<div id="spnpincode" style="color: red; text-align: center"></div>
					<br />

					<div class="row">
						<div class="col-md-4 col-xs-12">Table of contents</div>
						<div class="col-md-8 col-xs-12">
							<div width="35%">
								<strong>File to upload</strong>
							</div>
							<div width="65%">
								<form:input type="file" name="toc" path="toc" />
							</div>
						</div>
					</div>
					<br />

					<div class="row">
						<div class="col-md-4 col-xs-12">Profile</div>
						<div class="col-md-8 col-xs-12">
							<div>
								<div width="35%">
									<strong>File to upload</strong>
								</div>
								<div width="65%">
									<form:input type="file" name="profile" path="profile" />
								</div>
							</div>
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-md-4 col-xs-12"></div>
						<c:if test="${trainer.trainerId!=0}">
							<div class="col-md-4 col-xs-12">

								<a href="viewTrainerList?vendorId=${trainer.vendorId}" Class="btn btn-warning btn-md btn-size">Back</a>

							</div>
							<div class="col-md-4 col-xs-12">
								<input Class="btn btn-primary btn-md btn-size" type="submit" value="Update"
									id="trainerUpdate" />
							</div>
						</c:if>
						<c:if test="${trainer.trainerId == 0}">
							<div class="col-md-4 col-xs-12">
								<input Class="btn btn-primary btn-md btn-size" type="submit" value="Submit"
									id="trainersubmit" />
							</div>
							<div class="col-md-4 col-xs-12">
								<input Class="btn btn-warning btn-md btn-size" type="reset" value="Reset" />
							</div>
						</c:if>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<br>
	<br>
</body>
</html>
