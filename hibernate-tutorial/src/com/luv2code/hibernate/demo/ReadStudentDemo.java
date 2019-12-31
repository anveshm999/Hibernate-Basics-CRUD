package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session factory ( created only once that produces all sessions )
		
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		
		//create session
		
		Session session = sessionFactory.getCurrentSession();

		try {
			
			//create a student object with values
			System.out.println("Creating a new student object:");
			Student student1 = new Student("Read", "Muthyala", "read@hibernate.com");
			
			//begin the transaction 
			session.beginTransaction();
			
			//save the student to database
			System.out.println("Saving the student ..... ");
			System.out.println(student1);
			session.save(student1);
			
			//commit the transaction
			session.getTransaction().commit();
			
		/*
		 *  New code for Read operation
		 */
			System.out.println("Saved student  primary key: " +student1.getId());
				
			//get new session and start transaction
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
					
				// retrieve student based on primary key id
				System.out.println("Generated primary key: " +student1.getId());
					
				Student myStudent = session.get(Student.class, student1.getId());
						
				System.out.println("Get complete : "+myStudent);
				
				session.getTransaction().commit();
								
			
		} catch (Exception e) {

		}
		finally {
			sessionFactory.close();
		}

	}

}
