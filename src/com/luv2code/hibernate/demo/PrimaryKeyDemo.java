package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session

		Session session = factory.getCurrentSession();

		try {
			// create 3 Student Object
			System.out.println("Creating 3 student Onject....");
			Student tempStudent1 = new Student("Prasad", "Chaudhari", "pnchaudhari1996@gmail.com");
			Student tempStudent2 = new Student("Snehal", "Chaudhari", "snehalgmail.com");
			Student tempStudent3 = new Student("savita", "Chaudhari", "savita@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("saving the student......");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done...........");
		} finally {
			factory.close();
		}
	}
}
