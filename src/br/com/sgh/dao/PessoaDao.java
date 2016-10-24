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
    	return (Medico)super.getSession().createQuery(consulta).setParameter("id", id).uniqueResult();
    }
    
    @SuppressWarnings("unchecked")
	public List<Medico> getMedicos() {
    	String consulta = " from Medico m order by nome";
    	
    	return (List<Medico>) super.getSession().createQuery(consulta).list();
    }

    @SuppressWarnings("unchecked")
	public List<Medico> getMedicosComEspecialidades() {
    	String consulta = "select m from Medico m left join fetch m.especialidades order by nome";
    	
    	return (List<Medico>) super.getSession().createQuery(consulta).list();
    }

	@SuppressWarnings("unchecked")
	public List<Paciente> getPacientes() {
		String consulta = " from Paciente p order by nome";
    	
    	return (List<Paciente>) super.getSession().createQuery(consulta).list();
	}
    
}
