package com.xworkz.college.dao;

import java.util.List;
import java.util.Objects;

import javax.naming.spi.ResolveResult;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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

	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Override
	public void removeCollege(int collegeID) {
		System.out.println("Invoked removeCollege");
		Session session = null;
		Transaction transaction=null;
		
		try {

			SessionFactory singleFactory = SingleSessionFactory.getSingleFactory();
			session = singleFactory.openSession();
			//CollegeDTO collegeDTO = session.get(CollegeDTO.class, collegeID);
			transaction = session.beginTransaction();
			//session.delete(collegeDTO);
			
			//String HQL = "delete from CollegeDTO where collegeID=:cId";
			Query q = session.getNamedQuery("DeleteCollege");
			q.setParameter("cId", collegeID);
			int noOfRows = q.executeUpdate();
			transaction.commit();
			System.out.println(noOfRows);
			System.out.println("delete collegeDTO");

		} catch (Exception e) {
			transaction.rollback();
			System.out.println("rollback");
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session is closed");
			} else
				System.out.println("session is not closed");
		}
	}

	@Override
	public void fetchAllCollege() {
		System.out.println("invoked fetchAllCollege");
		Session session = null;
		
		try {
			SessionFactory singleFactory = SingleSessionFactory.getSingleFactory();
			session = singleFactory.openSession();
//			String HQL = "from CollegeDTO";
//			Query q = session.createQuery(HQL);
			System.out.println("using criteria");
			Criteria createCriteria = session.createCriteria(CollegeDTO.class);
			createCriteria.add(Restrictions.eq("noOfStudents",500));
			List list = createCriteria.list();
			System.out.println(list);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session is closed");
			} else
				System.out.println("session is not closed");
		}
		
	}
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Override
	public void updateCollege1(String cname, int collegeID) {
		System.out.println("invoked updateCollege1");
		Session session = null;
		
		try {
			SessionFactory singleFactory = SingleSessionFactory.getSingleFactory();
			session = singleFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			//String HQL = "update CollegeDTO set cname=:name Where collegeID=:cId";
			Query q = session.getNamedQuery("UpdateCollege");
			q.setParameter("name",cname);
			q.setParameter("cId", collegeID);
			
			int update = q.executeUpdate();
			System.out.println(update);
			transaction.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session is closed");
			} else
				System.out.println("session is not closed");
		}
		
	}

	@Override
	public void maxStudents() {
		System.out.println("invoked fetchAllCollege");
		Session session = null;
		
		try {
			SessionFactory singleFactory = SingleSessionFactory.getSingleFactory();
			session = singleFactory.openSession();
			//String HQL = "select max(noOfStudents) from CollegeDTO";
			Query q = session.getNamedQuery("MaxStudents");
			List list = q.list();
			System.out.println(list);
			
			SingleSessionFactory.closeSessionFactory();
		}catch (Exception e) {
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
