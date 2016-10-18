package br.com.sgh.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
	
	private static SessionFactory sf;
	
	public static synchronized Session getHibernateSession(){	
		if(sf == null){
			sf = new Configuration().configure().buildSessionFactory();
		}
		Session s = sf.getCurrentSession();		
		return s;
	}
}
