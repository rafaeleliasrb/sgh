package br.com.sgh.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sgh.dao.AtendimentoDao;
import br.com.sgh.model.Atendimento;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class AtendimentoBean extends BaseBean implements Serializable {
	
	@Inject
	private AtendimentoDao atendimentoDao;
	
	private List<Atendimento> atendimentos;
	
	public String editar(Atendimento atendimento) {
		FacesContext.getCurrentInstance()
					.getExternalContext()
					.getFlash()
					.put("atendimentoId", atendimento.getId());
		
		return "atendimentoCadastrar?faces-redirect=true";
	}
	
	public void excluir(Atendimento atendimento) {
		atendimentoDao.deletar(atendimento);
		atendimentos = atendimentoDao.listarTodos(Atendimento.class);
		
		addMessage("Atendimento excluido com sucesso.", "");
	}
	
	public List<Atendimento> getAtendimentos() {
		if(atendimentos == null) {
			atendimentos = atendimentoDao.listarTodos(Atendimento.class);
		}
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> listaAtendimento) {
		this.atendimentos = listaAtendimento;
	}
}
