package com.ameykolhe.datetime.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.ameykolhe.datetime.entities.DateTime;

@Repository
public class DateTimeDAO {

	private SessionFactory sessionFactory;
	
	public DateTimeDAO() {
		sessionFactory = new Configuration()
						.configure()
						.addAnnotatedClass(DateTime.class)
						.buildSessionFactory();
	}

	public void add(DateTime dateTime) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			session.save(dateTime);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DateTime> getHisotry() {
		Session session = sessionFactory.getCurrentSession();
		
		List<DateTime> resultList = null;
		
		try {
			System.out.println("In getHistory");
			if (session == null) {
				System.out.println("Session doesnot exist");
			}
			session.beginTransaction();
			resultList = session.createQuery("FROM DateTime ex ORDER BY ex.timeStamp DESC").setMaxResults(100).getResultList();
			session.getTransaction().commit();
			System.out.println("Transaction Complete");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
	
}
