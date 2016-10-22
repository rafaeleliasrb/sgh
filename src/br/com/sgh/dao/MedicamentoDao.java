package br.com.sgh.dao;

import javax.ejb.Stateless;

import br.com.sgh.model.Medicamento;

@Stateless
public class MedicamentoDao extends GenericDao<Medicamento> {

	public MedicamentoDao() throws Exception {
		super();
	}

}
