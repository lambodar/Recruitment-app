		
	/************************** pop-up*/
	function unloadPopupBox() {
		$('#popup_box').fadeOut("slow");
		$("#container").css({
			"opacity": "1"  
		});
		$('#backgroundPopup').fadeOut("slow");
	}	
	
	function loadPopupBox() {
		
		$('#popup_box').fadeIn("slow");
		$("#container").css({
			"opacity": "0.3"  
		}); 		
	}	
	
	/************************** functionality*/

	$(document).ready( function() {
		
		$('#hyp1').click( function() {	
			loadPopupBox(); 
			$('#backgroundPopup').fadeIn("slow");
			
		});


		$('#popupBoxClose').click( function() {			
			unloadPopupBox();
		});

	});
	/************************** send ajax request from pop-up to hrMail() controller*/
	 $(document).ready(function(){
		$('#sendmailbutton').click(function(){
			   var emailId=$('#email_Id').val();
			   var subject=$('#subject').val();
			   var Message=$('#message').val();
			   console.info(emailId);
			   console.info(subject);
			   console.info(Message);
			   var mail_Details=new Object();
			   mail_Details.email_Id=emailId;
			   mail_Details.subject=subject;
			   mail_Details.message=Message;
			   
			   console.info(mail_Details +" Before");
			   var dataString=JSON.stringify(mail_Details);
			   
			   console.info(dataString + " JSON");
			   
			   $.ajax({
				   type: "post",
				   url: "/mail/sendMail",
				   data: {dataString: dataString},
			   	   success:function(response_Data)
			   		{
						   console.info(response_Data);
						   unloadPopupBox();	
			   		} 
			   });
		   });
	  });
	/**************************/