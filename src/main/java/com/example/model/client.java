package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name="TBLCLIENT")
	public class client {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long CLIENT_ID;

	@Column(name="CLIENT_NAME")
	private String CLIENT_NAME;
	
	@Column(name="CLIENT_ADDRESS")
	private String CLIENT_ADDRESS;

	@Column(name="CLIENT_PHONE")
	private long CLIENT_PHONE;

	@Column(name="CLIENT_EMAIL")
	private String CLIENT_EMAIL;
	
	@Column(name="CLIENT_GENDER")
	private String CLIENT_GENDER;
	
	@Column(name="CLIENT_CNIC")
	private long CLIENT_CNIC;
	
	@Column(name="MODIFIED_BY")
	private String MODIFIED_BY;

	@Column(name="MODIFIED_WHEN")
	private String MODIFIED_WHEN;

	@Column(name="MODIFIED_WORKSTATION")
	private String MODIFIED_WORKSTATION;

	@Column(name="IS_ACTIVE")
	private String IS_ACTIVE;
	
	public long getCLIENT_ID() {
		return CLIENT_ID;
	}

	public void setCLIENT_ID(long CLIENT_ID) {
		this.CLIENT_ID = CLIENT_ID;
	}

	public String getCLIENT_NAME() {
		return CLIENT_NAME;
	}

	public void setCLIENT_NAME(String CLIENT_NAME) {
		this.CLIENT_NAME = CLIENT_NAME;
	}

	public String getCLIENT_ADDRESS() {
		return CLIENT_ADDRESS;
	}

	public void setCLIENT_ADDRESS(String CLIENT_ADDRESS) {
		this.CLIENT_ADDRESS = CLIENT_ADDRESS;
	}

	public long getCLIENT_PHONE() {
		return CLIENT_PHONE;
	}

	public void setCLIENT_PHONE(long CLIENT_PHONE) {
		this.CLIENT_PHONE = CLIENT_PHONE;
	}

	public String getCLIENT_EMAIL() {
		return CLIENT_EMAIL;
	}

	public void setCLIENT_EMAIL(String CLIENT_EMAIL) {
		this.CLIENT_EMAIL = CLIENT_EMAIL;
	}

	public String getCLIENT_GENDER() {
		return CLIENT_GENDER;
	}

	public void setCLIENT_GENDER(String CLIENT_GENDER) {
		this.CLIENT_GENDER = CLIENT_GENDER;
	}

	public long getCLIENT_CNIC() {
		return CLIENT_CNIC;
	}

	public void setCNIC(long CLIENT_CNIC) {
		this.CLIENT_CNIC = CLIENT_CNIC;
	}

	public String getMODIFIED_BY() {
		return MODIFIED_BY;
	}

	public void setMODIFIED_BY(String MODIFIED_BY) {
		this.MODIFIED_BY = MODIFIED_BY;
	}

	public String getMODIFIED_WHEN() {
		return MODIFIED_WHEN;
	}

	public void setMODIFIED_WHEN(String MODIFIED_WHEN) {
		this.MODIFIED_WHEN = MODIFIED_WHEN;
	}

	public String getMODIFIED_WORKSTATION() {
		return MODIFIED_WORKSTATION;
	}

	public void setMODIFIED_WORKSTATION(String MODIFIED_WORKSTATION) {
		this.MODIFIED_WORKSTATION = MODIFIED_WORKSTATION;
	}

	public String getIS_ACTIVE() {
		return IS_ACTIVE;
	}

	public void setIS_ACTIVE(String IS_ACTIVE) {
		this.IS_ACTIVE = IS_ACTIVE;
	}


}
	

