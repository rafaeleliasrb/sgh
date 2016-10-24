package br.com.sgh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import br.com.sgh.model.Especialidade;

@FacesConverter("EspecialidadeMedicoConverter")
public class EspecialidadeMedicoConverter implements Converter{

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
	    Object ret = null;
	    if (arg1 instanceof PickList) {
	        Object dualList = ((PickList) arg1).getValue();
	        DualListModel dl = (DualListModel) dualList;
	        for (Object o : dl.getSource()) {
	            String nome = ((Especialidade) o).getNome();
	            if (arg2.equals(nome)) {
	                ret = o;
	                break;
	            }
	        }
	        if (ret == null)
	            for (Object o : dl.getTarget()) {
	                String nome = ((Especialidade) o).getNome();
	                if (arg2.equals(nome)) {
	                    ret = o;
	                    break;
	                }
	            }
	    }
	    return ret;
	}
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
	    String str = "";
	    if (arg2 instanceof Especialidade) {
	        str = "" + ((Especialidade) arg2).getNome();
	    }
	    return str;
	}
}
