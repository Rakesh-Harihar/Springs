$(document).ready(function(){
	 

	$("#submit").click(function() {
		
		var topic=$("#topic").val();
		var nop=$("#nop").val(); 
		var startdate=$("#startdate").val();
		var x =true;
		
			
		 if(topic==null || topic==""){
			
			document.getElementById("spntopic").innerHTML=
				 "topic cannot be Empty";
			x= false;
			
		}

			
		 if(nop=="0" || nop==null || nop==""){
			
			document.getElementById("spnnop").innerHTML=
				 "No of people cannot be zero";
			
			x= false;
			
		}
		 if(startdate=="" || startdate==null){
				
				document.getElementById("spndate").innerHTML=
					 "Date cannot be Empty";
				
				return false;
				
			} else{
				
				 return x;
			 }
			
		});
	});