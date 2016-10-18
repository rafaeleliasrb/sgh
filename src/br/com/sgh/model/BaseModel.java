package br.com.sgh.model;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.apache.commons.beanutils.BeanUtils;

@MappedSuperclass
public abstract class BaseModel implements Serializable {

	private static final long serialVersionUID = 7736710221797500486L;
	
	@Column(nullable=false, name="esta_ativo")
	protected Boolean estaAtivo = true;

	public Boolean getEstaAtivo() {
		return estaAtivo;
	}

	public void setEstaAtivo(Boolean estaAtivo) {
		this.estaAtivo = estaAtivo;
	}
	
	@Override
	public Object clone() {
		try {
			Object obj = new Object();
			BeanUtils.copyProperties(obj, this);
			return obj;
		} catch (IllegalAccessException e) {
			return null;
		} catch (InvocationTargetException e) {
			return null;
		}
	}
	
}
