<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training Request</title>
</head>
<body>

<jsp:include page="header_menu.jsp"></jsp:include>

<div class="container">

  <div class="row">
    <div class="hidden-sm hidden-xs col-md-4"> </div>
    <div class="col-sm-12 col-md-4">
    <p class="form-title">Training Request</p>
   
   		<form:form action="submitRequest" method="POST" modelAttribute="training" enctype="multipart/form-data" autocomplete="off" >
          	<div class="row">
				<div class="col-md-4 col-xs-12 ">Category</div>
					<div class="col-md-4 col-xs-12 ">
						<form:select path="category" id="category">
							<form:option value="Select category"/> 
							<c:forEach items="${categoryList}" var="categoryList">
										<option value="${categoryList.categoryId}">${categoryList.categoryName}</option>
									</c:forEach>
							
							
						</form:select>
					</div>
					</div>
					<div id="spncategory" style="color:red;text-align:center"></div><br/>
   	
   					<div class="row">
						<div class="col-md-4 col-xs-12">Topic/Description:</div>
						<div class="col-md-8 col-xs-12"><form:input class="bord" path="topic" id="topic"/><br><form:errors style="color:red;font-size:12px;" path="startDate"  /></div>
					</div>
					<div id="spntopic"style="color:red;text-align:center"></div>
					<br/>
						<div class="row">
						<div class="col-md-4 col-xs-12">Number of people :</div>
						<div class="col-md-4 col-xs-12"><form:input class="bord" type="number" min="0" path="numberOfPeople" id="nop"/></div>
					</div><div id="spnnop" style="color:red;text-align:center"></div><br/>
					
					<div class="row">
						<div class="col-md-4 col-xs-12">Tentative start date:</div>
						<div class="col-md-8 col-xs-12"><form:input type="text"  path="tentativeStartDate" class="input1" id="startdate" /><br><form:errors style="color:red;font-size:12px;" path="startDate"  /></div>
						
					</div><div id="spndate"style="color:red;text-align:center"></div><br/>
					<div class="row">
						<div class="col-md-4 col-xs-12">Training Toc:</div>
						<div class="col-md-8 col-xs-12">
							<div>
								<div width="35%">
									<strong>File to upload</strong>
								</div>
								<div width="65%">
									<input type="file" name="trainingToc" />
								</div>
							</div>
						</div>
					</div><br>
						<div class="row">
						<div class="col-md-4 col-xs-12">Remarks :</div>
						<div class="col-md-4 col-xs-12"><form:textarea rows="5" cols="30" class="bord" path="remarks"/></div>
					</div><br/>
				
						
					
					<div class="row">
						<div class="col-md-4 col-xs-12"></div>
						<div class="col-md-4 col-xs-12">
							<input Class="btn btn-primary btn-md btn-size" type="submit" value="Submit" id="submit" />
						</div>
						<div class="col-md-4 col-xs-12">
							<input Class="btn btn-warning btn-md btn-size" type="reset" value="Reset" />
						</div>
					</div>

					<script
						src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
					<script
						src="//cdnjs.cloudflare.com/ajax/libs/validate.js/0.12.0/validate.min.js"></script>
					<script
						src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
					<link
						href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/themes/base/jquery-ui.css"
						rel="stylesheet" />
					<script type="text/javascript"
						src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
					<script type="text/javascript"
						src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/jquery-ui.min.js"></script>

					<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
					<script src="js/request_validation.js"></script>

					<script type="text/javascript">
						$(document).ready(function() {
							
							$('#startdate').datepicker({
								
								changeYear: true,
								changeMonth: true,
							    minDate:0,
								dateFormat : 'dd-mm-yy',
							    yearRange: "-100:+20"
							});
						});
					</script>


					<div class="col-md-4  col-xs-4 hidden-xs hidden-sm"></div>


				</form:form>
    
  </div>
</div>
    </div>
</body>
</html>
