package br.com.sgh.dao;

import javax.ejb.Stateless;

import br.com.sgh.model.TipoExame;

@Stateless
public class TipoExameDao extends GenericDao<TipoExame>{

	public TipoExameDao() throws Exception {
		super();
	}

	public TipoExame getTipoExame(Integer id) {
		return (TipoExame) super.getSession().load(TipoExame.class, id);
	}

}
