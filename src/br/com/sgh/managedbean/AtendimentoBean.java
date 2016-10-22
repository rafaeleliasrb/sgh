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
	private Atendimento atendimento;
	
	public void listarAtendimentos() {
		atendimentos = atendimentoDao.listarTodos(Atendimento.class);
	}
	
	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> listaAtendimento) {
		this.atendimentos = listaAtendimento;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}	
}
