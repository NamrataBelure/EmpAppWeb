package com.scp.java.app.util;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtil {

	static{
		System.out.println("Hibernate loaded...");
	}
	@Autowired
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void saveAndFlush(Session session,Transaction tr){
		if (session!=null) 
			session.flush();
		if (tr!=null) 
			tr.commit();
		  session.close();
	}
}
