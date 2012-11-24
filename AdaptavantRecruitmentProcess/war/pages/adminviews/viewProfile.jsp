<%@page import="com.acti.recruitment.dto.ExperienceDetails"%>
<%@page import="com.acti.recruitment.dto.EducationDetails"%>
<%@page import="com.acti.recruitment.dto.UserDetails"%>
<%@ page language="java" 
	import="com.acti.recruitment.dto.UserDetails, java.util.List" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/allcss/popup.css">
<style type="text/css">
	div#viewprofile_container{
		z-index:0;
		position: absolute;
		top: 140px;
		left: 0px;
	}
</style>
<script type="text/javascript" src="/alljs/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="/alljs/popup.js"></script>
<script type="text/javascript">
/* 
   $(document).ready(function(){
      $(document).bind("contextmenu",function(e){
        return false;
      });
    });
   
   $(document).bind('selectstart', function(event) {
	    event.preventDefault();
	}); 
   */
   </script>
</head>
<body bgcolor="white">
<%@include file="../views/header.jsp" %>
<div id="viewprofile_container">

	<div id="backgroundPopup" style="position:fixed; height: 100%; width:100%; top:0px;right:0px;display: none;background-image:url(/images/white_overlay.png);z-index: 99;">

	</div>
			<%
				List<UserDetails> viewProfile=(List<UserDetails>)session.getAttribute("viewProfile");
				for(UserDetails userdetails:viewProfile){
		%>
	<div id="popup_box" style="z-index: 99999">	
			<h1>Mail Template</h1>
					<input type="hidden" value="<%=userdetails.getEmail()%>" id="email_Id" name="email_Id">
					<table>
						<tr><td><b>Mail to<%=userdetails.getFirstName() %></b></td></tr>
						<tr><td>subject</td><td><input type="text" size="65" id="subject" name="subject"></td></tr>
						<tr><td>Message</td><td><textarea rows="4" cols="50" id="message" name="message"></textarea></td></tr>
						<tr><td align="center"><input type="button" value="Send Mail" id="sendmailbutton"></td></tr>
					</table>
				<a id="popupBoxClose">Close</a>	
	</div>
			
				<table cellspacing="10">
						<tr>
							<td colspan="2"><img src="<%=userdetails.getPicture_Url()%>" height="140px" width="140px">
						</td>
						<tr>
							<td>Candidate Name</td><td><%=userdetails.getFirstName() %> <%=userdetails.getLastName()%></td>
						</tr>
						<tr>
							<td>Job Title</td><td><%=userdetails.getApplyDate()%></td>
						</tr>
						<tr>
							<td>Email Id</td><td><span id="hyp1"><%=userdetails.getEmail()%></span></td>
						</tr>
						<tr>
							<td>DOB</td><td><%=userdetails.getDob()%></td></tr>
						<tr>
							<td>Current Location</td><td><%=userdetails.getCurrent_Location()%></td>
						</tr>
						<tr>
							<td>Original Location</td><td><%=userdetails.getOriginal_Location()%></td>
						</tr>
						<tr>
							<td>Gender</td><td><%=userdetails.getGender()%></td>
						</tr>
						
						<tr>
							<td>Apply Date</td><td><%=userdetails.getApplyDate()%></td>
						</tr>
						<tr>
							<td>View in Facebook</td><td><a href="<%=userdetails.getFacebookLink()%>" target="new">Facebook</a></td></tr>
						<tr>
							<td>
								Education Details
							</td>
						
									<%
									if(userdetails.getEduDetails().isEmpty()){
										userdetails.getEduDetails();
										%>
											<td>Not Mentioned</td>
										<%
									}else{
										List<EducationDetails> educationDetails=(List<EducationDetails>)userdetails.getEduDetails();
										for(EducationDetails eduDetails:educationDetails){
										%>
										<td>
											<%=eduDetails.getSchool_Name() %>&nbsp;&nbsp; <%=eduDetails.getSchool_Type() %>,&nbsp;
										</td>
										<%
										}
									}
									%>
						
						</tr>
						<tr>
							<td>
								Experience Details
							</td>
									<%
									if(userdetails.getExpDetails().isEmpty()){
										userdetails.getExpDetails();
										%>
											<td>Not Mentioned</td>
										<%
									}else{
										List<ExperienceDetails> experienceDetails=(List<ExperienceDetails>)userdetails.getExpDetails();
										for(ExperienceDetails expDetails:experienceDetails){
										%>
										<td>
											<%=expDetails.getCompany_Name() %>&nbsp;&nbsp;<%=expDetails.getDesignation() %>&nbsp;&nbsp;<%=expDetails.getCompany_Location()%>,&nbsp;
										</td>
										<%
										}
									}
									%>
						
						</tr>
					
				</table>
			<%		
				}
			%>
	</div>
</body>
</html>