/**
 * 
 */
package com.doc.spring.aop.target;

import java.io.Serializable;
import java.nio.channels.IllegalSelectorException;

import org.springframework.stereotype.Component;

/**
 * @author Elmehdi.zangui
 *
 */
@Component
public class AopTargetedObject implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;

	public String whoIam(MostUseLessPojo useless) {
		return AopTargetedObject.class.getName() + " "+useless.getName();
	}
}
