$(document).ready(function(){
	 

	$("#traineevalidation").click(function() {
		var name =$("#name").val();
		var employeeId=$("#employeeId").val();
		var project=$("#project").val(); //triggers on click of register
		var x =true;
		

		
		 if(name=="" ||  name==null){
			
			 document.getElementById("spnname").innerHTML=
				 " Name cannot be Empty";
			x= false;
		} 
	
			
		 if(employeeId=="0"||employeeId==null || employeeId==""){
			
			document.getElementById("spnid").innerHTML=
				 "ID cannot be Empty";
			x= false;
			
		}

			
		 if(project=="" || project==null){
			
			document.getElementById("spnproject").innerHTML=
				 "Project cannot be Empty";
			
			 return false; 
			
		 }
		 
		
		 else{
			
			 return x;
		 }
		
	});
});