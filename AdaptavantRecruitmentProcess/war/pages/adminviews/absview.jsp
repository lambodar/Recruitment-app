<%@ page language="java" import="com.acti.recruitment.dto.UserDetails, java.util.List" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	a{
		text-decoration : none;
	}
	a:link {
		color: black;
		font-weight: bold;
	}
	a:visited {
		color:black;
		font-weight: bold;
	}
	a:hover{
		color: black;
		font: bold;
	}
	div#container{
		position: absolute;
		top: 200px;
		left: 0px;
	}
</style>
<script type="text/javascript" src="../alljs/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('input[value="all"]').click(function(){
		if($('input[value="all"]').attr('checked'))
			$('input:checkbox').attr('checked','checked');
		else
			$('input:checkbox').removeAttr('checked');
		});
});

</script>

</head>
<body>
<%@include file="../views/header.jsp" %>
<div id="container">
<table cellspacing="10">
<tr>
	<th><input type="checkbox" name="checkall" value="all"></th>
	<th>Name</th>
	<th>Job Title</th>
	<th>Location</th>
	<th>DOB</th>
	<th>Gender</th>
	<th>ApplyDate</th>
	<th>Year of exp</th>
</tr>
<%
List<UserDetails> allUserAbstractlist=(List<UserDetails>)session.getAttribute("listOfAllUsers");
for(UserDetails userDetailsAbstract:allUserAbstractlist ){
	%>
	
	
	<tr>
	
		<td id=""><input type="checkbox" name="checkone" value="single"></td>
		<td><a href="/hrquery/viewProfile?fid=<%=userDetailsAbstract.getFacebookId()%>" ><%=userDetailsAbstract.getFirstName()%> <%=userDetailsAbstract.getLastName()%> </a></td>
		<td><%=userDetailsAbstract.getJodTitle()%></td>
		<td><%=userDetailsAbstract.getCurrent_Location()%></td>
		<td><%=userDetailsAbstract.getDob() %></td>
		<td><%=userDetailsAbstract.getGender()%></td>
		<td><%=userDetailsAbstract.getApplyDate()%></td>
		<td><%=userDetailsAbstract.getYearOfExperience()%></td>	
	
	 </tr>
	
	<%
}
%>
</table>
</div>
</body>
</html>