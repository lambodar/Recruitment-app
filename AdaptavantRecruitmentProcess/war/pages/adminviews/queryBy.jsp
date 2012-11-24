<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

div#header1{
	position:absolute;
	top:400px;
	left:430px;
}
.defaultOption{
	color: rgba(255,0,0,0.5);

}
</style>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
    <script type="text/javascript" src="/alljs/jquery-1.8.2.min.js"></script>
    <script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
    <script type="text/javascript" src="/alljs/hr.js"></script>
    
<!-- <script type="text/javascript">
 $(document).ready(function(){
	$("select").click(function(){
		$("option[value='']",this).remove();
	}) 
});
</script> -->
    
</head>
<body>
	<%@include file="../views/header.jsp" %>
	<div id="header1">
		<font color="green" size="5">HR widgets for Adaptavant recruitment process</font><br><br>
		<b>Search by</b> &nbsp;&nbsp;
				 	<select id="searchby" name="searchby" >
				 		<option value="" selected="selected" class="defaultOption this_select">Select category</option> 
						<option value="all" class="this_select">All</option>
						<option value="jobTitle" class="this_select">Job Title</option>
						<option value="applyDate" class="this_select">Apply Date</option>
						<option value="experience" class="this_select">Experience</option>
						<option value="dob" class="this_select">BOD</option>
						<option value="currentLocation" class="this_select">current Location</option>
						<option value="sex" class="this_select">Sex</option>
					</select>
							<!--for job title-->
							<select id="jobtitleDetails" name="jobtitleDetails" style="display: none;">
								<option value="" selected="selected" class="defaultOption">Select Title</option>
								<option value="Developers">Developers</option>
								<option value="Less than 1 year">Internship</option>
								<option value="Designers">Designers</option>
								<option value="Testing">Testing</option>
								<option value="Networking">Networking</option>
								<option value="Project Mangers">Project Mangers</option>
								<option value="Client Services">Client Services</option>
								<option value="Content Writer">Content Writer</option>
							</select>
							
							<!--for Apply Date-->
							<span id="applydate_Datepicker_spam" style="display: none;">
								<input type="text" name="applydate_Datepicker" id="applydate_Datepicker1" class="datepicker" readonly="readonly">TO
								<input type="text" name="applydate_Datepicker" id="applydate_Datepicker2" class="datepicker" readonly="readonly">
							</span>
							<!--for experience level-->
							<select id="experienceDetails" name="experienceDetails"  style="display: none;">
								<option value="" selected="selected" class="defaultOption">Select experience</option>
								<option value="entry level">Entry Level</option>
								<option value="Less than 1 year">Less than 1 year</option>
								<option value="1 year to 2 year">1 year to 2 year</option>
								<option value="2 years to 4 years">2 years to 4 years</option>
								<option value="5 years to 8 years">5 years to 8 years</option>
								<option value="8+ years">8+ years</option>
							</select>
							<!-- for location-->
							
								<input type="text" name="current_Location" id="current_Location"  style="display: none;"/>
							
							
							<!-- for dob-->
							<span id="dob_Datepicker_span" style="display: none;">
								<input type="text" name="dob_Datepicker" id="dob_Datepicker1" class="datepicker"/>TO
								<input type="text" name="dob_Datepicker" id="dob_Datepicker2" class="datepicker"/>
							</span>
							<!-- for gender-->
							<select id="sex" name="sex" style="display: none;">
								<option value="" selected="selected" class="defaultOption">Select Gender</option>
								<option value="male">Male</option>
								<option value="female">Female</option>
							</select>	
	</div>
</body>
</html>