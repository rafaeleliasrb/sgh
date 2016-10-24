package br.com.sgh.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sgh.dao.AtendimentoDao;
import br.com.sgh.dao.PessoaDao;
import br.com.sgh.model.Atendimento;
import br.com.sgh.model.Medico;
import br.com.sgh.model.Paciente;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class AtendimentoFormBean implements Serializable {

	@Inject
	private AtendimentoDao atendimentoDao;
	@Inject
	private PessoaDao pessoaDao;
	
	private List<Medico> medicos;
	private Integer medicoId;
	private List<Paciente> pacientes;
	private Integer pacienteId;
	private Atendimento atendimento = new Atendimento();

	public void salvar() {
		Medico medico = pessoaDao.getMedico(medicoId);
		atendimento.setMedico(medico);
		Paciente paciente = pessoaDao.getPaciente(pacienteId);
		atendimento.setPaciente(paciente);
		
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

	public Integer getMedicoId() {
		return medicoId;
	}

	public void setMedicoId(Integer medicoId) {
		this.medicoId = medicoId;
	}

	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}

}
