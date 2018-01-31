package com.doc.spring.spel.functions;

public class SpelFunctionUtils {

	public static String splitValues(String splitter,String... values) {
		StringBuilder content = new StringBuilder("");
		for(String s : values) {
			if(!s.isEmpty()) {
				content.append(s).append(splitter);
			}
		}
		content.setLength(content.length() - splitter.length());
		return content.toString();
	}
}
