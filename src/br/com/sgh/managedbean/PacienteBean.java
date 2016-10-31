package br.com.sgh.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import br.com.sgh.dao.PessoaDao;
import br.com.sgh.model.Medico;
import br.com.sgh.model.Paciente;


@ManagedBean(name="pacienteBean")
@SessionScoped
public class PacienteBean extends BaseBean{

	private List<Paciente> listaPacientes;

	@Inject
	private PessoaDao pessoaDao;

	private Paciente paciente;

	public void salvar(ActionEvent event){
		try{
			pessoaDao.salvar(paciente);
			addMessage("Paciente Salvo", "paciente " + paciente.getNome() + " salvo com sucesso!");
			listaPacientes = null;
		}catch(Exception e){
			System.out.println("Erro ao salvar: " + (e.getCause()!=null?e.getCause().getMessage():e.getMessage()));
			addErrorMessage("Erro ao salvar paciente", "Erro ao salvar paciente");
		}
	}

	public void excluir(ActionEvent event){
		try{
			Paciente pacienteASerExcluido = (Paciente)getValue("#{paciente}");
			pessoaDao.deletar(pacienteASerExcluido);
			addMessage("Paciente Excluído", pacienteASerExcluido.getNome() + " excluído com sucesso!");
			listaPacientes = null;
		}catch(Exception e){
			System.out.println("Erro ao excluir: " + (e.getCause()!=null?e.getCause().getMessage():e.getMessage()));
			e.printStackTrace();
			addErrorMessage("Erro ao excluir paciente", "Erro ao excluir paciente");
		}		
	}

	public String novo(){
		paciente = new Paciente();
		return "pacienteCadastrar?faces-redirect=true";
	}

	public String editar(){
		paciente = (Paciente)getValue("#{paciente}");
		return "pacienteCadastrar?faces-redirect=true";
	}

	public List<Paciente> getListaPacientes() {
		if(listaPacientes ==null){
			listaPacientes = pessoaDao.getPacientes();
		}
		return listaPacientes;
	}

	public void setListaPacientes(List<Paciente> listaPacientes) {
		if(listaPacientes == null){
			listaPacientes = pessoaDao.getPacientes();
		}
		this.listaPacientes = listaPacientes;
	}

	public Paciente getPaciente() {
		if(paciente == null){
			paciente = new Paciente();
		}
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	
}
