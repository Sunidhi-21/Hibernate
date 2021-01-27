package com.xworkz.bengalurueats.dao;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xworkz.bengalurueats.dto.WelcomeDTO;
import com.xworkz.singleconnection.SingleSessionFactory;

@WebServlet("/WelcomeDAOImpl")
public class WelcomeDAOImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println("Session get attribute");
		String username = (String) session.getAttribute("usernameInSession");
		String password = (String) session.getAttribute("passwordInSession");
		
		WelcomeDTO welcomeDTO = new WelcomeDTO(username,password);
		
		System.out.println(welcomeDTO);
		
		Session session1 = null;
		
		try {
			SessionFactory singleFactory = SingleSessionFactory.getSingleFactory();
			session1 = singleFactory.openSession();
			session1.beginTransaction();  
			session1.save(welcomeDTO);
			session1.getTransaction().commit();
			System.out.println("saved user details");
			
			SingleSessionFactory.closeSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session1)) {
				session1.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
	}

}

//output
//INFO: Server startup in [1597] milliseconds
//Login credentials
//Username:Sunidhi-N
//Password:123456
//Session get attribute
//WelcomeDTO [username=Sunidhi-N, password=123456]
//Default constructor
//Hibernate: 
//    select
//        next_val as id_val 
//    from
//        hibernate_sequence for update
//            
//Hibernate: 
//    update
//        hibernate_sequence 
//    set
//        next_val= ? 
//    where
//        next_val=?
//Hibernate: 
//    insert 
//    into
//        welcome_dto
//        (PASSWORD, USERNAME, UID) 
//    values
//        (?, ?, ?)
//saved user details
//session is closed