package br.com.sgh.managedbean;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.sgh.dao.MedicamentoDao;
import br.com.sgh.model.Medicamento;

@ManagedBean(name="medicamentoBean")
@ViewScoped
public class MedicamentoBean {

	private List<Medicamento> listaMedicamentos;

	private LazyDataModel<Medicamento> lazyDataModel;
	@Inject
	private MedicamentoDao medicamentoDao;

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
}
