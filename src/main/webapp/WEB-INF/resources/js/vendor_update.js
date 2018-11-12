$(document).ready(function(){
	 

	$("#update").click(function() {
		var vendorName=$("#vendorName").val();
		var address1=$("#address1").val();
		var address2=$("#address2").val(); //triggers on click of register
		var city=$("#city").val();
		var state=$("#state").val();
		var pincode=$("#pincode").val();
		var mobile=$("#mobile").val();
		var mobile=$("#email").val();
		var x =true;
		

		
		 if(vendorName=="" || vendorName==null){
			
			 document.getElementById("spnvendorName").innerHTML=
				 "Vendor Name cannot be Empty";
			x= false;
		} 
	
			
		 if(address1==null || address1==""){
			
			document.getElementById("spnaddress1").innerHTML=
				 "Address1 cannot be Empty";
			x= false;
			
		}

			
		 if(address2=="" || address2==null){
			
			document.getElementById("spnaddress2").innerHTML=
				 "Address2 cannot be Empty";
			
			x= false;
			
		}

			
		 if(city=="" || city==null){
			
			document.getElementById("spncity").innerHTML=
				 "City cannot be Empty";
			 x= false;
		}

		 
		 if(state=="" || state==null){
			document.getElementById("spnstate").innerHTML=
				 "State cannot be Empty";
			 x= false;
			
		}

		 if(mobile=="" || mobile==null){
			 
			 document.getElementById("spnmobile").innerHTML=
				 "Mobile cannot be Empty";
			 
			 x= false;
		 }
		 if(pincode=="" || pincode==null){
			
			document.getElementById("spnpincode").innerHTML=
				 "Pincode cannot be Empty";
			x=false; 
			
		}
		 if(email=="" || email==null){
				
				document.getElementById("spnemail").innerHTML=
					 "Email cannot be Empty";
				 x=false; 
				
			}
		 
		
		 else{
			
			 return x;
		 }
		
	});
});