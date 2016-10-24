package br.com.sgh.managedbean;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class BaseBean {

	protected FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	
	protected  ELContext getELContext(){
		return getFacesContext().getELContext();
	}
	
	protected  Application getApplication(){
		return getFacesContext().getApplication();
	}
	
	protected  void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	protected  void addErrorMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	protected Object getValue(String ELExpression){
		ExpressionFactory expressionFactory = getApplication().getExpressionFactory();
		ValueExpression exp = expressionFactory.createValueExpression(getELContext(), ELExpression, Object.class);
		Object value = exp.getValue(getELContext());
		return value;
	}

}
