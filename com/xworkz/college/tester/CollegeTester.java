package com.xworkz.college.tester;

import com.xworkz.college.dao.CollegeDAO;
import com.xworkz.college.dao.CollegeDAOImpl;
import com.xworkz.college.dto.CollegeDTO;

public class CollegeTester {

	public static void main(String[] args) {
		
		CollegeDTO collegeDTO = new CollegeDTO();
		collegeDTO.setCname("Ace");
		collegeDTO.setLocation("Hesarghatta");
		collegeDTO.setNoOfBranches(9);
		CollegeDAO collegeDaoImpl =new CollegeDAOImpl();
		
		//collegeDaoImpl.saveCollege(collegeDTO);
		//collegeDaoImpl.fetchCollege(2);
		collegeDaoImpl.updateCollege(collegeDTO,2);
		
	}
}

//Output
//CollegeDTODefault constructor
//invoked updateCollege

//Hibernate: 
//    select
//        collegedto0_.COLLEGE_ID as college_1_0_0_,
//        collegedto0_.CNAME as cname2_0_0_,
//        collegedto0_.LOCATION as location3_0_0_,
//        collegedto0_.NO_OF_BRANCHES as no_of_br4_0_0_,
//        collegedto0_.NO_OF_ROOMS as no_of_ro5_0_0_,
//        collegedto0_.NO_OF_STUDENTS as no_of_st6_0_0_ 
//    from
//        college_dto collegedto0_ 
//    where
//        collegedto0_.COLLEGE_ID=?
//CollegeDTODefault constructor
//Hibernate: 
//    update
//        college_dto 
//    set
//        CNAME=?,
//        LOCATION=?,
//        NO_OF_BRANCHES=?,
//        NO_OF_ROOMS=?,
//        NO_OF_STUDENTS=? 
//    where
//        COLLEGE_ID=?
//update collegeDTO
//2         Ace       Hesarghatta    2000      100       9
//session is closed 

