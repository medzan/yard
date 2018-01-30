package com.doc.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.AccessException;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.MethodResolver;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
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

	@Test
	public void compileOffAndOnTest() {
		SimplePojo p1 = new SimplePojo();
		CallPojo c1 = new CallPojo();
		SimplePojo p2 = new SimplePojo();
		p2.setName("p2");
		c1.getList().add(p2);
		p1.getList().add(c1);

		SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.OFF, null);
		parse("OFF1", new SpelExpressionParser(config), p1);
		parse("OFF2", new SpelExpressionParser(config), p1);

		config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, null);
		parse("IMMEDIATE1", new SpelExpressionParser(config), p1);
		parse("IMMEDIATE2", new SpelExpressionParser(config), p1);
		config = new SpelParserConfiguration(SpelCompilerMode.MIXED, null);
		parse("MIXED1", new SpelExpressionParser(config), p1);
		parse("MIXED2", new SpelExpressionParser(config), p1);

	}

	public void parse(String msg, ExpressionParser parser, SimplePojo simplepojo) {
		final long startTime = System.nanoTime();
		String value = "";
		for (int i = 0; i < 500000; i++) {
			Expression result = parser.parseExpression("list[0].list[0].name");
			value = result.getValue(simplepojo, String.class);
		}
		long miSeconds = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
		System.out.println(msg + " => miSeconds " + miSeconds + " for value " + value);
	}
}
