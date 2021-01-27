package com.xworkz.college.dao;

import com.xworkz.college.dto.CollegeDTO;

public interface CollegeDAO {

	void saveCollege(CollegeDTO collegeDTO);
	
	void fetchCollege(int collegeID);
	
	void updateCollege(CollegeDTO collegeDTO,int collegeID);
	
	void removeCollege(int collegeID);
	
	public void fetchAllCollege();
	
	void updateCollege1(String cname, int collegeID);
	
	void maxStudents();
	
	
}
