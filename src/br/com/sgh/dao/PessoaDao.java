package br.com.sgh.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.com.sgh.model.Medico;
import br.com.sgh.model.Paciente;
import br.com.sgh.model.Pessoa;

@Stateless
public class PessoaDao extends GenericDao<Pessoa>{	
	
    public PessoaDao() throws Exception {
    	super();
    }    
      
    public Medico getMedico(Integer id) throws Exception{
    	String consulta = "from Medico m where m.id = :id " +
    										  "and m.estaAtivo = true";
    	return (Medico)super.session.createQuery(consulta).setParameter("id", id).uniqueResult();
    }
    
    @SuppressWarnings("unchecked")
	public List<Medico> getMedicos() {
    	String consulta = " from Medico m order by nome";
    	
    	return (List<Medico>) super.session.createQuery(consulta);
    }

	@SuppressWarnings("unchecked")
	public List<Paciente> getPacientes() {
		String consulta = " from Paciente p order by nome";
    	
    	return (List<Paciente>) super.session.createQuery(consulta);
	}
    
}
