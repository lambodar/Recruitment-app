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
<body>
	<%@include file="header.jsp" %>
	<div class="bodyContainer">
		<font color="green" size="5" >We fetch the following details from Facebook</font><br><br>
		<div >
		<%
		UserDetails userDetails=(UserDetails)session.getAttribute("userDetails");
		%>
		
		<form action="/conformUserDetails" method="post">
			<table  class="allInputFields">
				<tr>
					<td>First Name</td><td> <input type="text" value="<%= userDetails.getFirstName()%>" id="firstName" name="firstName"></td>
				</tr>
				<tr>
					<td>Last Name</td><td> <input type="text" value="<%= userDetails.getLastName()%>" id="lastName" name="lastName"></td>
				</tr>
				<tr>
					<td>Contact Email</td><td> <input type="text" value="<%= userDetails.getEmail()%>" id="mail" name="mail"></td>
				</tr>
				<tr>
					<td>DOB</td><td> <input type="text" value="<%= userDetails.getDob()%>" id="dob" name="dob" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Gender</td><td><input type="text" value="<%= userDetails.getGender()%>" disabled="disabled" ></td>
				</tr>
				<tr>
					<td>Home Town</td><td> <input type="text" value="<%= userDetails.getOriginal_Location()%>" id="homeTown" name="homeTown"></td>
				</tr>
				<tr>
					<td>Current Location</td><td> <input type="text" value="<%= userDetails.getCurrent_Location()%>"  id="currentLocation" name="currentLocation"></td>
				</tr>
				<tr>
				</tr>
				<tr bgcolor="#C8EEDC">
					<td>Education Details</td><td> 
						<table border="1">
							<tr>
								<td><input type="text" value="" id="" name=""></td>
							</tr>
							<tr>
								<td><input type="text" value="" id="" name=""></td>
							</tr>
						</table>
						</td>
				</tr>
				<tr bgcolor="#C8EEDC">		
					<td>Experience Details</td><td> 
						<table border="1">
							<tr>
								<td><input type="text" value="" id="" name=""></td>
							</tr>
							<tr>
								<td><input type="text" value="" id="" name=""></td>
							</tr>
						</table>
						</td>
				</tr>
				<tr><td colspan="2" align="center"><input type="submit"  value="Confirm" id="confirm_Button" name="confirm_Button"> </td></tr>
			</table>
			</form>
			
			
		</div>
	</div>
</body>
</html>