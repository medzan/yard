package com.doc.spring;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.AccessException;
import org.springframework.expression.ConstructorResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.MethodResolver;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.doc.spring.pojo.CallPojo;
import com.doc.spring.pojo.SimplePojo;
import com.doc.spring.spel.resolver.CustomMethodResolver;

import junit.framework.Assert;

public class SpELTests {

	@Test
	public void basicExpresstionTest() {
		SimplePojo pojo = new SimplePojo();
		pojo.setName("Simple");
		EvaluationContext context = new StandardEvaluationContext(pojo);
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("name");
		String result = exp.getValue(context, String.class);
		Assert.assertEquals(pojo.getName(), result);
		result = exp.getValue(pojo, String.class);
		Assert.assertEquals(pojo.getName(), result);
	}

	@Test
	public void extendExpressionTest() throws AccessException {
		SimplePojo pojo = new SimplePojo();
		SimplePojo pojo2 = new SimplePojo();

		CallPojo callpojo = new CallPojo();
		pojo.setName("Simple");
		StandardEvaluationContext context = new StandardEvaluationContext(pojo);
		MethodResolver resolver = new CustomMethodResolver();
		List<TypeDescriptor> types = new ArrayList<TypeDescriptor>();
		context.addMethodResolver(resolver);
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("call()");
		String result = exp.getValue(context, String.class);
		System.out.println(result);

	}
}
