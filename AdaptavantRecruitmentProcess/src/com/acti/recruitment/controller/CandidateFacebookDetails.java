package com.acti.recruitment.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acti.recruitment.dao.ConnectionProviderFactory;
import com.acti.recruitment.dto.EducationDetails;
import com.acti.recruitment.dto.ExperienceDetails;
import com.acti.recruitment.dto.UserDetails;
import com.acti.recruitment.serviceloader.DaoServiceLoader;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

//import com.adaptavant.dto.UserDetails;
@Controller
@RequestMapping(value="/")
public class CandidateFacebookDetails {
	
	@RequestMapping(value="/")
	public String homeController(){
		return "views/welcome";
	}
	@SuppressWarnings("unused")
	@RequestMapping(value="/sendfb",method=RequestMethod.GET)
	public void rediredttoFacebook(HttpServletRequest request,HttpServletResponse response) throws IOException{
		HttpSession session=request.getSession(true);
		String redirest_Facebool="https://www.facebook.com/dialog/oauth/?" +
				"client_id=381404248602694&" +
				"redirect_uri=http://adaptiverecruit.appspot.com/gettingCode&" +
				"response_type=code&" +
				"state=Adaptavant_recruitment_process&" +
				"scope=user_work_history,user_photos,user_location,user_hometown,user_birthday,email,user_education_history";
		response.sendRedirect(redirest_Facebool);
	}
	@RequestMapping(value="/gettingCode",method=RequestMethod.GET)
	public String postProcessingfb(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession(false);
		UserDetails userDetails=new UserDetails();
		if(session!=null){
			
			List<EducationDetails> educationDetailsLsit=new ArrayList<EducationDetails>();
			List<ExperienceDetails> experienceDetailsList=new ArrayList<ExperienceDetails>();
			//get the DaoserviceProvider
			String fb_code=request.getParameter("code");
			String accessToken="";
			System.out.println("code::"+fb_code);
			//"redirect_uri=http://localhost:8888/gettingCode&" +
			//http://adaptiverecruit.appspot.com/gettingCode
			try {
				String inputLine;
				String url_For_AccesToken= "https://graph.facebook.com/oauth/access_token?client_id=381404248602694&" +
            		"redirect_uri=http://adaptiverecruit.appspot.com/gettingCode&" +
            		"client_secret=ebc40a739e49db0ed922e30a494ceb70&" +
            		"code="+fb_code;
				URL url=new URL(url_For_AccesToken);
				HttpURLConnection connection=(HttpURLConnection)url.openConnection();
				BufferedReader bufferReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuffer stringBuffer=new StringBuffer();
				while ((inputLine=bufferReader.readLine())!=null)
					stringBuffer=stringBuffer.append(inputLine+"\n");
				bufferReader.close();
				accessToken=stringBuffer.toString();
				}catch (Exception token_Exception) {
					token_Exception.printStackTrace();
					System.out.println("problem in getting acces token");
					return "views/serverError";
					}
			System.out.println("acces token::"+accessToken);
			String graph = "";
			try{
				String graph_Inputline;
				String graph_requestURL="https://graph.facebook.com/me?fields=id,name,birthday,email,first_name,last_name,link,gender,work,picture.width(531).height(414).type(normal),education,location,hometown&"+accessToken;
				URL graph_URL=new URL(graph_requestURL);
				URLConnection graph_urlConnection=graph_URL.openConnection();
				BufferedReader graph_bufferReader=new BufferedReader(new InputStreamReader(graph_urlConnection.getInputStream()));
				while ((graph_Inputline = graph_bufferReader.readLine()) != null)
					graph+=graph_Inputline;
					graph_bufferReader.close();
					}catch (Exception graph_Exception) {
						System.out.println("problem in accessing grap api");
						return "views/serverError";
						}
			System.out.println("json::"+graph);
			try {
				JSONObject json1=new JSONObject(graph);
	        	System.out.println("==basic details==");
	        	
	        	System.out.println(json1.getString("id"));
	        	userDetails.setFacebookId(json1.getString("id"));
	        	System.out.println(json1.getString("name"));
				
				System.out.println(json1.getString("first_name"));
				userDetails.setFirstName(json1.getString("first_name"));
				
				System.out.println(json1.getString("last_name"));
				userDetails.setLastName(json1.getString("last_name"));
				
				System.out.println(json1.getString("link"));
				userDetails.setFacebookLink(json1.getString("link"));
				
				System.out.println(json1.getString("email"));
				userDetails.setEmail(json1.getString("email"));
				
				System.out.println(	json1.getString("gender"));
				userDetails.setGender(json1.getString("gender"));
				
				System.out.println(json1.getString("birthday"));
				userDetails.setDob(json1.getString("birthday"));
				
				System.out.println(json1.getJSONObject("location").getString("name"));
				userDetails.setCurrent_Location(json1.getJSONObject("location").getString("name"));
				
				System.out.println(json1.getJSONObject("hometown").getString("name"));
				userDetails.setOriginal_Location(json1.getJSONObject("hometown").getString("name"));
				
				System.out.println(json1.getJSONObject("picture").getJSONObject("data").getString("url"));
				userDetails.setPicture_Url(json1.getJSONObject("picture").getJSONObject("data").getString("url"));
				
				System.out.println("==education details==");
				if(json1.has("work") && json1.getJSONArray("work") != null){
					JSONArray jarray1=json1.getJSONArray("education");
					for(int i=0 ; i < jarray1.length(); i++) {
						//System.out.println("jarray [" + i + "] --------" + jarray1.getString(i));
						EducationDetails educationDetail=new EducationDetails();
						String school=jarray1.getJSONObject(i).getJSONObject("school").getString("name");
						String school_id=jarray1.getJSONObject(i).getJSONObject("school").getString("id");
						String type=jarray1.getJSONObject(i).getString("type");
						educationDetail.setSchool_id(school_id);
						educationDetail.setSchool_Name(school);
						educationDetail.setSchool_Type(type);
						educationDetailsLsit.add(educationDetail);
						System.out.println(type+": "+school+" "+school_id);
						}
					userDetails.setEduDetails(educationDetailsLsit);
				}else{
					System.out.println("oops it seems you reach at else of Education");
					EducationDetails educationDetail1=new EducationDetails();
					educationDetailsLsit.add(educationDetail1);
				}
				System.out.println("==work details==");
				if(json1.has("work") && json1.getJSONArray("work") != null){
					JSONArray jarray2=json1.getJSONArray("work");
					for(int i=0 ; i < jarray2.length(); i++) {
						//System.out.println("jarray [" + i + "] --------" + jarray2.getJSONObject(i));
						ExperienceDetails experienceDerails=new ExperienceDetails();
						String company=jarray2.getJSONObject(i).getJSONObject("employer").getString("name");
						String company_id=jarray2.getJSONObject(i).getJSONObject("employer").getString("id");
						String designation=jarray2.getJSONObject(i).getJSONObject("position").getString("name");
						String company_location=jarray2.getJSONObject(i).getJSONObject("location").getString("name");
						experienceDerails.setCompany_Id(company_id);
						experienceDerails.setCompany_Location(company_location);
						experienceDerails.setCompany_Name(company);
						experienceDerails.setDesignation(designation);
						experienceDetailsList.add(experienceDerails);
						System.out.println(company+","+designation+","+company_location+","+company_id);				
						}
					System.out.println(experienceDetailsList+"experienceDetailsListexperienceDetailsList");
					userDetails.setExpDetails(experienceDetailsList);
					}else{
						System.out.println("oops it seems you reach at else of Experience");
						ExperienceDetails experienceDerails1=new ExperienceDetails();
						experienceDetailsList.add(experienceDerails1);
					}
				session.setAttribute("userDetails", userDetails);
				} catch (JSONException e) {
					System.out.println("error!!!");
					return "views/serverError";
				}catch (NullPointerException e) {
						System.out.println("error!!!");
						return "views/serverError";
				}catch (Exception e) {
					System.out.println("error!!!");
					return "views/serverError";
					}
			return "views/confirmUserDetails";
			}
		return "views/serverError";
	}
	
	//update basic details
	@RequestMapping(value="/conformUserDetails")
	public String conformUserDetails(HttpServletRequest request,HttpServletResponse response){
		
		DaoServiceLoader daoServiceloader=ConnectionProviderFactory.getConnectionProvider();
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String contactEmail=request.getParameter("mail");
		String dob=request.getParameter("dob");
		String homeTown=request.getParameter("homeTown");
		String currentLocation=request.getParameter("currentLocation");
		HttpSession session=request.getSession(false);
		if(session!=null){
			UserDetails confirmUserDetails=(UserDetails)session.getAttribute("userDetails");
			confirmUserDetails.setFirstName(firstName);
			confirmUserDetails.setLastName(lastName);
			confirmUserDetails.setEmail(contactEmail);
			confirmUserDetails.setDob(dob);
			confirmUserDetails.setOriginal_Location(homeTown);
			confirmUserDetails.setCurrent_Location(currentLocation);
			//check whether user is there of not
			String facebookIdFromDataStore=this.getFacebookId(confirmUserDetails.getFacebookId());
			System.out.println("facebookIdFromDataStore=========="+facebookIdFromDataStore);
			System.out.println("======userDetails.getFacebookId()====="+confirmUserDetails.getFacebookId());
			request.setAttribute("fbid", confirmUserDetails.getFacebookId());
			//if not exist Persist the data
			if(facebookIdFromDataStore==null ||facebookIdFromDataStore==""){
				daoServiceloader.savePojo(confirmUserDetails);
				this.conformationMail(confirmUserDetails.getEmail());			//send a confirmation mail
				System.out.println("Object presisted successfully");
				//if exist don't persist
				}else{
					return "views/userAlreadyExist";				
			}
			//session.setAttribute("confirmUserDetails", confirmUserDetails);
			//return "views/updateEducationandExperienceDetails";
			return "views/designation";
		}
		return "views/serverError";
	}
	
	//not used
	//update Education and Experience Details
		@RequestMapping(value="/updateEducationandExperienceDetails")
		public String updateEducationAndExperienceDetails(HttpServletRequest request,HttpServletResponse response){
				HttpSession session=request.getSession(false);
				DaoServiceLoader daoServiceloader=ConnectionProviderFactory.getConnectionProvider();
				if(session!=null){
					UserDetails confirmEducationandExperienceDetails=(UserDetails)session.getAttribute("confirmUserDetails");
					//check whether user is there of not
					String facebookIdFromDataStore=this.getFacebookId(confirmEducationandExperienceDetails.getFacebookId());
					System.out.println("facebookIdFromDataStore=========="+facebookIdFromDataStore);
					System.out.println("======userDetails.getFacebookId()====="+confirmEducationandExperienceDetails.getFacebookId());
					request.setAttribute("fbid", confirmEducationandExperienceDetails.getFacebookId());
					//if not exist Persist the data
					if(facebookIdFromDataStore==null ||facebookIdFromDataStore==""){
						daoServiceloader.savePojo(confirmEducationandExperienceDetails);
						this.conformationMail(confirmEducationandExperienceDetails.getEmail());			//send a confirmation mail
						System.out.println("Object presisted successfully");
						//if exist don't persist
						}else{
							return "views/userAlreadyExist";				
					}
					return "views/designation";
				}
				return "views/serverError";
			}
		
	//logic to check whether user is exist or not;
	public String getFacebookId(String facebookId){
		String facrbookId=facebookId;
		DaoServiceLoader daoServiceloader=ConnectionProviderFactory.getConnectionProvider();
		List<UserDetails> getAll=(List<UserDetails>)daoServiceloader.getPojo(facebookId);
		Iterator<UserDetails> facebookIditerator=getAll.iterator();
		if(facebookIditerator.hasNext()){
			return facrbookId;
		}
		return "";
		}
	
	//send confirmation mail
	public void conformationMail(String mailId){
		String recepient=mailId;
		System.out.println(recepient);
		String subject="conformation Mail on behalf of Adaptavant recruitment system";
		System.out.println(subject);
		String message="This is to conform you that we got your profile details sucessfully \n if you will look suitable, then our HR will get back you soon";
		Properties properties=new Properties();
		Session session=Session.getInstance(properties, null);
		
		try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("lambodarswain.ullashchandra@a-cti.com", "ADAPTAVANT recruitment process"));
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress(recepient, "Candidate"));
            msg.setSubject(subject);
            msg.setText(message);
            Transport.send(msg);
		} catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("Unsoported exception");
           
        } catch (AddressException e) {
            e.printStackTrace();
            System.out.println("Address exception");
           
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Message exception");
          
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error occured");
           
        }
		System.out.println("conformation mail sented successfully");
	}
}
























