package br.com.sgh.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sgh.factory.HibernateFactory;

public class TransactionPhaseListener implements PhaseListener{

	private static final long serialVersionUID = -8988166001067794952L;

	private Transaction transaction;
	
	@Override
	public void afterPhase(PhaseEvent event) {
		if(event != null && event.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
			if(transaction != null){
				transaction.commit();
			}
		}		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		if(event != null && event.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
	    	Session session = HibernateFactory.getHibernateSession();
	    	transaction = session.beginTransaction();
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
