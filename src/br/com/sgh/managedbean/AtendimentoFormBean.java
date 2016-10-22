package br.com.sgh.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sgh.dao.AtendimentoDao;
import br.com.sgh.dao.PessoaDao;
import br.com.sgh.model.Atendimento;
import br.com.sgh.model.Medico;
import br.com.sgh.model.Paciente;

@Named
@ViewScoped
public class AtendimentoFormBean implements Serializable{

	private static final long serialVersionUID = -905937529431573051L;

	@Inject
	private AtendimentoDao atendimentoDao;
	@Inject
	private PessoaDao pessoaDao;
	
	private List<Medico> medicos;
	private List<Paciente> pacientes;
	private Atendimento atendimento;

	public void salvar() {
		atendimentoDao.salvar(atendimento);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Atendimento salvo com sucesso.", null));
	}
	
	public List<Medico> getMedicos() {
		if(medicos == null || medicos.isEmpty()) {
			medicos = pessoaDao.getMedicos();
		}
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public List<Paciente> getPacientes() {
		if(pacientes == null || pacientes.isEmpty()) {
			pacientes = pessoaDao.getPacientes();
		}
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}
