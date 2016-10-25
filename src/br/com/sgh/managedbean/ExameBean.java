package br.com.sgh.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sgh.dao.AtendimentoDao;
import br.com.sgh.dao.ExameDao;
import br.com.sgh.dao.TipoExameDao;
import br.com.sgh.model.Atendimento;
import br.com.sgh.model.Exame;
import br.com.sgh.model.TipoExame;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ExameBean extends BaseBean implements Serializable {
	
	@Inject
	private ExameDao exameDao;
	@Inject
	private AtendimentoDao atendimentoDao;
	@Inject
	private TipoExameDao tipoExameDao;
	
	private Exame exame = new Exame();
	private Atendimento atendimento;
	private List<TipoExame> tipoExames;
	private Integer tipoExameId;
	
	@PostConstruct
	public void init() {
		Integer id = (Integer) FacesContext.getCurrentInstance()
				.getExternalContext().getFlash().get("atendimentoId");
		if(id != null) {
			atendimento = atendimentoDao.getAtendimento(id);
		}
	}
	
	public String salvar() {
		TipoExame tipoExame = tipoExameDao.getTipoExame(getTipoExameId());
		exame.setTipoExame(tipoExame);
		
		
		exame.setAtendimento(atendimento);
		
		exameDao.salvar(exame);
		addMessage("Exame salvo com sucesso", "");
		
		FacesContext.getCurrentInstance()
					.getExternalContext()
					.getFlash()
					.put("atendimentoId", atendimento.getId());
		
		return "atendimendoCadastrar";
	}
	
	public Exame getExame() {
		return exame;
	}
	public void setExame(Exame exame) {
		this.exame = exame;
	}
	
	public Atendimento getAtendimento() {
		return atendimento;
	}
	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public List<TipoExame> getTipoExames() {
		if(tipoExames == null) {
			tipoExames = tipoExameDao.listarTodos(TipoExame.class);
		}
		return tipoExames;
	}

	public void setTipoExames(List<TipoExame> tipoExames) {
		this.tipoExames = tipoExames;
	}

	public Integer getTipoExameId() {
		return tipoExameId;
	}

	public void setTipoExameId(Integer tipoExameId) {
		this.tipoExameId = tipoExameId;
	}
}
