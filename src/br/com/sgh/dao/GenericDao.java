package br.com.sgh.dao;

import java.util.List;
import org.hibernate.Session;
import br.com.sgh.factory.HibernateFactory;

public class GenericDao<E> {	
	
	protected final Session session;
	
    public GenericDao() throws Exception {
    	this.session = HibernateFactory.getHibernateSession();
    }
    
    public void salvar(E bm){
    	session.saveOrUpdate(bm);
    }
    
    public void deletar(E bm){
    	session.delete(bm);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<E> listarTodos(Class bm){
    	return session.createQuery("from "+bm.getName()+" e where e.estaAtivo = true").list();
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<E> listarTodosComLimite(Class bm, Integer limite){
    	return session.createQuery("from "+bm.getName()+" e where e.estaAtivo = true").setMaxResults(limite).list();
    }
}
