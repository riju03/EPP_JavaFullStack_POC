package org.study.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.study.hibernate.entity.Users;

public class App {

	public static void main(String[] args) {

		// adding hibernate related code

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();

		// whenever we create session object with the help of session factory object
		// this particular instance is connected to DB.

		Session session = factory.getCurrentSession();

		/*
		 * in try block we will write code to connect to database and perform CRUD
		 * operations once our job is done we need to close the session objects and
		 * session factory objects
		 */

		try {

			// Create object of entity class type

			Users user = new Users();

			// start transaction

			session.beginTransaction();

			// Perform operation
			// in the argument need to pass type i.e. users class and value of primary key we want to retrieve
			user = session.get(Users.class, 3);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println(user);

		} finally {
			session.close();
			factory.close();
		}
	}

}
