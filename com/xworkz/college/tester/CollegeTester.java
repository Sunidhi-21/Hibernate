package com.xworkz.college.tester;

import java.util.Scanner;

import com.xworkz.college.dao.CollegeDAO;
import com.xworkz.college.dao.CollegeDAOImpl;
import com.xworkz.college.dto.CollegeDTO;

public class CollegeTester {

	public static void main(String[] args) {
		
		CollegeDTO collegeDTO = new CollegeDTO();
		
		CollegeDAO collegeDaoImpl =new CollegeDAOImpl();
		
		try(Scanner sc = new Scanner(System.in)) {
		
		System.out.println("Enter a number among 1 , 2 , 3 , 4 to choose to perform CRUD operation on db : ");
		System.out.println("1 --> Create");
		System.out.println("2 --> Read");
		System.out.println("3 --> Update");
		System.out.println("4 --> Delete");
		int choice= sc.nextInt();
		switch (choice) {
		case 1:{
			System.out.println("Enter the college details");
			System.out.println("CollegeID: ");
			int cId = sc.nextInt(); 
			collegeDTO.setCollegeID(cId);
			System.out.println("College name: ");
			String cName = sc.next();
			collegeDTO.setCname(cName);
			System.out.println("College location: ");
			String cLoc = sc.next();
			collegeDTO.setLocation(cLoc);
			System.out.println("No of students: ");
			int stu = sc.nextInt();
			collegeDTO.setNoOfStudents(stu);
			System.out.println("No of rooms: ");
			int rooms = sc.nextInt();
			collegeDTO.setNoOfRooms(rooms);
			System.out.println("No of branches: ");
			int branches = sc.nextInt();
			collegeDTO.setNoOfBranches(branches);
			collegeDaoImpl.saveCollege(collegeDTO);
			System.out.println(collegeDTO);
			break;
		}
			
		
		case 2:{
			System.out.println("fetch college details");
			System.out.println("Enter collegeID");
			int cId = sc.nextInt();
			collegeDaoImpl.fetchCollege(cId);
			break;
		}
			
		
		case 3:{
			System.out.println("Update a row");
			System.out.println("Enter college id");
			int cId = sc.nextInt();
			
			System.out.println("No of students: ");
			int stu = sc.nextInt();
		    collegeDTO.setNoOfStudents(stu);
				
			System.out.println("No of rooms: ");
			int rooms = sc.nextInt();
			collegeDTO.setNoOfRooms(rooms);
				
			System.out.println("No of branches: ");
			int branches = sc.nextInt();
			collegeDTO.setNoOfBranches(branches);
				
			collegeDaoImpl.updateCollege(collegeDTO,cId);
			
		break;
		}
		
		
			
		case 4: {
			System.out.println("Remove a record from the db");
			System.out.println("Enter college id");
			int cId = sc.nextInt();
			collegeDaoImpl.removeCollege(cId);
			break;
		}
		
		default:System.out.println("Invalid choice");
			break;
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//CollegeDTODefault constructor
//Enter a number among 1 , 2 , 3 , 4 to choose to perform CRUD operation on db : 
//1 --> Create
//2 --> Read
//3 --> Update
//4 --> Delete

//1
//Enter the college details
//CollegeID: 
//5
//College name: 
//BSIT
//College location: 
//Dasarahalli
//No of students: 
//2000
//No of rooms: 
//150
//No of branches: 
//7
//invoked saveCollege
//Hibernate: 
//    insert 
//    into
//        college_dto
//        (CNAME, LOCATION, NO_OF_BRANCHES, NO_OF_ROOMS, NO_OF_STUDENTS, COLLEGE_ID) 
//    values
//        (?, ?, ?, ?, ?, ?)
//saved collegeDTO
//session is closed
//5         BSIT      Dasarahalli    2000      150       7

//2
//fetch college details
//Enter collegeID
//5
//invoked fetchCollege
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
//5         BSIT      Dasarahalli    2000      150       7
//fetched collegeDTO
//Jan 15, 2021 2:49:02 AM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
//INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:3306/college]
//sessionFactory is closed
//session is closed

//3
//Update a row
//Enter college id
//5
//No of students: 
//2000
//No of rooms: 
//100
//No of branches: 
//6
//invoked updateCollege
//
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
//5         BSIT      Dasarahalli    2000      100       6
//session is closed


//4
//Remove a record from the db
//Enter college id
//5
//Invoked removeCollege
//
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
//    delete 
//    from
//        college_dto 
//    where
//        COLLEGE_ID=?
//delete collegeDTO
//session is closed

//5
//Invalid choice