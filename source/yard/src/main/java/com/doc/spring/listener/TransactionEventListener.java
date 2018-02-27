/**
 * 
 */
package com.doc.spring.listener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.doc.spring.model.Simple;

/**
 * @author Elmehdi.zangui
 *
 */
@Component
public class TransactionEventListener {

	@TransactionalEventListener(phase=TransactionPhase.BEFORE_COMMIT)
	public void beforeCommit(SimpleEvent  e) {
		System.out.println("listening TO BEFORE_COMMIT" );
	}
	
	@TransactionalEventListener(phase=TransactionPhase.AFTER_COMMIT)
	public void afterCommit(SimpleEvent  e) {
		System.out.println("listening TO AFTER_COMMIT" );
	}
	
	
}
