<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Trainer</title>
</head>
<body>
<jsp:include page="header_menu.jsp"></jsp:include>
	<div class="row">
		<div class="col-md-offset-2 col-md-8 col-xs-offset-2 col-xs-8">
			<p class="form-title">Assign Trainer</p>
			<c:if test="${not empty errorMessage }">
					<div class="row">
						<div class="col-md-12 col-xs-12">
							<p class="error">
								<b>${errorMessage }</b>
							</p>
						</div>
					</div>
				</c:if>
			<br/>
		</div>
		<form:form id="assign_trainer"
			action="updateTraining?trainingId=${trainingId}"
			method="POST" modelAttribute="trainingDetail" autocomplete="off">
			<div class="container">
				<div class="row" style="border: 2;">
					<div class="col-md-4 col-xs-4"></div>
					<div class="col-md-4 col-xs-4">
						<div class="row">
							<div class="col-md-4 col-xs-12">Vendor name</div>

							<div class="col-md-8 col-xs-12">
							 	<form:select onchange="fun()" id="vendor" path="vendorId">
							 	<form:option value="0">Select Vendor</form:option>
									<c:forEach items="${vendorList}" var="vendor">
										<option value="${vendor.vendorId}">${vendor.vendorName}</option>
									</c:forEach>
								</form:select> 
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-4 col-xs-12">Trainer name</div>
							<div class="col-md-8 col-xs-4">
								<form:select id="trainer" path="trainerId">								
								</form:select> 
							</div>
						</div>
						<br />
						<div class="row">						
							<div class="col-md-4 col-xs-12">Start Date</div>
							<div class="col-md-2 col-xs-12">
								<form:input cssClass="col-md-offset-2 col-xs-offset-2 bord"
									type="text" path="startDate" id="startdate" />
								<form:errors style="color:red" path="startDate" />
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-4 col-xs-12">End Date</div>
							<div class="col-md-2 col-xs-12">
								<form:input cssClass="col-md-offset-2 col-xs-offset-2 bord"
									type="text" path="endDate" id="enddate" />
								<form:errors style="color:red" path="endDate" />
							</div>
						</div>
						<br />										
						<div class="row">
							<div class="col-md-4 col-xs-12">Status</div>
							<div class="col-md-8 col-xs-12">
								<form:select path="status">
								
									<form:option value="Select status" />
									<c:forEach items="${statusList}" var="status">
										<c:if test="${status.statusId !=1 }">
											<option value="${status.statusId}">${status.status}</option>
										</c:if>
									</c:forEach>									
								</form:select>
								</div>						
							</div>
						<br />
					<div class="col-md-4 col-xs-12">
						<input Class="btn btn-primary btn-md btn-size" type="submit" value="Submit" />
					</div>
					<div class="col-md-4 col-xs-12">
						<input Class="btn btn-warning btn-md btn-size" type="reset" value="Reset" />
					</div>
					</div>
				</div>
				</div>	
		</form:form>
	</div>	
	<script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
			 <script src="//cdnjs.cloudflare.com/ajax/libs/validate.js/0.12.0/validate.min.js"></script>
			 <script src ="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
			 <link href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/themes/base/jquery-ui.css" rel="stylesheet" />
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/jquery-ui.min.js"></script>
			 <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script type="text/javascript">
		function fun() {
			var option;
			var select = document.getElementById("trainer");
			for (var i = select.length - 1 ; i >= 0 ; i--)
				     select.remove(0);
			var value = $('#vendor option:selected').attr('value');
			var trainers=[];
			var trainerId=[];		
			$.ajax({
				        url: "${pageContext.request.contextPath}/getvendorstrainer?vendorId="+value,
				        method: 'GET',
				        datatype: 'json',
				        success : function(data) {
				        	for(var i=0;i<data.length;i++){
				        		trainers[i]=data[i].trainerName;
				        		trainerId[i]=data[i].trainerId;
				        	}
							for(var i=0;i<trainers.length;i++){
								var att = document.createAttribute("value");
								att.value = trainerId[i];
								option = document.createElement("option");
								option.setAttributeNode(att);
								option.text = trainers[i];
								select.add(option, select[0]);
							}
						},
						error : function(data) {	
						}
			});		
		}		
		 $(document).ready(function () {
		        $('#startdate').datepicker({ 
		        	
		        	changeYear: true,
					changeMonth: true,
				    minDate:0,
					dateFormat : 'dd-mm-yy',
				    yearRange: "-100:+20",
				    onSelect: function(selected) {
				        $('#enddate').datepicker("option", "minDate",  $("#startdate").datepicker('getDate') )
				     }
		        });
		    });
		 $(document).ready(function () {
		        $('#enddate').datepicker({ 
		        	changeYear: true,
					changeMonth: true,
				    minDate:null,
					dateFormat : 'dd-mm-yy',
				    yearRange: "-100:+20"
		        });
		    });
	</script>
</body>
</html>