package br.com.sgh.managedbean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.primefaces.model.DualListModel;

import br.com.sgh.dao.EspecialidadeDao;
import br.com.sgh.dao.PessoaDao;
import br.com.sgh.model.Especialidade;
import br.com.sgh.model.Medico;

@ManagedBean(name="medicoBean")
@SessionScoped
public class MedicoBean extends BaseBean{

	private List<Medico> listaMedicos;

	@Inject
	private PessoaDao pessoaDao;

	@Inject
	private EspecialidadeDao especialidadeDao;
	
	private Medico medico;

	private DualListModel<Especialidade> especialidades;
	
	public void salvar(ActionEvent event){
		try{
			List<Especialidade> listEspecialidade = especialidades.getTarget();
			Set<Especialidade> setEspecialidades = new HashSet<Especialidade>(listEspecialidade);
			medico.setEspecialidades(setEspecialidades);
			pessoaDao.salvar(medico);
			addMessage("Médico Salvo", "médico " + medico.getNome() + " salvo com sucesso!");
			listaMedicos = null;
		}catch(Exception e){
			System.out.println("Erro ao salvar: " + (e.getCause()!=null?e.getCause().getMessage():e.getMessage()));
			addErrorMessage("Erro ao salvar médico", "Erro ao salvar médico");
		}
	}

	public void excluir(ActionEvent event){
		try{
			Medico medicoASerExcluido = (Medico)getValue("#{medico}");
			pessoaDao.deletar(medicoASerExcluido);
			addMessage("Médico Excluído", medicoASerExcluido.getNome() + " excluído com sucesso!");
			listaMedicos = null;
		}catch(Exception e){
			System.out.println("Erro ao excluir: " + (e.getCause()!=null?e.getCause().getMessage():e.getMessage()));
			e.printStackTrace();
			addErrorMessage("Erro ao excluir médico", "Erro ao excluir médico");
		}		
	}

	public String novo(){
		medico = new Medico();
		especialidades = null;
		return "medicoCadastrar?faces-redirect=true";
	}
	
	public String editar(){
		medico = (Medico)getValue("#{medico}");
		especialidades = null;
		return "medicoCadastrar?faces-redirect=true";
	}

	public List<Medico> getListaMedicos() {
		if(listaMedicos == null){
			listaMedicos = pessoaDao.getMedicos();
		}
		return listaMedicos;
	}

	public void setListaMedicos(List<Medico> listaMedicos) {		
		this.listaMedicos = listaMedicos;
	}

	public Medico getMedico() {
		if(medico == null){
			medico = new Medico();
		}
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public DualListModel<Especialidade> getEspecialidades() {
		if(especialidades == null){
			List<Especialidade> listaEspecialidade = especialidadeDao.listarTodos(Especialidade.class);
			List<Especialidade> listaEspecialidadeMedico = null;
			if(medico==null || medico.getId() ==null){
				listaEspecialidadeMedico = new ArrayList<Especialidade>();
			}else{
				listaEspecialidadeMedico = especialidadeDao.listar(medico);				
			}
			listaEspecialidade.removeAll(listaEspecialidadeMedico);
			especialidades = new DualListModel<Especialidade>(listaEspecialidade, listaEspecialidadeMedico);
		}
		return especialidades;
	}

	public void setEspecialidades(DualListModel<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}
	
}
