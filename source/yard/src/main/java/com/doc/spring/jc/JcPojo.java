/**
 * 
 */
package com.doc.spring.jc;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Elmehdi.zangui
 *
 */
@Component
@Scope("prototype")
public class JcPojo {

	public JcPojo() {
	}

	public JcPojo(String str) {
		System.out.println("str => " + str);
	}

}
