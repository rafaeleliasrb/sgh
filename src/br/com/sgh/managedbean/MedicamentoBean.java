package br.com.sgh.managedbean;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.sgh.dao.MedicamentoDao;
import br.com.sgh.model.Medicamento;

@ManagedBean(name="medicamentoBean")
@SessionScoped
public class MedicamentoBean extends BaseBean {

	private List<Medicamento> listaMedicamentos;

	private LazyDataModel<Medicamento> lazyDataModel;

	@Inject
	private MedicamentoDao medicamentoDao;

	private Medicamento medicamento;
	
	public void salvar(ActionEvent event){
		try{
			medicamentoDao.salvar(medicamento);
			addMessage("Medicamento Salvo", "Medicamento " + medicamento.getNome() + " salvo com sucesso!");
		}catch(Exception e){
			System.out.println("Erro ao salvar: " + (e.getCause()!=null?e.getCause().getMessage():e.getMessage()));
			addErrorMessage("Erro ao salvar Medicamento", "Erro ao salvar Medicamento");
		}
	}

	public void excluir(ActionEvent event){
		try{
			Medicamento medicamentoASerExcluido = (Medicamento)getValue("#{medicamento}");
			medicamentoDao.deletar(medicamentoASerExcluido);
			addMessage("Medicamento Excluído", medicamentoASerExcluido.getNome() + " excluído com sucesso!");
		}catch(Exception e){
			System.out.println("Erro ao excluir: " + (e.getCause()!=null?e.getCause().getMessage():e.getMessage()));
			e.printStackTrace();
			addErrorMessage("Erro ao excluir Medicamento", "Erro ao excluir Medicamento");
		}		
	}

	public String editar(){
		medicamento = (Medicamento)getValue("#{medicamento}");
		return "medicamentoCadastrar?faces-redirect=true";
	}
	
	public List<Medicamento> getListaMedicamentos() {
		if(listaMedicamentos == null){
			listaMedicamentos = medicamentoDao.listarTodos();			
		}
		return listaMedicamentos;
	}

	public void setListaMedicamentos(List<Medicamento> listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
	}

	public LazyDataModel<Medicamento> getLazyDataModel() {
		if(lazyDataModel == null){
			lazyDataModel = new LazyDataModel<Medicamento>(){
				private static final long serialVersionUID = -5786183477810450507L;

				@SuppressWarnings("rawtypes")
				@Override
				public List<Medicamento> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map filters) {
					List<Medicamento> data = medicamentoDao.listarTodos(first, pageSize);
					return data;
				}
				
			};
			lazyDataModel.setRowCount(medicamentoDao.obterQuantidadeTotal().intValue());
		}
		return lazyDataModel;
	}

	public void setLazyDataModel(LazyDataModel<Medicamento> lazyDataModel) {
		this.lazyDataModel = lazyDataModel;
	}

	public Medicamento getMedicamento() {
		if(medicamento == null){
			medicamento = new Medicamento();
		}
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}			
}
