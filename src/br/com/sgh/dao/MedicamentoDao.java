package br.com.sgh.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.com.sgh.model.Medicamento;

@Stateless
public class MedicamentoDao extends GenericDao<Medicamento> {

	public MedicamentoDao() throws Exception {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Medicamento> listarTodos() {
		List<Medicamento> listaTodos = getSession()
				.createQuery("from Medicamento m where m.estaAtivo = true  ORDER BY m.nome").setCacheable(true).list();
		return listaTodos;
	}

	@SuppressWarnings("unchecked")
	public List<Medicamento> listarTodos(int offset, int length) {
		List<Medicamento> listaTodos = getSession()
				.createQuery("from Medicamento m where m.estaAtivo = true ORDER BY m.nome").setFirstResult(offset)
				.setMaxResults(length).setCacheable(false).list();
		return listaTodos;
	}

	public Medicamento obter(Integer id) {
		return (Medicamento) getSession().load(Medicamento.class, id);
	}

	public Long obterQuantidadeTotal() {
		Long quantidadeTotal = (Long) getSession()
				.createQuery("SELECT count(m) from Medicamento m where m.estaAtivo = true").uniqueResult();
		return quantidadeTotal;
	}
}
