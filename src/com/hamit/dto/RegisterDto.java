package com.hamit.dto;

import java.io.Serializable;
import java.util.Date;

public class RegisterDto implements Serializable {
	private static final long serialVersionUID = -4240280855495141838L;

	// field
	private int registerId;
	private String registerName;
	private String registerSurname;
	private String registerEmail;
	private String registerPassword;
	private String registerRoles;
	private Date date;

	// parametresiz constructor
	public RegisterDto() {

	}

	// parametreli constructor
	public RegisterDto(String registerName, String registerSurname, String registerEmail, String registerPassword,
			String registerRoles) {
		this.registerName = registerName;
		this.registerSurname = registerSurname;
		this.registerEmail = registerEmail;
		this.registerPassword = registerPassword;
		this.registerRoles = registerRoles;
	}

	public RegisterDto(int registerId, String registerName, String registerSurname, String registerEmail,
			String registerPassword, String registerRoles) {
		this.registerId = registerId;
		this.registerName = registerName;
		this.registerSurname = registerSurname;
		this.registerEmail = registerEmail;
		this.registerPassword = registerPassword;
		this.registerRoles = registerRoles;
	}

	// toString
	@Override
	public String toString() {
		return "RegisterDto [registerId=" + registerId + ", registerName=" + registerName + ", registerSurname="
				+ registerSurname + ", registerEmail=" + registerEmail + ", registerPassword=" + registerPassword
				+ ", registerRoles=" + registerRoles + ", date=" + date + "]";
	}

	// getter and setter
	public int getRegisterId() {
		return registerId;
	}

	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}

	public String getRegisterName() {
		return registerName;
	}

	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}

	public String getRegisterSurname() {
		return registerSurname;
	}

	public void setRegisterSurname(String registerSurname) {
		this.registerSurname = registerSurname;
	}

	public String getRegisterEmail() {
		return registerEmail;
	}

	public void setRegisterEmail(String registerEmail) {
		this.registerEmail = registerEmail;
	}

	public String getRegisterPassword() {
		return registerPassword;
	}

	public void setRegisterPassword(String registerPassword) {
		this.registerPassword = registerPassword;
	}

	public String getRegisterRoles() {
		return registerRoles;
	}

	public void setRegisterRoles(String registerRoles) {
		this.registerRoles = registerRoles;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = new Date(System.currentTimeMillis());
	}

}
