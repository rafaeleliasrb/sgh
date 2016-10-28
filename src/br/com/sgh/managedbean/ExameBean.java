package br.com.sgh.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
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
	private Integer idAtendimento;
	
	public void init() {
		setIdAtendimento((Integer) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getFlash()
				.get("atendimentoId"));
		if(getIdAtendimento() != null) {
			atendimento = atendimentoDao.getAtendimento(getIdAtendimento());
		}
	}
	
	public String salvar() {
		TipoExame tipoExame = tipoExameDao.getTipoExame(getTipoExameId());
		exame.setTipoExame(tipoExame);
		
		atendimento = atendimentoDao.getAtendimento(idAtendimento);
		List<Exame> exames = atendimento.getExames()==null?
				(new ArrayList<Exame>()):atendimento.getExames();
		exames.add(exame);
		atendimento.setExames(exames);
		exame.setAtendimento(atendimento);
		exameDao.salvar(exame);
		atendimentoDao.salvar(atendimento);
		
		addMessage("Exame salvo com sucesso", "");
		
		FacesContext.getCurrentInstance()
					.getExternalContext()
					.getFlash()
					.put("atendimentoId", getIdAtendimento());
		
		return "atendimendoCadastrar?faces-redirect=true";
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

	public Integer getIdAtendimento() {
		return idAtendimento;
	}

	public void setIdAtendimento(Integer idAtendimento) {
		this.idAtendimento = idAtendimento;
	}
}
