package br.com.sgh.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.com.sgh.model.Especialidade;
import br.com.sgh.model.Medico;

@Stateless
public class EspecialidadeDao extends GenericDao<Especialidade> {

	public EspecialidadeDao() throws Exception {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Especialidade> listar(Medico medico){
    	String consulta = "select m.especialidades from Medico m WHERE m=:medico";    	
		List<Especialidade> especialidades = (List<Especialidade>) super.getSession().createQuery(consulta)
				.setParameter("medico", medico).list();
    	return especialidades;

	}
}
