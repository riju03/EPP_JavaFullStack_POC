package org.study.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.study.hibernate.entity.Users;

public class App {

  public static void main(String[] args) {
	  
	  SessionFactory factory = new Configuration()
			                   .configure("hibernate.cfg.xml")
			                   .addAnnotatedClass(Users.class)
			                   .buildSessionFactory();
	  
	  Session session = factory.getCurrentSession();
	  
	  try {
		  // Start transaction
		  session.beginTransaction();
		  
		  // refering user of entity class
		  List<Users> users = session.createQuery("from users where first_name = 'ram' or last_name = 'prakash'").getResultList();
		  
		  for (Users temp : users) {
			System.out.println(temp);
		}
	
	} finally {
		session.close();
		factory.close();
	}
	
}
}






