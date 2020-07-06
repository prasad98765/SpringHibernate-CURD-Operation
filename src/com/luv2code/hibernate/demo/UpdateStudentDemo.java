package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session

		Session session = factory.getCurrentSession();

		try {
			// create a Student Object
			int studentId = 1;

			// now get a new Session and start Transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: Primary key

			System.out.println("\nGetting student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Updateing Student....");

			// To update 1 id
			myStudent.setFirstName("Sonali");

			// commit the transaction
			session.getTransaction().commit();

			// NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();

			// update email for all student

			System.out.println("Update email for all students");

			// session.createQuery("update Student set email = 'foooooo@gmail.com' where id
			// = 3").executeUpdate();
			session.createQuery("update Student set email = 'foooooo@gmail.com'").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done...........");

		} finally {
			factory.close();
		}
	}

}
