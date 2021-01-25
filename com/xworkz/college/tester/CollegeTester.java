package com.xworkz.college.tester;

import com.xworkz.college.dao.CollegeDAO;
import com.xworkz.college.dao.CollegeDAOImpl;
import com.xworkz.college.dto.CollegeDTO;

public class CollegeTester {

	public static void main(String[] args) {
		
		CollegeDTO collegeDTO = new CollegeDTO();
		
		CollegeDAO collegeDaoImpl =new CollegeDAOImpl();
		
		collegeDaoImpl.fetchAllCollege();
		
	}	
		
}

//Output
//Hibernate: 
//    select
//        collegedto0_.COLLEGE_ID as college_1_0_,
//        collegedto0_.CNAME as cname2_0_,
//        collegedto0_.LOCATION as location3_0_,
//        collegedto0_.NO_OF_BRANCHES as no_of_br4_0_,
//        collegedto0_.NO_OF_ROOMS as no_of_ro5_0_,
//        collegedto0_.NO_OF_STUDENTS as no_of_st6_0_ 
//    from
//        college_dto collegedto0_
//CollegeDTODefault constructor
//CollegeDTODefault constructor
//CollegeDTODefault constructor
//CollegeDTODefault constructor
//CollegeDTODefault constructor
//CollegeDTODefault constructor
//[1         SKIT      Bangalore      500       50        6, 2         Ace       Hesarghatta    2000      100       9, 3         rsit      mysore road    2000      150       6, 4         Ace       Hesarghatta    150       50        9, 5         BSIT      Dasarahalli    2000      100       6, 7         rrit      chikkabanavara 1500      70        6]
//session is closed