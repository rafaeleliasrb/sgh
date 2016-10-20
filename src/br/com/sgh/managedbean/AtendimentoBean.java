package br.com.sgh.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sgh.model.Atendimento;

@ManagedBean
@ViewScoped
public class AtendimentoBean {

	private List<Atendimento> listaAtendimento;
	
	private String cpf;
	
	private String senha;

	public List<Atendimento> getListaAtendimento() {
		return listaAtendimento;
	}

	public void setListaAtendimento(List<Atendimento> listaAtendimento) {
		this.listaAtendimento = listaAtendimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
		
}
