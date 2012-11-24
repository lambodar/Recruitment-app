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

</style>
</head>
<body>
<%@include file="header.jsp" %>
		<div id="header1">
			<font color="green" size="5" >Select in order to complete the request</font><br><br>
			<form action="/update/updateJobTitle" method="post">
					<input type="hidden" value="<%=request.getAttribute("fbid")%>" name="fid">
					
					<b>Job Title</b> &nbsp;&nbsp; <select id="designation" name="designation" class="allInputFields">
						<option value="Developers">Developers</option>
						<option value="Designers">Designers</option>
						<option value="Testing">Testing</option>
						<option value="Networking">Networking</option>
						<option value="Project Mangers">Project Mangers</option>
						<option value="Client Services">Client Services</option>
						<option value="Content Writer">Content Writer</option>
					</select>
					<br><br>
					
					<b>Experience</b><select id="experience" name="experience" class="allInputFields">
						<option value="Less than 1 year">Less than 1 year</option>
						<option value="Less than 1 year">Internship</option>
						<option value="1 year to 2 year">1 year to 2 year</option>
						<option value="2 years to 4 years">2 years to 4 years</option>
						<option value="5 years to 8 years">5 years to 8 years</option>
						<option value="8+ years">8+ years</option>
					</select><br><br>
					<div id="file_browse_wrapper">
						<input type="file" name="file" id="file_browse">
						<span>Browser</span>
					</div>
					<span id="filemessage" class="fl" style="top: 260px;left: 110px;position: absolute;">Upload Your Resume</span>
					<br><br><br><br>
					 <input type="submit" value="submit" id="send_btn">
			</form>	
		</div>
</body>
</html>