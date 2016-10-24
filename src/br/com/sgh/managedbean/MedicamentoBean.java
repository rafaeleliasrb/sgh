package br.com.sgh.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.com.sgh.dao.MedicamentoDao;
import br.com.sgh.model.Medicamento;

@ManagedBean(name="medicamentoBean")
@RequestScoped
public class MedicamentoBean {

	private List<Medicamento> listaMedicamentos;
	
	@Inject
	private MedicamentoDao medicamentoDao;

	public List<Medicamento> getListaMedicamentos() {
		if(listaMedicamentos == null){
			listaMedicamentos = medicamentoDao.listarTodos(Medicamento.class);			
		}
		return listaMedicamentos;
	}

	public void setListaMedicamentos(List<Medicamento> listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
	}		
}
