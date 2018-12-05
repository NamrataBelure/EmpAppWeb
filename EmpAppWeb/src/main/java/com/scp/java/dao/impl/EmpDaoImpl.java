package com.scp.java.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scp.java.Entity.EmpEntity;
import com.scp.java.app.util.HibernateUtil;
import com.scp.java.bean.EmpBean;
import com.scp.java.dao.EmpDao;

@Repository
public class EmpDaoImpl implements EmpDao{

   @Autowired
	private static SessionFactory seFactory;
	
	public boolean insertEmp(EmpEntity emp) {
		seFactory=HibernateUtil.getSessionFactory();
		Session session=this.seFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(emp);
		tr.commit();
		//session.close();
		return insertEmp(emp);
	}

	public EmpEntity FatchEmp(int empempIndentifier) {
		 seFactory=HibernateUtil.getSessionFactory();
		 Session session=seFactory.openSession();
		 session.beginTransaction();
		 EmpEntity e=(EmpEntity) session.load(EmpEntity.class,empempIndentifier);
		 //session.close();
		 return(e);
	}

	public boolean removeEmp(int empIndentifier) {
	   seFactory=HibernateUtil.getSessionFactory();
		Session session=this.seFactory.openSession();
		session.beginTransaction();
		EmpBean e=(EmpBean) session.load(EmpEntity.class, empIndentifier);
		if (null!=e) {
			session.delete(e);
		}
		//session.close();
		return removeEmp(empIndentifier);
	}

	public EmpEntity EditEmp(EmpEntity emp) {
        seFactory=HibernateUtil.getSessionFactory();
		Session session=this.seFactory.openSession();
		session.beginTransaction();
		session.merge(emp);
		return EditEmp(emp);
	}

	public List<EmpEntity> FetchallEmp() {
		seFactory=HibernateUtil.getSessionFactory();
		Session session= seFactory.getCurrentSession();
		List<EmpEntity>emplist=session.createQuery("from EmpInfo").list();
	    for(EmpEntity e : emplist){}
		return 	emplist;
	}

}
