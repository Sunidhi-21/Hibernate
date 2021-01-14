package com.xworkz.college.dao;

import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.xworkz.college.dto.CollegeDTO;
import com.xworkz.singleconnection.SingleSessionFactory;

public class CollegeDAOImpl implements CollegeDAO {

	@Override
	public void saveCollege(CollegeDTO collegeDTO) {
		System.out.println("invoked saveCollege");
		Session session = null;
		
		try {
			SessionFactory singleFactory = SingleSessionFactory.getSingleFactory();
			session = singleFactory.openSession();
			session.beginTransaction();
			session.save(collegeDTO);
			session.getTransaction().commit();
			System.out.println("saved collegeDTO");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
	}

	@Override
	public void fetchCollege(int collegeID) {
		System.out.println("invoked fetchCollege");
		Session session = null;
		
		try {
			SessionFactory singleFactory = SingleSessionFactory.getSingleFactory();
			session = singleFactory.openSession();
			CollegeDTO collegeDTO = session.get(CollegeDTO.class, collegeID);
			System.out.println(collegeDTO);
			System.out.println("fetched collegeDTO");
			
			SingleSessionFactory.closeSessionFactory();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
	}

	@Override
	public void updateCollege(CollegeDTO collegeDTO, int collegeID) {
		System.out.println("invoked updateCollege");
		Session session = null;
		
		try {
			SessionFactory singleFactory = SingleSessionFactory.getSingleFactory();
			session = singleFactory.openSession();
			CollegeDTO collegeDTO2 = session.get(CollegeDTO.class, collegeID);
			
			collegeDTO2.setNoOfStudents(collegeDTO.getNoOfStudents());
			collegeDTO2.setNoOfRooms(collegeDTO.getNoOfRooms());
			collegeDTO2.setNoOfBranches(collegeDTO.getNoOfBranches());
			
			session.beginTransaction();
			session.update(collegeDTO2);
			session.getTransaction().commit();
			System.out.println("update collegeDTO");
			System.out.println(collegeDTO2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
	}

	@Override
	public void removeCollege(int collegeID) {
		System.out.println("Invoked removeCollege");
		Session session = null;
		
		try {

			SessionFactory singleFactory = SingleSessionFactory.getSingleFactory();
			session = singleFactory.openSession();
			CollegeDTO collegeDTO = session.get(CollegeDTO.class, collegeID);
			session.beginTransaction();
			session.delete(collegeDTO);
			session.getTransaction().commit();
			System.out.println("delete collegeDTO");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session is closed");
			} else
				System.out.println("session is not closed");
		}
	}
}
