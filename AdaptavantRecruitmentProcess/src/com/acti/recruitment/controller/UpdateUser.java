package com.acti.recruitment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acti.recruitment.dao.ConnectionProviderFactory;
import com.acti.recruitment.dto.UserDetails;
import com.acti.recruitment.serviceloader.DaoServiceLoader;

@Controller
@RequestMapping(value="/update")
public class UpdateUser {
	
	@RequestMapping(value="/updateJobTitle", method=RequestMethod.POST)
	public String updateJobTitle(HttpServletRequest request){
		HttpSession session=request.getSession();
		if(session!=null){
			String fbid=request.getParameter("fid");
			System.out.println("inside update::"+fbid);
			String jobTitle=request.getParameter("designation");
			System.out.println("inside update::"+jobTitle);
			String yearOfExperience=request.getParameter("experience");
			System.out.println("inside update::"+yearOfExperience);
			DaoServiceLoader serviceLoader=ConnectionProviderFactory.getConnectionProvider();
			System.out.println("test-1");
			List<UserDetails> userDetails=(List<UserDetails>)serviceLoader.getPojo(fbid);
			System.out.println("userDetails::"+userDetails);
			System.out.println("test-2");
			for (UserDetails updateUserDetails : userDetails) {
				System.out.println("test-3");
				updateUserDetails.setJodTitle(jobTitle);
				System.out.println("test-4");
				updateUserDetails.setYearOfExperience(yearOfExperience);
				System.out.println("test-5");
				serviceLoader.savePojo(updateUserDetails);
				System.out.println("job title updated successfullt");
			}
			return "views/afterGettingData";
		}
		return "views/serverError";
	}
	
}

























