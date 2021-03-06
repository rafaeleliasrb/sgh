package br.com.sgh.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.sgh.util.AuditInterceptor;

public class HibernateFactory {
	
	private static SessionFactory sf;
	
	public static synchronized Session getHibernateSession(){	
		if(sf == null){
			Configuration cfg = new Configuration();
			cfg.configure();
			cfg.setInterceptor(new AuditInterceptor());
			sf = cfg.buildSessionFactory();
		}
		Session s = sf.getCurrentSession();
		if(!s.isOpen()){
			s = sf.openSession();
		}
		return s;
	}
}
