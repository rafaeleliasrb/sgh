package br.com.sgh.main;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;

import br.com.sgh.factory.HibernateFactory;
import br.com.sgh.model.Medicamento;

public class TesteCache {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		Session session = HibernateFactory.getHibernateSession();
		session.beginTransaction();

		List<Medicamento> listaTodos = session.createQuery("from Medicamento e where e.estaAtivo = true").list();
    	listaTodos = session.createQuery("from Medicamento e where e.estaAtivo = true").list();

		System.out.println("######### COMMIT #########");
		session.getTransaction().commit();


	}

}
