package com.xworkz.college.tester;

import com.xworkz.college.dao.CollegeDAO;
import com.xworkz.college.dao.CollegeDAOImpl;
import com.xworkz.college.dto.CollegeDTO;

public class CollegeTester {

	public static void main(String[] args) {
		
		CollegeDTO collegeDTO = new CollegeDTO();
		
		CollegeDAO collegeDaoImpl =new CollegeDAOImpl();
		
		collegeDaoImpl.fetchAllCollege();
//		collegeDaoImpl.updateCollege1("BSIT",4);
//		collegeDaoImpl.removeCollege(3);
//		collegeDaoImpl.maxStudents();
		
	}	
		
}

//Output
//CollegeDTODefault constructor
//invoked updateCollege1
//Hibernate: 
//    update
//        college_dto 
//    set
//        CNAME=? 
//    where
//        COLLEGE_ID=?
//1
//session is closed
//Invoked removeCollege
//Hibernate: 
//    delete 
//    from
//        college_dto 
//    where
//        COLLEGE_ID=?
//1
//delete collegeDTO
//session is closed
//invoked fetchAllCollege
//Hibernate: 
//    select
//        max(collegedto0_.NO_OF_STUDENTS) as col_0_0_ 
//    from
//        college_dto collegedto0_
//[2000]
//sessionFactory is closed
//session is closed
//using criteria
//Hibernate: 
//    select
//        this_.COLLEGE_ID as college_1_0_0_,
//        this_.CNAME as cname2_0_0_,
//        this_.LOCATION as location3_0_0_,
//        this_.NO_OF_BRANCHES as no_of_br4_0_0_,
//        this_.NO_OF_ROOMS as no_of_ro5_0_0_,
//        this_.NO_OF_STUDENTS as no_of_st6_0_0_ 
//    from
//        college_dto this_ 
//    where
//        this_.NO_OF_STUDENTS=?
//CollegeDTODefault constructor
//[1         SKIT      Bangalore      500       50        6]
//session is closed