/**
 * 
 */
package com.doc.spring.xml.pojo;

import java.util.Properties;

import com.doc.spring.instance.Pojo;

/**
 * @author Elmehdi.zangui
 *
 */
public class XmlPropsInheritsPojo  extends Pojo{
	
	private Properties props;

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}
}
