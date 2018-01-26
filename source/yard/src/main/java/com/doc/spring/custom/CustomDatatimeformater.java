package com.doc.spring.custom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class CustomDatatimeformater implements Formatter<Date> {
	private String pattern;

	SimpleDateFormat sdf = new SimpleDateFormat(pattern);

	public CustomDatatimeformater(String pattern) {
		this.pattern=pattern;
	}
	public String print(Date object, Locale locale) {
		return sdf.format(object);
	}

	public Date parse(String text, Locale locale) throws ParseException {
		return sdf.parse(text);
	}

}
