package br.com.sgh.util;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.hibernate.type.Type;

public class AuditInterceptor extends EmptyInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1016359394597759588L;

	private int updates;
	private int creates;
	private int loads;

	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		// do nothing
	}

	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {

		updates++;
		for (int i = 0; i < propertyNames.length; i++) {
			if ("lastUpdateTimestamp".equals(propertyNames[i])) {
				currentState[i] = new Date();
				return true;
			}
		}
		return false;
	}

	public boolean onLoad(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		
		loads++;
		
		return false;
	}

	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {

		creates++;
		for (int i = 0; i < propertyNames.length; i++) {
			if ("createTimestamp".equals(propertyNames[i])) {

				state[i] = new Date();
				System.out.println("teste========" + state[i]);
				return true;
			}
		}
		return false;
	}
	
	

	public void afterTransactionCompletion(Transaction tx) {
		//if (tx.wasCommitted()) {
		if (tx.getStatus().equals(TransactionStatus.COMMITTED)) {
			System.out.println("Creations: " + creates + ", Updates: "
					+ updates + " Loads: " + loads);
		}
		updates = 0;
		creates = 0;
		loads = 0;
	}

}
