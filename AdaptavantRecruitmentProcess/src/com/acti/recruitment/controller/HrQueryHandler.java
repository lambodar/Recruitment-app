package com.acti.recruitment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acti.recruitment.dao.ConnectionProviderFactory;
import com.acti.recruitment.dto.UserDetails;
import com.acti.recruitment.serviceloader.DaoServiceLoader;

@Controller
@RequestMapping(value="/hrquery")
public class HrQueryHandler {
	
	@RequestMapping(value="/hrquery")
	public void homeController(HttpServletResponse response) throws IOException{
		response.sendRedirect("hrquery/absview");
	}
	//Query all candidate
	@RequestMapping(value="/absview")
	public String abstractViewer(HttpServletRequest request){
		HttpSession session=request.getSession(true);
		DaoServiceLoader daoServiceloader=ConnectionProviderFactory.getConnectionProvider();
		List<UserDetails> allUserAbstractlist=(List<UserDetails>)daoServiceloader.getAll();
		session.setAttribute("listOfAllUsers", allUserAbstractlist);
		System.out.println(allUserAbstractlist);
		for(UserDetails userDetailsAbstract:allUserAbstractlist ){
			System.out.println(userDetailsAbstract.getFirstName());
			System.out.println(userDetailsAbstract.getLastName());
			System.out.println(userDetailsAbstract.getDob());
			System.out.println(userDetailsAbstract.getCurrent_Location());
			System.out.println(userDetailsAbstract.getGender());
			System.out.println(userDetailsAbstract.getApplyDate());
		}
		return "adminviews/absview";
	}
	
	//Query profile using FaceBookId(primary key)
	@RequestMapping(value="/viewProfile")
	public String viewProfile(HttpServletRequest request){
		String fId=request.getParameter("fid");
		System.out.println("fid from view profile::"+fId);
		HttpSession session=request.getSession(true);
		
		DaoServiceLoader serviceLoader=ConnectionProviderFactory.getConnectionProvider();
		List<UserDetails> singleUserDetails=(List<UserDetails>)serviceLoader.getPojo(fId);
		session.setAttribute("viewProfile", singleUserDetails);
		System.out.println("From View Orifile::S"+singleUserDetails);
		return "adminviews/viewProfile";
	}
	
	//Query by job title
	public String viewByTitle(HttpServletRequest request){
		String jobTitle=request.getParameter("jobTitle");
		HttpSession session=request.getSession(true);
		DaoServiceLoader daoServiceloader=ConnectionProviderFactory.getConnectionProvider();
		List<UserDetails> userDetails=(List<UserDetails>)daoServiceloader.getPojoByField("jodTitle",jobTitle);
		session.setAttribute("listOfAllUsers", userDetails);
		return "adminviews/absview";
	}
}
































