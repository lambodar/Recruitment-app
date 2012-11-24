
$(function() {
        $( ".datepicker" ).datepicker({ showAnim: "fold" });
    });

$(document).ready(function(){
	alert("hi");
	console.info("inside ");
	$(".this_select").live("click",function(){
		alert("hello");
		var searchBy = $(this).val();
		console.info(searchBy+" ");
		if(searchBy=="jobTitle"){
			$('#applydate_Datepicker_spam').hide();
			$('#sex').hide();
			$('#experienceDetails').hide();
			$('#current_Location').hide();
			$('#dob_Datepicker_span').hide();
			$('#jobtitleDetails').show();
		}else if(searchBy=="all"){
			window.location.href="/hrquery/absview";
			$('#applydate_Datepicker_spam').hide();
			$('#sex').hide();
			$('#experienceDetails').hide();
			$('#current_Location').hide();
			$('#dob_Datepicker_span').hide();
			$('#jobtitleDetails').hide();
		}else if(searchBy=="applyDate"){
			$('#experienceDetails').hide();
			$('#sex').hide();
			$('#current_Location').hide();
			$('#dob_Datepicker_span').hide();
			$('#jobtitleDetails').hide();
			$('#applydate_Datepicker_spam').show();
		}else if(searchBy=="experience"){
			$('#sex').hide();
			$('#applydate_Datepicker_spam').hide();
			$('#current_Location').hide();
			$('#dob_Datepicker_span').hide();
			$('#jobtitleDetails').hide();
			$('#experienceDetails').show();
		}else if(searchBy=="currentLocation"){
			$('#sex').hide();
			$('#applydate_Datepicker_spam').hide();
			$('#experienceDetails').hide();
			$('#dob_Datepicker_span').hide();
			$('#jobtitleDetails').hide();
			$('#current_Location').show();
		}else if(searchBy=="dob"){
			$('#sex').hide();
			$('#applydate_Datepicker_spam').hide();
			$('#experienceDetails').hide();
			$('#current_Location').hide();
			$('#jobtitleDetails').hide();
			$('#dob_Datepicker_span').show();
		}
		else if(searchBy=="sex"){
			$('#sex').show();
			$('#applydate_Datepicker_spam').hide();
			$('#experienceDetails').hide();
			$('#current_Location').hide();
			$('#jobtitleDetails').hide();
			$('#dob_Datepicker_span').hide();
		}
		
	});
	
	/*$("select").hide();
		$("#searchby").show();
		$('#searchby').change(function(){
			console.log("change");
			var searchBy=$('#searchby').val();
			console.log(searchBy);
			
		});*/
	});













