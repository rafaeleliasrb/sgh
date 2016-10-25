package br.com.sgh.dao;

import javax.ejb.Stateless;
import br.com.sgh.model.Atendimento;

@Stateless
public class AtendimentoDao extends GenericDao<Atendimento> {

	public AtendimentoDao() throws Exception {
		super();
	}

	public Atendimento getAtendimento(Integer id) {
		return (Atendimento) super.getSession().load(Atendimento.class, id);
	}
}
