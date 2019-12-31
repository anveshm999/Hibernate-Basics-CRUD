package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		//create session factory ( created only once that produces all sessions )
		
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		
		//create session
		
		Session session = sessionFactory.getCurrentSession();

		try {
			
			//create 3 new student object with values
			System.out.println("Creating 3 new student objects:");
			Student student1 = new Student("Anvesh", "Muthyala", "123@hibercall.com");
			Student student2 = new Student("Raj", "Muthyala", "123@hibercal12.com");
			Student student3 = new Student("Jash", "Muthyala", "123@hiberca23.com");
			
			//begin the transaction 
			session.beginTransaction();
			
			//save the student to database
			System.out.println("Saving the student ..... ");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			//commit the transaction
			session.getTransaction().commit();
			
		} catch (Exception e) {

		}
		finally {
			sessionFactory.close();
		}

	}

}
