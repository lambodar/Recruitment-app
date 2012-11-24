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
</head>
<body>
<%@include file="../views/header.jsp" %>

	<%
				UserDetails userDetails=(UserDetails)session.getAttribute("confirmUserDetails");
				out.println(userDetails);
	%>
	
	<table>
					
					<tr>
							<td>
								Education Details
							</td>
						
									<%
									if(userDetails.getEduDetails().isEmpty()){
										userDetails.getEduDetails();
										%>
											<td>Not Mentioned</td>
										<%
									}else{
										List<EducationDetails> educationDetails=(List<EducationDetails>)userDetails.getEduDetails();
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
									if(userDetails.getExpDetails().isEmpty()){
										userDetails.getExpDetails();
										%>
											<td>Not Mentioned</td>
										<%
									}else{
										List<ExperienceDetails> experienceDetails=(List<ExperienceDetails>)userDetails.getExpDetails();
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
</body>
</html>