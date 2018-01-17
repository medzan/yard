/**
 * 
 */
package com.doc.spring.groovy;

import com.doc.spring.instance.Pojo;

/**
 * @author Elmehdi.zangui
 *
 */
public class GroovyEmbeddedPojo extends Pojo{
	private GroovyPojo groobyPojo;

	public GroovyPojo getGroobyPojo() {
		return groobyPojo;
	}

	public void setGroobyPojo(GroovyPojo groobyPojo) {
		this.groobyPojo = groobyPojo;
	}
}
