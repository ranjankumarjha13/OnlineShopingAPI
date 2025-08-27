package com.online.OnlineShoping.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
	
	   @JsonProperty("username")
	    private String username;

	    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

		@JsonProperty("password")
	    private String password;
}
