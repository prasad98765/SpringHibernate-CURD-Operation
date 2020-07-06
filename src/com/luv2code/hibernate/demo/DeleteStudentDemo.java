package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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

			// delete the 1 student
			// System.out.println("Deleting student---->"+ myStudent);
			// session.delete(myStudent);

			// Delete student id = 2
			System.out.println("Deleting student id = 2");
			session.createQuery("delete from Student where id=2").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();

			// NEW Code

			System.out.println("Done...........");

		} finally {
			factory.close();
		}
	}

}
