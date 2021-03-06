package br.com.sgh.model;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
@PrimaryKeyJoinColumn(name="id_pessoa")
public class Medico extends Pessoa {

	private static final long serialVersionUID = -4739028174034819209L;

	@Column(name = "crm")
	@Basic(optional = false)
	private String crm;

	@ManyToMany(
			fetch = FetchType.LAZY,	
			targetEntity=br.com.sgh.model.Especialidade.class,
			cascade={CascadeType.PERSIST, CascadeType.MERGE}
			)
	@JoinTable(
			name="medico_especialidade",
			joinColumns=@JoinColumn(name="id_medico"),
			inverseJoinColumns=@JoinColumn(name="id_especialidade")	   
			)
	@OrderBy("nome")
	private Set<Especialidade> especialidades;

	public Medico() {}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Set<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Set<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}   
	
	public String getEspecialidadesString(){
		if(especialidades == null || especialidades.isEmpty()){
			return "";
		}
		StringBuilder retorno = new StringBuilder("");
		for (Especialidade especialidade : especialidades) {
			retorno.append(especialidade.getNome());
			retorno.append(", ");
		}
		return retorno.toString().substring(0, (retorno.length()-2));
	}

	@Override
	public String toString() {
		return "Medico [crm=" + crm + ", nome=" + nome + "]";
	}		
	
}