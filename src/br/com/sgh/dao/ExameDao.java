package br.com.sgh.dao;

import javax.ejb.Stateless;

import br.com.sgh.model.Exame;

@Stateless
public class ExameDao extends GenericDao<Exame> {

	public ExameDao() throws Exception {
		super();
	}

}
