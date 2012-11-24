package com.acti.recruitment.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class UserDetails implements Serializable{
	
	//encapsulated fields
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	
	@Persistent
	private String jodTitle;
	@Persistent
	private String yearOfExperience;
	@Persistent
	private String facebookId;
	@Persistent
	private String firstName;
	@Persistent
	private String lastName;
	@Persistent
	private String email;
	@Persistent
	private String dob;
	@Persistent
	private String gender;
	@Persistent
	private String facebookLink;
	@Persistent
	private String picture_Url;
	@Persistent
	private String original_Location;
	@Persistent
	private String current_Location;

	@Persistent(mappedBy = "userDetails")
	private List<ExperienceDetails> expDetails;
	@Persistent(mappedBy = "userDetails")
	private List<EducationDetails> eduDetails;
	
	@Persistent
	private String applyDate=new SimpleDateFormat("MM/dd/yyyy").format(new Date());
	
	//setter and getter
	public String getApplyDate() {
		return applyDate;
	}
	
	public String getFacebookId() {
		return facebookId;
	}
	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFacebookLink() {
		return facebookLink;
	}
	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}
	public String getPicture_Url() {
		return picture_Url;
	}
	public void setPicture_Url(String picture_Url) {
		this.picture_Url = picture_Url;
	}
	public String getOriginal_Location() {
		return original_Location;
	}
	public void setOriginal_Location(String original_Location) {
		this.original_Location = original_Location;
	}
	public String getCurrent_Location() {
		return current_Location;
	}
	public void setCurrent_Location(String current_Location) {
		this.current_Location = current_Location;
	}
	public List<ExperienceDetails> getExpDetails() {
		return expDetails;
	}
	public void setExpDetails(List<ExperienceDetails> expDetails) {
		this.expDetails = expDetails;
	}
	public List<EducationDetails> getEduDetails() {
		return eduDetails;
	}
	public void setEduDetails(List<EducationDetails> eduDetails) {
		this.eduDetails = eduDetails;
	}
	public String getJodTitle() {
		return jodTitle;
	}

	public void setJodTitle(String jodTitle) {
		this.jodTitle = jodTitle;
	}

	public String getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(String yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}
}








