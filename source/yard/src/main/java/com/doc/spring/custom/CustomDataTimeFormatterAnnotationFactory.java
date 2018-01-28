package com.doc.spring.custom;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

public class CustomDataTimeFormatterAnnotationFactory  implements AnnotationFormatterFactory<CustomDataTime>{
	
	
	public Set<Class<?>> getFieldTypes() {
		Set<Class<?>> fieldTypes = new HashSet<Class<?>>(4);
		fieldTypes.add(Date.class);
		return Collections.unmodifiableSet(fieldTypes);
		
	}

	public Printer<?> getPrinter(CustomDataTime annotation, Class<?> fieldType) {
			CustomDatatimeformater formater = new CustomDatatimeformater(annotation.pattern());
		return formater;
	}

	public Parser<?> getParser(CustomDataTime annotation, Class<?> fieldType) {
		CustomDatatimeformater formater = new CustomDatatimeformater(annotation.pattern());
		return formater;
	}

}
