package com.acti.recruitment.dto;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class EducationDetails implements Serializable{
	
	//encapsulated fields
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;
	@Persistent
    private UserDetails userDetails;
	@Persistent
	private String school_Type;
	@Persistent
	private String school_Name;
	@Persistent
	private String school_id;
	
		public String getSchool_Type() {
			return school_Type;
		}
		public void setSchool_Type(String school_Type) {
			this.school_Type = school_Type;
		}
		public String getSchool_Name() {
			return school_Name;
		}
		public void setSchool_Name(String school_Name) {
			this.school_Name = school_Name;
		}
		public String getSchool_id() {
			return school_id;
		}
		public void setSchool_id(String school_id) {
			this.school_id = school_id;
		}
		
	
	
}
