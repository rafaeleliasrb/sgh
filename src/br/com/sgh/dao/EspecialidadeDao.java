package br.com.sgh.dao;

import javax.ejb.Stateless;

import br.com.sgh.model.Especialidade;

@Stateless
public class EspecialidadeDao extends GenericDao<Especialidade> {

	public EspecialidadeDao() throws Exception {
		super();
	}

}
