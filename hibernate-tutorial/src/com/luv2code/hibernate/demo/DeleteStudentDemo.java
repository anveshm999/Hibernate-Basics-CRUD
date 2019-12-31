package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory ( created only once that produces all sessions )
		
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		
		//create session
		
		Session session = sessionFactory.getCurrentSession();

		try {
		/*	
			int studentId = 1; 
			
			//begin the transaction 
			session.beginTransaction();

			System.out.println("getting student with id: " +studentId);		
			Student myStudent = session.get(Student.class, studentId);
						
			System.out.println("Deleting student.... ");
			
			session.delete(myStudent);
			session.getTransaction().commit();
		*/
			
		/*
		 * Another approach for deleting using session.createQuery	
		 */
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			
			session.createQuery("delete from Student where id = 2").executeUpdate(); // execute update for bulk updates
			
			session.getTransaction().commit();
			
			
		} catch (Exception e) {

		}
		finally {
			sessionFactory.close();
		}

	}

}
