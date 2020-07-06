package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryGetAllStudentDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student").list();

			// Display the Students
			displayStudents(theStudents);

			//////////////////////////////////////////////////////////////////////////////////////

			// query students: lastName = "Chaudhari"
			theStudents = session.createQuery("from Student s where s.lastName = 'Chaudhari'").list();

			// Display the Students
			System.out.println("\n\nStudent who have last name of Chaudhari");
			displayStudents(theStudents);

			//////////////////////////////////////////////////////////////////////////////////////

			// query students: lastName = "Chaudhari OR firstName = 'Prasad"
			theStudents = session
					.createQuery("from Student s where" + " s.lastName = 'Chaudhari' AND s.firstName = 'Prasad'")
					.list();

			// Display the Students
			System.out.println("\n\nStudent who have Lastname:  Chaudhari And FirstName : Prasad");
			displayStudents(theStudents);

			//////////////////////////////////////////////////////////////////////////////////////

			// query students: emial = '%luv2code.com'
			theStudents = session.createQuery("from Student s where" + " s.email Like '%luv2code.com'").list();

			// Display the Students
			System.out.println("\n\n Student who have email '%luv2code.com");
			displayStudents(theStudents);

			//////////////////////////////////////////////////////////////////////////////////////

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done...........");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		// display the student
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
