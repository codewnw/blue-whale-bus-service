package com.bluewhale.bus.model;

public class Login {

	private String unsername;

	private Password password;

	private String type;

	private String status;

	public String getUnsername() {
		return unsername;
	}

	public void setUnsername(String unsername) {
		this.unsername = unsername;
	}

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
