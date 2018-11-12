$(document).ready(function(){
	 

	var validator = $("#trainer_registration").validate({
	    rules: {
	    	trainerName: "required",
	    	phone: {
	    		 required: true,
	             minlength: 10,
	             maxlength:10
	    	},
	    	
	    	subject: "required"
	        
	    },
	    messages: {
	    	trainerName: "Enter your trainer name",
	    	phone: {
	            required: "Enter your phone number",
	            minlength: jQuery.format("Enter at least {0} characters"),
	            maxlength: jQuery.format("Max 10 characters can be filled")
	        },
	    	subject: "Enter the Subject"
	        
	    }
	});

		
	});
