package com.xworkz.bengalurueats.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="welcome_dto")
public class WelcomeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UID")
	private int userID;
	@Column(name="USERNAME")
	private String username;
	@Column(name="PASSWORD")
	private String password;
	
	public WelcomeDTO() {
		System.out.println("Default constructor");
	}


	public WelcomeDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	@Override
	public String toString() {
		return "WelcomeDTO [userID=" + userID + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
