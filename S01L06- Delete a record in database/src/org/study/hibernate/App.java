package org.study.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.study.hibernate.entity.Users;

public class App {

	public static void main(String[] args) {

		

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();

	

		Session session = factory.getCurrentSession();

		

		try {

			// Create object of entity class type

			Users user = new Users();

			// start transaction

			session.beginTransaction();

			// Perform operation
			// retrieval of record 
			user = session.get(Users.class, 4);
			
			//deleting a record with user id 4 
			 
			session.delete(user);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println(user);

		} finally {
			session.close();
			factory.close();
		}
	}

}
