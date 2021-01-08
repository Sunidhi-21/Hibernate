package com.xworkz.college.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="college_dto")
public class CollegeDTO implements java.io.Serializable {

	@Id
	@Column(name="COLLEGE_ID")
	private int collegeID;
	@Column(name="CNAME")
	private String cname;
	@Column(name="LOCATION")
	private String location;
	@Column(name="NO_OF_STUDENTS")
	private int noOfStudents;
	@Column(name="NO_OF_ROOMS")
	private int noOfRooms;
	@Column(name="NO_OF_BRANCHES")
	private int noOfBranches;
	
	public CollegeDTO() {
		System.out.println(this.getClass().getSimpleName()+"Default constructor");
	}
	
	public CollegeDTO(int collegeID, String cname, String location, int noOfStudents, int noOfRooms, int noOfBranches) {
		super();
		this.collegeID = collegeID;
		this.cname = cname;
		this.location = location;
		this.noOfStudents = noOfStudents;
		this.noOfRooms = noOfRooms;
		this.noOfBranches = noOfBranches;
	}

	public int getCollegeID() {
		return collegeID;
	}

	public void setCollegeID(int collegeID) {
		this.collegeID = collegeID;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public int getNoOfBranches() {
		return noOfBranches;
	}

	public void setNoOfBranches(int noOfBranches) {
		this.noOfBranches = noOfBranches;
	}

	@Override
	public String toString() {
		
		String formattedData = String.format("%-10s%-10s%-15s%-10s%-10s%s",collegeID,cname,location,noOfStudents,noOfRooms,noOfBranches);
		return formattedData;
	}
	
}
