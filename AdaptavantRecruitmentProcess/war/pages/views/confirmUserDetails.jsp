<%@page import="com.acti.recruitment.dto.ExperienceDetails"%>
<%@page import="com.acti.recruitment.dto.EducationDetails"%>
<%@page import="com.acti.recruitment.dto.UserDetails"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/allcss/general.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/vader/jquery-ui.css" />
<script type="text/javascript" src="/alljs/jquery-1.8.2.min.js"></script>
<script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
 <script>
    $(function() {
        $( "#dob" ).datepicker({ showAnim: "fold" });
    });
</script>
</head>
<body bgcolor="#E0E0E0">
	<%@include file="header.jsp" %>
	<div class="bodyContainer">
		<div id="formContainer">
		<font color="green" size="5" style="font: bold;">We fetch the following details from Facebook</font><br><br>
			<%
			UserDetails userDetails=(UserDetails)session.getAttribute("userDetails");
			%>
			
			<form action="/conformUserDetails" method="get">
			
				<label class="lableToConform">First Name</label><input type="text" value="<%= userDetails.getFirstName()%>" id="firstName" name="firstName" class="allInputFields"><br>
				<label class="lableToConform">Last Name</label> <input type="text" value="<%= userDetails.getLastName()%>" id="lastName" name="lastName" class="allInputFields"><br>
				<label class="lableToConform">Contact Email</label> <input type="text" value="<%= userDetails.getEmail()%>" id="mail" name="mail" class="allInputFields"><br>
				<label class="lableToConform">DOB</label> <input type="text" value="<%= userDetails.getDob()%>" id="dob" name="dob" readonly="readonly" class="allInputFields"><br>
				<label class="lableToConform">Gender</label> <input type="text" value="<%= userDetails.getGender()%>" disabled="disabled" class="allInputFields"><br>
				<label class="lableToConform">Home Town</label> <input type="text" value="<%= userDetails.getOriginal_Location()%>" id="homeTown" name="homeTown" class="allInputFields"><br>
				<label class="lableToConform">Current Location</label> <input type="text" value="<%= userDetails.getCurrent_Location()%>" id="currentLocation" name="currentLocation" class="allInputFields"><br>
				<input type="submit"  value="Confirm" id="send_btn" name="confirm_Button"> 
			<!-- First Name:<input type="text" value="hi" id="firstName" name="firstName" class="allInputFields"> 
				<table align="center">
					<tr>
						<td>First Name</td><td> <input type="text" value="<%= userDetails.getFirstName()%>" id="firstName" name="firstName" class="allInputFields"></td>
					</tr>
					<tr>
						<td>Last Name</td><td> <input type="text" value="<%= userDetails.getLastName()%>" id="lastName" name="lastName" class="allInputFields"></td>
					</tr>
					<tr>
						<td>Contact Email</td><td> <input type="text" value="<%= userDetails.getEmail()%>" id="mail" name="mail" class="allInputFields"></td>
					</tr>
					<tr>
						<td>DOB</td><td> <input type="text" value="<%= userDetails.getDob()%>" id="dob" name="dob" readonly="readonly" class="allInputFields"></td>
					</tr>
					<tr>
						<td>Gender</td><td><input type="text" value="<%= userDetails.getGender()%>" disabled="disabled" class="allInputFields"></td>
					</tr>
					<tr>
						<td>Home Town</td><td> <input type="text" value="<%= userDetails.getOriginal_Location()%>" id="homeTown" name="homeTown" class="allInputFields"></td>
					</tr>
					<tr>
						<td>Current Location</td><td> <input type="text" value="<%= userDetails.getCurrent_Location()%>" id="currentLocation" name="currentLocation" class="allInputFields"></td>
					</tr>
					<tr>
					</tr>
					<tr><td colspan="2" align="center"><input type="submit"  value="Confirm" id="confirm_Button" name="confirm_Button" class="allInputFields"> </td></tr>
				</table>-->
				</form>
			</div>
		</div>
</body>
</html>