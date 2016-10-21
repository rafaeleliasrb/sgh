package br.com.sgh.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sgh.model.Atendimento;

@ManagedBean
@ViewScoped
public class AtendimentoBean {

	private List<Atendimento> listaAtendimento;
	
	public void listarAtendimentos() {
		
	}
	
	public List<Atendimento> getListaAtendimento() {
		return listaAtendimento;
	}

	public void setListaAtendimento(List<Atendimento> listaAtendimento) {
		this.listaAtendimento = listaAtendimento;
	}	
}
