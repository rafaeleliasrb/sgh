package br.com.sgh.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.sgh.factory.HibernateFactory;

public class GenericDao<E> {

	protected Session session;

	public GenericDao() throws Exception {
		this.session = HibernateFactory.getHibernateSession();
	}

	public void salvar(E bm) {
		session.saveOrUpdate(bm);
	}

	public void deletar(E bm) {
		session.delete(bm);
	}

	protected Session getSession() {
		if (session == null || !session.isOpen()) {
			this.session = HibernateFactory.getHibernateSession();
		}
		return session;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<E> listarTodos(Class bm) {
		Long ini = System.currentTimeMillis();
		List<E> listaTodos = getSession().createQuery("from " + bm.getName() + " e where e.estaAtivo = true").list();
		Long fim = System.currentTimeMillis();
		System.out.println("Tempo da consulta: " + (fim-ini));
		return listaTodos;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<E> listarTodosComLimite(Class bm, Integer limite) {
		return session.createQuery("from " + bm.getName() + " e where e.estaAtivo = true").setMaxResults(limite).list();
	}
}
