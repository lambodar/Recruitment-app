package com.acti.recruitment.controller;

import java.io.UnsupportedEncodingException;
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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;



@Controller
@RequestMapping(value="/mail")
public class HrMailSender {
	
	@RequestMapping(value="/sendMail",method=RequestMethod.POST)
	public @ResponseBody String sendMail(HttpServletRequest request,HttpServletResponse response) throws JSONException{
		
		/*String recepient=request.getParameter("email_Id");
		System.out.println(recepient);
		String subject=request.getParameter("subject");
		System.out.println(subject);
		String message=request.getParameter("message");
		System.out.println(message);*/
		String dataStringFromJson=request.getParameter("dataString");
		JSONObject json=new JSONObject(dataStringFromJson);
		System.out.println(json);
		String recepient=json.getString("email_Id");
		String subject=json.getString("subject");
		String message=json.getString("message");
		System.out.println(recepient);
		System.out.println(subject);
		System.out.println(message);
		
		Properties properties=new Properties();
		Session session=Session.getInstance(properties, null);
		
		try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("lambodarswain.ullashchandra@a-cti.com", "HR-ADAPTAVANT Technology"));
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress(recepient, "Candidate"));
            msg.setSubject(subject);
            msg.setText(message);
            Transport.send(msg);
		} catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("Unsoported exception");
            return "adminviews/hrError";
        } catch (AddressException e) {
            e.printStackTrace();
            System.out.println("Address exception");
            return "adminviews/hrError";
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Message exception");
            return "adminviews/hrError";
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error occured");
            return "adminviews/hrError";
        }
		return "adminviews/viewProfile";
	}
	@RequestMapping(value="/confMail",method=RequestMethod.POST)
	public String conformationMail(HttpServletRequest request){
		
		String recepient=request.getParameter("email_Id");
		System.out.println(recepient);
		String subject="conformation Mail on behalf of Adaptavant recruitment system";
		System.out.println(subject);
		String message="<font color='green' size='4'>" +
				"This is to conform you that we got your profile details sucessfully<br>" +
				"if you will look suitable, then our HR will get back you soon</font>";
		Properties properties=new Properties();
		Session session=Session.getInstance(properties, null);
		
		try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("lambodarswain.ullashchandra@a-cti.com", "Conformation"));
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress(recepient, "Candidate"));
            msg.setSubject(subject);
            msg.setText(message);
            Transport.send(msg);
		} catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("Unsoported exception");
            return "adminviews/hrError";
        } catch (AddressException e) {
            e.printStackTrace();
            System.out.println("Address exception");
            return "adminviews/hrError";
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Message exception");
            return "adminviews/hrError";
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error occured");
            return "adminviews/hrError";
        }
		return "adminviews/viewProfile";
	}


}
