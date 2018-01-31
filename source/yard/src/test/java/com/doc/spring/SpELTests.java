package com.doc.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.MethodResolver;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.ConcurrentReferenceHashMap;

import com.doc.spring.pojo.CallPojo;
import com.doc.spring.pojo.SimplePojo;
import com.doc.spring.spel.context.CustomBeanResolver;
import com.doc.spring.spel.functions.SpelFunctionUtils;
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

	@Test
	public void spElFunctionTests() throws NoSuchMethodException, SecurityException {
		StandardEvaluationContext context = new StandardEvaluationContext();
		ExpressionParser parser = new SpelExpressionParser();
		context.registerFunction("splitValues",
				SpelFunctionUtils.class.getDeclaredMethod("splitValues", new Class[] { String.class, String[].class }));

		String resut = parser.parseExpression("#splitValues('-SP-','This','is','SPEL')").getValue(context,
				String.class);
		Assert.assertNotNull(resut);
		Assert.assertEquals("This-SP-is-SP-SPEL", resut);

	}

	@Test
	public void spElBeanResolver() {
		StandardEvaluationContext context = new StandardEvaluationContext();
		BeanResolver beanResolver = new CustomBeanResolver();
		context.setBeanResolver(beanResolver);
		ExpressionParser parser = new SpelExpressionParser();
		String value = parser.parseExpression("null?:&SimplePP.name").getValue(context, String.class);
		Assert.assertNotNull(value);
		Assert.assertEquals("Created in customBeanResolver for beanName : &SimplePP", value);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void spElSelectiontsts() {
		ExpressionParser parser = new SpelExpressionParser();
		SimplePojo p = new SimplePojo("pojo");
		SimplePojo p2 = new SimplePojo("pojo2");
		SimplePojo p3 = new SimplePojo("unknown");
		List<SimplePojo> list = new ArrayList<SimplePojo>();
		list.add(p);
		list.add(p2);
		list.add(p3);
		Map<String,SimplePojo> map = new ConcurrentReferenceHashMap<String, SimplePojo>();
		map.put("p", p);
		map.put("p2", p2);
		map.put("p3", p3);
		
		List<SimplePojo> listResult=  ((List<SimplePojo>) parser.parseExpression("#this.?[name.substring(0,2)=='po']").getValue(list));
		Assert.assertNotNull(listResult);
		Assert.assertTrue(listResult.size()==2);
		Map<String,SimplePojo> mapResult = (Map<String, SimplePojo>) parser.parseExpression("#this.?[value.name=='pojo']").getValue(map);
		Assert.assertNotNull(mapResult);
		Assert.assertTrue(mapResult.size()==1);
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void speElProjectionTests() {
		ExpressionParser parser = new SpelExpressionParser();
		SimplePojo p = new SimplePojo("pojo");
		p.setId(1);
		SimplePojo p2 = new SimplePojo("pojo");
		SimplePojo p3 = new SimplePojo("unknown");
		List<SimplePojo> list = new ArrayList<SimplePojo>();
		list.add(p);
		list.add(p2);
		list.add(p3);
		Map<String,SimplePojo> map = new ConcurrentReferenceHashMap<String, SimplePojo>();
		map.put("p", p);
		map.put("p2", p2);
		map.put("p3", p3);
		List<String> values = (List<String>) parser.parseExpression("#this.![name]").getValue(list);
		Assert.assertTrue(values.size() == 3 );
		Assert.assertTrue(values.get(0) == "pojo" );
		List<Integer> Idvalues = (List<Integer>) parser.parseExpression("#this.![id]").getValue(list);
		Assert.assertTrue(Idvalues.size() == 3 );
		Assert.assertTrue(Idvalues.get(0) == 1 );
	}
	
	@Test
	public void spElTemplateTests() {
		ExpressionParser parser= new SpelExpressionParser();
		SimplePojo p = new SimplePojo("pojoName");
		String value = parser.parseExpression("This is template concat with => #{name} <=",new TemplateParserContext()).getValue(p,String.class);
		Assert.assertNotNull(value);
		Assert.assertEquals("This is template concat with => pojoName <=", value);;
	}
}
