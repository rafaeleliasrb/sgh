package br.com.sgh.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
@PrimaryKeyJoinColumn(name="id_pessoa")
public class Paciente extends Pessoa {

	private static final long serialVersionUID = -3197829531850491539L;

    @Column(name = "matricula")
    @Basic(optional = false)
    private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
