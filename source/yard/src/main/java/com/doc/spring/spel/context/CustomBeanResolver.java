/**
 * 
 */
package com.doc.spring.spel.context;

import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;

import com.doc.spring.pojo.SimplePojo;

/**
 * @author Elmehdi.zangui
 *
 */
public class CustomBeanResolver  implements BeanResolver{

	public Object resolve(EvaluationContext context, String beanName) throws AccessException {
		SimplePojo pojo = new SimplePojo();
		pojo.setName("Created in customBeanResolver for beanName : "+ beanName);
		return pojo;
	}

}
