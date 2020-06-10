package org.studyeasy.hibernate.DAO;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.hibernate.entity.Files;

public class FilesDAO {
	SessionFactory factory = new Configuration()
			                 .configure("hibernate.cfg.xml")
			                 .addAnnotatedClass(Files.class)
			                 .buildSessionFactory();
	
	public void addFileDetails(Files file) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(file);
		session.getTransaction().commit();
		System.out.println(file.getFileName()+" Got added");
	}
	public List<Files> listFiles(){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Files> files =  session.createQuery("from files").getResultList();
		//session.getTransaction().commit();	
		return files;
	}
	public void updateInformation(Files file) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		//the object file should have all the information as it is based on entity
		// as filename is missing in this object it will make it as null, so we should have information for all the properties
		session.update(file);
		session.getTransaction().commit();
		
	}
}



