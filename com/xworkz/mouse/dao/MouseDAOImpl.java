package com.xworkz.mouse.dao;

import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xworkz.mouse.dto.MouseDTO;
import com.xworkz.singleconnection.SingleSessionFactory;

public class MouseDAOImpl implements MouseDAO {

	@Override
	public void saveMouse(MouseDTO mouseDTO) {
		
		System.out.println("invoked saveMouse");
		Session session=null;
		
		try {
			SessionFactory singleFactory = SingleSessionFactory.getSingleFactory();
			session = singleFactory.openSession();
			session.beginTransaction();
			session.save(mouseDTO);
			session.getTransaction().commit();
			System.out.println("saved mouseDTO");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(Objects.nonNull(session)) {
				session.close();
				System.out.println("session is closed");
			}else {
				System.out.println("session is not closed");
			}
		}
		
	}

	
}
