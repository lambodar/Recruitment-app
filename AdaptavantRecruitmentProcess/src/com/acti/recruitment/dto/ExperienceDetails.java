package com.acti.recruitment.dto;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;


@PersistenceCapable
public class ExperienceDetails implements Serializable {
	
	//encapsulated fields
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;
	@Persistent
    private UserDetails userDetails;
	@Persistent
	private String company_Name;
	@Persistent
	private String company_Id;
	@Persistent
	private String designation;
	@Persistent
	private String company_Location;
	
		public String getCompany_Name() {
			return company_Name;
		}
		public void setCompany_Name(String company_Name) {
			this.company_Name = company_Name;
		}
		public String getCompany_Id() {
			return company_Id;
		}
		public void setCompany_Id(String company_Id) {
			this.company_Id = company_Id;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public String getCompany_Location() {
			return company_Location;
		}
		public void setCompany_Location(String company_Location) {
			this.company_Location = company_Location;
		}
	
	

}



