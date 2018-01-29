/**
 * 
 */
package com.doc.spring.spel.resolver;

import java.util.List;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.AccessException;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.MethodExecutor;
import org.springframework.expression.MethodResolver;
import org.springframework.expression.TypedValue;

/**
 * @author Elmehdi.zangui
 *
 */
public class CustomMethodResolver implements MethodResolver {

	public MethodExecutor resolve(EvaluationContext context, Object targetObject, String name,
			List<TypeDescriptor> argumentTypes) throws AccessException {
		System.out.println("called");

		return null;
	}

}
