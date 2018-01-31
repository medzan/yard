/**
 * 
 */
package com.doc.spring.aop.target;

import org.springframework.stereotype.Component;

/**
 * @author Elmehdi.zangui
 *
 */
@Component
public class AopCaller {

	private AopTargetedObject target;
	
	public String AskYourTarget() {
		return target.whoIam(new MostUseLessPojo("Nothing"));
	}
	
	public AopCaller(AopTargetedObject target) {
		this.target=target;
//		target.whoIam();
	}
	public AopTargetedObject getTarget() {
		return target;
	}
	
	public void setTarget(AopTargetedObject target) {
		this.target = target;
	}
}
