package br.com.sgh.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sgh.dao.AtendimentoDao;
import br.com.sgh.model.Atendimento;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class AtendimentoBean implements Serializable{

	@Inject
	private AtendimentoDao atendimentoDao;
	
	private List<Atendimento> atendimentos;
	
	public List<Atendimento> getAtendimentos() {
		if(atendimentos == null) {
			atendimentos = atendimentoDao.listarTodos(Atendimento.class);
		}
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> listaAtendimento) {
		this.atendimentos = listaAtendimento;
	}
}
