package br.com.sgh.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicacao")
public class Medicacao extends BaseModel implements Serializable{

	private static final long serialVersionUID = 3996841451065093039L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicacao")
    private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_atendimento")
	private Atendimento atendimento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_medicamento")
	private Medicamento medicamento;
	
	@Column(name = "dosagem")
	private Double dosagem;
	
	@Column(name = "intervalo_dosagem")
	private Integer intervaloDosagem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Double getDosagem() {
		return dosagem;
	}

	public void setDosagem(Double dosagem) {
		this.dosagem = dosagem;
	}

	public Integer getIntervaloDosagem() {
		return intervaloDosagem;
	}

	public void setIntervaloDosagem(Integer intervaloDosagem) {
		this.intervaloDosagem = intervaloDosagem;
	}
}
