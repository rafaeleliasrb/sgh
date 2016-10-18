package br.com.sgh.dao;

import br.com.sgh.model.Medico;

public class PessoaDao extends GenericDao{	
	
    public PessoaDao() {
    	super();
    }    
      
    public Medico getProfessor(Integer id) throws Exception{
    	String consulta = "from Professor p where p.id = :id " +
    										  "and p.estaAtivo = true";
    	return (Medico)super.session.createQuery(consulta).setParameter("id", id).uniqueResult();
    }
    
}
