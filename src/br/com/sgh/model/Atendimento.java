package br.com.sgh.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "atendimento")
public class Atendimento extends BaseModel implements Serializable { 

	private static final long serialVersionUID = 980743033586457684L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atendimento")
    private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_medico")
	@Basic(optional = false)
	private Medico medico;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_paciente")
	@Basic(optional = false)
	private Paciente paciente;
	
	@Column(name = "data_atendimento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtendimento;
	
	@OneToMany(cascade = CascadeType.ALL, 
			   mappedBy = "atendimento", 
			   fetch=FetchType.LAZY)
	private List<Medicacao> medicacoes;

	public Atendimento() {
		super(); 
	}

	public Atendimento(Medico medico, Paciente paciente) {
		super();
		this.medico = medico;
		this.paciente = paciente;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public List<Medicacao> getMedicacoes() {
		return medicacoes;
	}

	public void setMedicacoes(List<Medicacao> medicacoes) {
		this.medicacoes = medicacoes;
	}
}
